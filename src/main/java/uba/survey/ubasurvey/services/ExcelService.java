package uba.survey.ubasurvey.services;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ExcelService<T> {


    public ByteArrayResource createExcel(List<T> lists) throws IOException {
        if (lists.size()>0) {
            Class<?> objClass = lists.get(0).getClass(); // Assuming lists is not empty
            Field[] fields = objClass.getDeclaredFields();
            int cellIndex, rowIndex;


            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet(objClass.getSimpleName());
                rowIndex = 0;

                // Create header row
                addHeader(sheet, rowIndex++, workbook, fields);

                // Create data rows
                for (T obj : lists) {
                    Row row = sheet.createRow(rowIndex);
                    List<Integer> rows = new ArrayList<>();
                    rows.add(rowIndex);
                    cellIndex = 0;

                    for (Field field : fields) {
                        field.setAccessible(true);

                        Object value = field.get(obj);

                        if (value != null) {
                            if (value instanceof List<?> subList) {
                                int cell = cellIndex;

                                Class<?> subObjClass = subList.get(0).getClass(); // Assuming lists is not empty
                                Field[] subFields = subObjClass.getDeclaredFields();
//                            System.out.println("List = " + row.getRowNum() + " " + cellIndex);

                                for (Field subField : subFields) {
                                    subField.setAccessible(true);
                                    Object subValue = subField.get(subList.get(0));
                                    if (subValue != null) {
                                        row.createCell(cellIndex++).setCellValue(subValue.toString());
                                    } else {
                                        row.createCell(cellIndex++).setCellValue("");
                                    }
                                }
                                if (subList.size() > 1) {
                                    rows.add(addMultiple(sheet, rowIndex, cell, subList.subList(1, subList.size())));
                                }

                            } else {
                                row.createCell(cellIndex++).setCellValue(value.toString());
                            }
                        } else {
                            row.createCell(cellIndex++).setCellValue("");
                        }
//                        System.out.println("rows+ Collections.max(rows) = " + rows+ Collections.max(rows));
                        rowIndex = Collections.max(rows) +1;

                    }

//                break;
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
        else{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Workbook workbook = new XSSFWorkbook();
            workbook.createSheet("Empty");
            workbook.write(byteArrayOutputStream);
            workbook.close();
            return new ByteArrayResource(byteArrayOutputStream.toByteArray());
        }
    }

    protected int addMultiple(Sheet sheet,int rowIndex, int colIndex, List<?> subList) throws IllegalAccessException {
        int cellIndex;
        Class<?> subObjClass = subList.get(0).getClass(); // Assuming lists is not empty
        Field[] subFields = subObjClass.getDeclaredFields();

        for (Object subObj : subList) {
            Row row = sheet.createRow(rowIndex);
            cellIndex = colIndex;
//            System.out.println("subList = " + row.getRowNum() + " " + cellIndex);
            for (Field subField : subFields) {
                subField.setAccessible(true);
                Object subValue = subField.get(subObj);
                if (subValue != null) {
                    row.createCell(cellIndex++).setCellValue(subValue.toString());
//                    System.out.println("rowVal ");
                } else {
                    row.createCell(cellIndex++).setCellValue("j");
                }
            }
            rowIndex+=1;
        }
        return rowIndex;
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
