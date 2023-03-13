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
        Sheet sheet = workbook.getSheetAt(0);
    
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
                    String cellValue = cell != null ? cell.toString() : null;
                    data[i - firstRowNum][j] = cellValue;
                }
            }
        }
    
        workbook.close();
    
        // Now you can use the "data" array which contains the values of each cell
        // For example, to print the value of the cell in the second row and third column:
        System.out.println(data[1][1]);
    }

}
