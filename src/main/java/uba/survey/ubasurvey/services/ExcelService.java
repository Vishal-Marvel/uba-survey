package uba.survey.ubasurvey.services;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import uba.survey.ubasurvey.DTO.ExcelDTO;
import uba.survey.ubasurvey.DTO.ExcelFieldObject;
import uba.survey.ubasurvey.DTO.FieldResponse;
import uba.survey.ubasurvey.DTO.SectionResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class ExcelService {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    HashMap<Sheet, Integer> sheetIntegerHashMap = new HashMap<>();


    public ByteArrayResource createExcel(ExcelDTO excelDTO) throws IOException {
        if (excelDTO.getFieldDatas().size() > 0) {


            int cellIndex = 0, rowIndex;

            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet(excelDTO.getFieldData().getSurveyName());
                CellStyle linkStyle = workbook.createCellStyle();
                Font linkText = workbook.createFont();
                linkText.setUnderline(Font.U_SINGLE);
                linkText.setColor(IndexedColors.BLUE.getIndex());
                linkStyle.setFont(linkText);
                rowIndex = 0;

                // Create header row
                addHeader(sheet, rowIndex++, workbook, excelDTO.getFieldData().getSections());

//                 Create data rows
                for (String response : excelDTO.getResponses()) {
                    Row row = sheet.createRow(rowIndex);

                    cellIndex = 0;
                    row.createCell(cellIndex++).setCellValue(rowIndex);


                    for (SectionResponse sectionResponse : excelDTO.getFieldData().getSections()) {
                        for (FieldResponse fieldResponse : sectionResponse.getFields()) {

                            cellIndex = addFields(excelDTO, response, fieldResponse, workbook, rowIndex,row, cellIndex, linkStyle);
                        }
                    }
                    rowIndex++;
                }
                for (int j = 0; j < workbook.getNumberOfSheets(); j++) {
                    Sheet workSheet = workbook.getSheetAt(j);
                    workSheet.createFreezePane(1, 1);

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

    private Integer addFields(ExcelDTO excelDTO, String response, FieldResponse fieldResponse, Workbook workbook, Integer rowIndex, Row row, Integer cellIndex, CellStyle linkStyle){
        List<ExcelFieldObject> value = excelDTO.getFieldDatas().stream().filter((excelFieldObject -> Objects.equals(excelFieldObject.getResponseId(), response) && Objects.equals(excelFieldObject.getFieldId(), fieldResponse.getId()))).toList();

        if (!value.isEmpty()) {
            ExcelFieldObject object = value.get(0);
            if (Objects.equals(fieldResponse.getFieldType(), "COUNTER")) {
                Sheet listSheet = workbook.getSheet(fieldResponse.getQuestion());
                if (listSheet == null) {
                    listSheet = workbook.createSheet(fieldResponse.getQuestion());
                    sheetIntegerHashMap.put(listSheet, 0);
                }
                Hyperlink hyperlink = workbook.getCreationHelper().createHyperlink(HyperlinkType.DOCUMENT);
                hyperlink.setAddress("'" + listSheet.getSheetName() + "'!A" + (sheetIntegerHashMap.get(listSheet) + 2));

                Cell cell = row.createCell(cellIndex++);
                cell.setHyperlink(hyperlink);
                cell.setCellValue(Integer.parseInt(object.getAnswers().get(0)));
                cell.setCellStyle(linkStyle);

                sheetIntegerHashMap.put(listSheet, addListSheet(excelDTO, response, listSheet, Integer.parseInt(object.getAnswers().get(0)), fieldResponse.getSubfields(), sheetIntegerHashMap.get(listSheet), rowIndex, linkStyle));
//                                System.out.println("sublist" );

            } else {
                if (Objects.equals(fieldResponse.getFieldType(), "INTEGER") || Objects.equals(fieldResponse.getFieldType(), "COUNTER")) {
                    row.createCell(cellIndex++).setCellValue(Integer.parseInt(object.getAnswers().get(0)));
                } else if (Objects.equals(fieldResponse.getFieldType(), "DATE")) {
                    row.createCell(cellIndex++).setCellValue(dateFormat.format(object.getAnswers().get(0)));
                } else if (Objects.equals(fieldResponse.getFieldType(), "MSQ")){
                    row.createCell(cellIndex++).setCellValue(String.join(", ", object.getAnswers()));
                }else {
                    row.createCell(cellIndex++).setCellValue(object.getAnswers().get(0));
                }
            }
        } else {
            row.createCell(cellIndex++).setCellValue("");

        }
        if (fieldResponse.getYESField()!=null){
            cellIndex = addFields(excelDTO, response, fieldResponse.getYESField(), workbook, rowIndex,row, cellIndex, linkStyle);

        }
        if (fieldResponse.getNoField()!=null) {
            cellIndex = addFields(excelDTO, response, fieldResponse.getNoField(), workbook, rowIndex,row, cellIndex, linkStyle);

        }
        if (!Objects.equals(fieldResponse.getFieldType(), "COUNTER") && fieldResponse.getSubfields() != null && fieldResponse.getSubfields().size()>0) {
            for (FieldResponse subFieldResponse : fieldResponse.getSubfields()) {
                cellIndex = addFields(excelDTO, response, subFieldResponse, workbook, rowIndex,row, cellIndex, linkStyle);
            }
        }
        return  cellIndex;
    }

    private Integer addListSheet(ExcelDTO excelDTO, String response, Sheet listSheet,Integer count, List<FieldResponse> fieldResponses, Integer rowIndex, Integer surveyNo, CellStyle linkStyle) {
        if (rowIndex == 0) {
            Row headerRow = listSheet.createRow(rowIndex);
            CellStyle headerCellStyle = listSheet.getWorkbook().createCellStyle();
            Font headerFont = listSheet.getWorkbook().createFont();
            headerFont.setBold(true);
            headerCellStyle.setFont(headerFont);
            int cellIndex = 0;

            Cell cell = headerRow.createCell(cellIndex);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue("Survey No.");
            cellIndex++;
            cell = headerRow.createCell(cellIndex);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue("S. No. ");
            cellIndex++;

            for (FieldResponse subField : fieldResponses) {
                cellIndex = addHeaderSubFields(headerRow, cellIndex, subField, headerCellStyle);
            }
        }
        int i;
        // Add data rows for the list sheet
        for (i = rowIndex; i < count + rowIndex; i++) {
            Row row = listSheet.createRow(i + 1);
            int cellIndex = 0;
            Hyperlink hyperlink = listSheet.getWorkbook().getCreationHelper().createHyperlink(HyperlinkType.DOCUMENT);
            hyperlink.setAddress("'" + listSheet.getWorkbook().getSheetName(0) + "'!A" + (surveyNo + 1));

            Cell cell = row.createCell(cellIndex++);
            cell.setHyperlink(hyperlink);
            cell.setCellValue(surveyNo);
            cell.setCellStyle(linkStyle);

            cell = row.createCell(cellIndex++);
            cell.setCellValue((Integer)i-rowIndex+1);


            for (FieldResponse subField : fieldResponses) {
                cellIndex = addListSheetSubFields(excelDTO, response, subField, i, rowIndex, row, cellIndex);
            }
        }
        return i;
    }

    private Integer addListSheetSubFields(ExcelDTO excelDTO, String response, FieldResponse subField, Integer finalI, Integer rowIndex, Row row, Integer cellIndex){
        List<ExcelFieldObject> subValue = excelDTO.getFieldDatas().stream().filter((excelFieldObject) ->
                Objects.equals(excelFieldObject.getResponseId(), response) && Objects.equals(excelFieldObject.getFieldId(), subField.getId()) && excelFieldObject.getCounter()==finalI-rowIndex).toList();
        if (!subValue.isEmpty()) {
            ExcelFieldObject object = subValue.get(0);
            if (Objects.equals(subField.getFieldType(), "INTEGER") || Objects.equals(subField.getFieldType(), "COUNTER")) {
                row.createCell(cellIndex++).setCellValue(Integer.parseInt(object.getAnswers().get(0)));
            } else if (Objects.equals(subField.getFieldType(), "DATE")) {
                row.createCell(cellIndex++).setCellValue(dateFormat.format(object.getAnswers().get(0)));
            } else if (Objects.equals(subField.getFieldType(), "MSQ")){
                row.createCell(cellIndex++).setCellValue(String.join(", ", object.getAnswers()));
            }else {
                row.createCell(cellIndex++).setCellValue(object.getAnswers().get(0));
            }
        } else {
            row.createCell(cellIndex++).setCellValue("");
        }
        if (subField.getYESField()!=null){
            cellIndex = addListSheetSubFields(excelDTO, response, subField.getYESField(), finalI, rowIndex, row, cellIndex);

        }
        if (subField.getNoField()!=null){
            cellIndex = addListSheetSubFields(excelDTO, response, subField.getNoField(), finalI, rowIndex, row, cellIndex);

        }
        if (!Objects.equals(subField.getFieldType(), "COUNTER") && subField.getSubfields() != null && subField.getSubfields().size()>0) {
            for (FieldResponse subFieldResponse : subField.getSubfields()) {
                cellIndex = addListSheetSubFields(excelDTO, response, subFieldResponse, finalI, rowIndex, row, cellIndex);
            }
        }


        return cellIndex;
    }

    private void addHeader(Sheet sheet, int rowIndex, Workbook workbook, List<SectionResponse> sectionResponses) {
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

        for (SectionResponse sectionResponse : sectionResponses) {
            for (FieldResponse fieldResponse : sectionResponse.getFields()) {
                cellIndex = addHeaderSubFields(headerRow, cellIndex, fieldResponse, headerCellStyle);
            }
        }
    }

    private Integer addHeaderSubFields(Row headerRow, int cellIndex, FieldResponse fieldResponse, CellStyle headerCellStyle) {

        Cell cell = headerRow.createCell(cellIndex);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(fieldResponse.getQuestion());
        cellIndex++;
        if (fieldResponse.getYESField() != null) {
            cellIndex = addHeaderSubFields(headerRow, cellIndex, fieldResponse.getYESField(), headerCellStyle);
        }
        if (fieldResponse.getNoField() != null) {
            cellIndex = addHeaderSubFields(headerRow, cellIndex, fieldResponse.getNoField(), headerCellStyle);
        }
        if (!Objects.equals(fieldResponse.getFieldType(), "COUNTER") && fieldResponse.getSubfields() != null && fieldResponse.getSubfields().size()>0) {
            for (FieldResponse subFieldResponse : fieldResponse.getSubfields()) {
                cellIndex = addHeaderSubFields(headerRow, cellIndex, subFieldResponse, headerCellStyle);
            }
        }

        return cellIndex;
    }


}
