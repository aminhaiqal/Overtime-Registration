package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.CellType;

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
        Sheet sheet = workbook.getSheetAt(1);
    
        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();
        int colsCount = sheet.getRow(firstRowNum).getPhysicalNumberOfCells();
        String[][] data = new String[lastRowNum - firstRowNum + 1][colsCount];
    
        for (int i = firstRowNum; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue; // Skip blank rows
            }
            for (int j = 0; j < colsCount; j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    data[i - firstRowNum][j] = null; // Assign null to empty cells
                } else {
                    String cellValue;
                    if (cell.getCellType() == CellType.NUMERIC) {
                        double numericValue = cell.getNumericCellValue();
                        if (numericValue == Math.floor(numericValue)) {
                            cellValue = String.format("%.0f", numericValue);
                        } else {
                            cellValue = String.valueOf(numericValue);
                        }
                    } else {
                        cellValue = cell.toString();
                    }
                    data[i - firstRowNum][j] = cellValue;
                }
            }
        }
    
        workbook.close();
    
        /*System.out.println(data[1][0]);
        System.out.println(data[1][1]);
        System.out.println(data[1][2]);
        System.out.println(data[1][4]);*/
        new AssignString(data);
    }

}
