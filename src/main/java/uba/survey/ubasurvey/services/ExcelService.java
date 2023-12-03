package uba.survey.ubasurvey.services;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ExcelService<T> {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ByteArrayResource createExcel(List<T> lists) throws IOException {
        if (lists.size() > 0) {
            Class<?> objClass = lists.get(0).getClass(); // Assuming lists is not empty
            Field[] fields = objClass.getDeclaredFields();

            HashMap<Sheet, Integer> sheetIntegerHashMap = new HashMap<>();

            int cellIndex = 0, rowIndex;


            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet(objClass.getSimpleName());
                CellStyle linkStyle = workbook.createCellStyle();
                Font linkText = workbook.createFont();
                linkText.setUnderline(Font.U_SINGLE);
                linkText.setColor(IndexedColors.BLUE.getIndex());
                linkStyle.setFont(linkText);
                rowIndex = 0;

                // Create header row
                addHeader(sheet, rowIndex++, workbook, fields);

                // Create data rows
                for (T obj : lists) {
                    Row row = sheet.createRow(rowIndex);

                    cellIndex = 0;
                    row.createCell(cellIndex++).setCellValue(rowIndex);

                    for (Field field : fields) {
                        field.setAccessible(true);

                        Object value = field.get(obj);

                        if (value != null) {
                            if (value instanceof List<?>) {
                                Sheet listSheet = workbook.getSheet(field.getName());
                                if (listSheet == null) {
                                    listSheet = workbook.createSheet(field.getName());
                                    sheetIntegerHashMap.put(listSheet, 0);

                                }


                                Hyperlink hyperlink = workbook.getCreationHelper().createHyperlink(HyperlinkType.DOCUMENT);
                                hyperlink.setAddress("'" + listSheet.getSheetName() + "'!A"+(sheetIntegerHashMap.get(listSheet)+2));

                                Cell cell = row.createCell(cellIndex++);
                                cell.setHyperlink(hyperlink);
                                cell.setCellValue(field.getName());
                                cell.setCellStyle(linkStyle);


                                sheetIntegerHashMap.put(listSheet, addListSheet(listSheet, (List<?>) value, sheetIntegerHashMap.get(listSheet), rowIndex, linkStyle));
//                                System.out.println("sublist" );

                            } else {
                                if (value instanceof Double) {
                                    row.createCell(cellIndex++).setCellValue((Double) value);
                                } else if (value instanceof Integer) {
                                    row.createCell(cellIndex++).setCellValue((Integer) value);
                                } else if (value instanceof Date){
                                    row.createCell(cellIndex++).setCellValue(dateFormat.format(value));
                                }else {
                                    row.createCell(cellIndex++).setCellValue(value.toString());
                                }
                            }
                        } else {
                            row.createCell(cellIndex++).setCellValue("");
                        }
                    }
                    rowIndex++;
                }
                for (int j=0; j<workbook.getNumberOfSheets(); j++) {
                    Sheet workSheet = workbook.getSheetAt(j);
                    workSheet.createFreezePane(1,1);

                    for (int i = 0; i < cellIndex; i++) {
                        workSheet.autoSizeColumn(i);
                    }
                }
//                System.out.println("sheetIntegerHashMap = " + sheetIntegerHashMap.values());

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                workbook.write(byteArrayOutputStream);
                workbook.close();
                return new ByteArrayResource(byteArrayOutputStream.toByteArray());
            } catch (Exception e) {
                System.out.println("e = " + e);
                throw new IOException("Error creating Excel file", e);
            }
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Workbook workbook = new XSSFWorkbook();
            workbook.createSheet("Empty");
            workbook.write(byteArrayOutputStream);
            workbook.close();
            return new ByteArrayResource(byteArrayOutputStream.toByteArray());
        }
    }

    private Integer addListSheet(Sheet listSheet, List<?> subList, Integer rowIndex, Integer surveyNo, CellStyle linkStyle) {
        if (rowIndex == 0) {
            
            // Add header row for the list sheet
            addHeader(listSheet, 0, listSheet.getWorkbook(), subList.get(0).getClass().getDeclaredFields());
        }
        int i;
        // Add data rows for the list sheet
        for (i = rowIndex; i < subList.size()+rowIndex; i++) {
            Row row = listSheet.createRow(i + 1);
            int cellIndex = 0;
            Hyperlink hyperlink =  listSheet.getWorkbook().getCreationHelper().createHyperlink(HyperlinkType.DOCUMENT);
            hyperlink.setAddress("'" + listSheet.getWorkbook().getSheetName(0) + "'!A"+(surveyNo+1));

            Cell cell = row.createCell(cellIndex++);
            cell.setHyperlink(hyperlink);
            cell.setCellValue(surveyNo);
            cell.setCellStyle(linkStyle);


            Object subObj = subList.get(i-rowIndex);

            for (Field subField : subObj.getClass().getDeclaredFields()) {
                subField.setAccessible(true);
                try {
                    Object subValue = subField.get(subObj);
                    if (subValue != null) {
                        if (subValue instanceof Double) {
                            row.createCell(cellIndex++).setCellValue((Double) subValue);
                        } else if (subValue instanceof Integer) {
                            row.createCell(cellIndex++).setCellValue((Integer) subValue);
                        } else if (subValue instanceof Date){
                            row.createCell(cellIndex++).setCellValue(dateFormat.format(subValue));
                        }else {
                            row.createCell(cellIndex++).setCellValue(subValue.toString());
                        }
                    } else {
                        row.createCell(cellIndex++).setCellValue("");
                    }
                } catch (IllegalAccessException e) {
                    // Handle exception if needed
                }
            }
        }
        return i;
    }


    private void addHeader(Sheet sheet, int rowIndex, Workbook workbook, Field[] fields) {
        Row headerRow = sheet.createRow(rowIndex);
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerCellStyle.setFont(headerFont);
        int cellIndex = 0;

        Cell cell = headerRow.createCell(cellIndex);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue("Survey No.");
        cellIndex++;

        for (Field field : fields) {
            cell = headerRow.createCell(cellIndex);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue(field.getName());
            cellIndex++;
            // Check if the field is a List


        }
    }


}
