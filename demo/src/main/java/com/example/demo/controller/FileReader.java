package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        // Read the Excel file using Apache POI
        Workbook workbook = WorkbookFactory.create(file.getInputStream());

        // Get the first sheet in the workbook
        Sheet sheet = workbook.getSheetAt(0);

        StringBuilder sb = new StringBuilder();
        // Get the starting row
        Row currentRow = sheet.getRow(3);
        
        // Loop through the rows in the sheet
        while (currentRow != null) {
            // Loop through the cells in the row
            for (Cell cell : currentRow) {
                switch (cell.getCellType()) {
                    case STRING:
                        sb.append(cell.getStringCellValue()).append("\t");
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            sb.append(cell.getDateCellValue()).append("\t");
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
            }
            String[] result = splitStringBuilder(sb, "\t");
            assignString(result);
            sb.setLength(0);
            currentRow = sheet.getRow(currentRow.getRowNum() + 1);
        }
        // Close the workbook using try-with-resources
        try (workbook) {}

    }

    private String[] splitStringBuilder(StringBuilder sb, String delimiter) {
        String[] result = sb.toString().split(delimiter);
        return result;
    }

    public void assignString (String[] result) {
        String staff_id = (result[1]);
        String staff_name = (result[2]);
        String staff_department = (result[3]);
        String staff_section = (result[5]);

        Boolean Monday = parseBoolean(result[9]);
        Boolean Tuesday = parseBoolean(result[10]);
        Boolean Wednesday = parseBoolean(result[11]);
        Boolean Thursday = parseBoolean(result[12]);
        Boolean Friday = parseBoolean(result[13]);
        Boolean Saturday = parseBoolean(result[14]);
        Boolean Sunday = parseBoolean(result[15]);

        new DataLoading(staff_id, staff_name, staff_department, staff_section, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday);
    }

    public boolean parseBoolean(String s) {
        return s != null && !s.isEmpty() && Double.parseDouble(s) != 0.0;
    }
}
