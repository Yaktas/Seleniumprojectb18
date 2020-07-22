package test.officeHours;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelIO {

    //workbook
    //sheet
    //row
    //XSSFWorkbook = to create an object of .xlsx file
    //HSSFWorkbook = to create an object of .xls file
    //Workbook - an interface that is implemented by XSSFWorkbook and HSSFWorkbook

    @Test
    public void readExcelFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream("VytrackTestUsers.xlsx");

            Workbook workbook = WorkbookFactory.create(fileInputStream);

            Sheet sheet = workbook.getSheet("QA1-short");


            Row row = sheet.getRow(0);

            Cell cell = row.getCell(0);

            System.out.println(cell);



            int columnNumber = row.getPhysicalNumberOfCells();

            for(int i = 0; i < columnNumber; i++){
                System.out.print(row.getCell(i) +" ");
            }

            System.out.println();
            int rowNumber = sheet.getPhysicalNumberOfRows();

            /*
            for(int i = 0; i < rowNumber; i++){
                System.out.print(sheet.getRow(i).getCell(0) +"     ");
                System.out.print(sheet.getRow(i).getCell(1) +"     ");
                System.out.print(sheet.getRow(i).getCell(2) +"     ");
                System.out.print(sheet.getRow(i).getCell(3) +"     ");
                System.out.println();
            }

             */

            String[][] dataTable = new String[rowNumber][columnNumber];

            for(int rowIndex = 0; rowIndex < rowNumber; rowIndex++){
                for(int columnIndex = 0; columnIndex < columnNumber; columnIndex++){
                    String value = sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
                    System.out.format("%15s", value);
                    dataTable[rowIndex][columnIndex] = value;
                }
                System.out.println();
            }





        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void writeIntoExcelFile(){
        //input stream - read
        //output stream - write
        //NOTE: close excel file during writing. Otherwise, file will crash.
        try(FileInputStream fileInputStream = new FileInputStream("VytrackTestUsers.xlsx")){
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("QA1-short");
            Row row = sheet.getRow(1); //get second row
            //write PASSED to 2nd row 6th column
            row.getCell(5).setCellValue("PASSED");
            FileOutputStream fileOutputStream = new FileOutputStream("VytrackTestUsers.xlsx");
            workbook.write(fileOutputStream); //to write updates to the file
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
