package uba.survey.ubasurvey.services;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
public class ExcelService<T> {

    public ByteArrayResource createExcel(List<T> lists) throws IOException {
        Class<?> objClass = lists.get(0).getClass(); // Assuming lists is not empty
        Field[] fields = objClass.getDeclaredFields();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(objClass.getSimpleName());
            int rowIndex = 0;

            // Create header row
            addHeader(sheet, rowIndex++, workbook, fields);

            // Create data rows
            for (T obj : lists) {
                Row row = sheet.createRow(rowIndex++);
                int cellIndex = 0;

                for (Field field : fields) {
                    field.setAccessible(true);
                    Object value = field.get(obj);

                    if (value != null) {
                        if (value instanceof List<?> subList) {
                            Class<?> subObjClass = subList.get(0).getClass(); // Assuming lists is not empty
                            Field[] subFields = subObjClass.getDeclaredFields();
                            for (Object subObj : subList) {
                                for (Field subField : subFields) {
                                    subField.setAccessible(true);
                                    Object subValue = subField.get(subObj);
                                    if (subValue != null) {
                                        row.createCell(cellIndex++).setCellValue(subValue.toString());
                                    } else {
                                        row.createCell(cellIndex++).setCellValue("");
                                    }
                                }
                            }
                        } else {
                            row.createCell(cellIndex++).setCellValue(value.toString());
                        }
                    } else {
                        row.createCell(cellIndex++).setCellValue("");
                    }
                }

            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            workbook.write(byteArrayOutputStream);
            workbook.close();
            return new ByteArrayResource(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            System.out.println("e = " + e);
            throw new IOException("Error creating Excel file", e);
        }
    }

    private void addHeader(Sheet sheet, int rowIndex, Workbook workbook, Field[] fields) {
        Row headerRow = sheet.createRow(rowIndex);
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerCellStyle.setFont(headerFont);

        int cellIndex = 0;
        for (Field field : fields) {
            Cell cell = headerRow.createCell(cellIndex);
            cell.setCellStyle(headerCellStyle);

            // Check if the field is a List
            if (List.class.isAssignableFrom(field.getType())) {
                // If it's a list, get the generic type of the list
                ParameterizedType listType = (ParameterizedType) field.getGenericType();
                Class<?> listClass = (Class<?>) listType.getActualTypeArguments()[0];

                // Get the fields of the list element class
                Field[] listFields = listClass.getDeclaredFields();

                // Add headers for each field in the list element
                for (Field listField : listFields) {
                    Cell listCell = headerRow.createCell(cellIndex);
                    listCell.setCellValue(listField.getName());
                    listCell.setCellStyle(headerCellStyle);
                    cellIndex++;
                }
            }else{
                cell.setCellValue(field.getName());
                cellIndex++;

            }
        }
    }


}
