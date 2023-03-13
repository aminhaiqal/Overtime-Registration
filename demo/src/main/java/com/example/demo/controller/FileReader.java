package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * _____________________________________________________________________________
 * |  • This class provides methods to read data from an Excel file. 
 * |    It uses the Apache POI library to handle the Excel file format.
 * |  • The class supports reading data from both XLS and XLSX file formats.
 * |  • To use this class, create an instance of the ExcelReader class and 
 * |    call the readExcelFile() method, passing in the path to the Excel 
 * |    file as a parameter.
 * |  • The method returns a List of List of String objects, representing the 
 * |    rows and columns of the Excel sheet.
 * |  • The class also provides a few utility methods to help with parsing cell 
 * |    values and formatting dates.
 * |____________________________________________________________________________
 */

@RestController
public class FileReader {
    @PostMapping("/upload")
    @ResponseBody
    public void readExcelFile(@RequestParam("file") MultipartFile file) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        // Read the Excel file using Apache POI
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        StringBuilder sb = new StringBuilder();

        /*for (int sheetIndex = 1; sheetIndex < 2; sheetIndex++) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row currentRow = sheet.getRow(7);

            try {
                while (currentRow != null) {
                    for (Cell cell : currentRow) {
                        switch (cell.getCellType()) {
                            case STRING:
                                sb.append(cell.getStringCellValue()).append("\t");
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    sb.append(dateFormat.format(cell.getDateCellValue())).append("\t");
                                } else {
                                    sb.append(cell.getNumericCellValue()).append("\t");
                                }
                                break;
                            case BOOLEAN:
                                sb.append(cell.getBooleanCellValue()).append("\t");
                                break;
                            case FORMULA:
                                sb.append(cell.getCellFormula()).append("\t");
                                break;
                            default:
                                sb.append("\t");
                        }

                        String[] result = null;
                        result = splitStringBuilder(sb, "\t");
                        System.out.println(sb.toString());
                        //new AssignString(result);
                        sb.setLength(0);
                    }

                    currentRow = sheet.getRow(currentRow.getRowNum() + 1);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("End of Sheet");
            }
        }*/

        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] splitStringBuilder(StringBuilder sb, String delimiter) {
        String[] result = sb.toString().split(delimiter, -1);
        return result;
    }
}
