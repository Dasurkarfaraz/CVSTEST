import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.Test;

public class ReadandWriteExcel {

 public static void main(String []args){

  try {

  // Specify the file path which you want to create or write

  File src=new File("C:\\\\Users\\\\faraz\\\\eclipse-workspace\\\\CVSTEST\\\\ReportWithReponse\\\\data.xlsx");

  // Load the file

  FileInputStream fis=new FileInputStream(src);

   // load the workbook

   XSSFWorkbook wb=new XSSFWorkbook(fis);

  // get the sheet which you want to modify or create

   XSSFSheet sh1= wb.getSheetAt(0);

 // getRow specify which row we want to read and getCell which column
   int RowCount = sh1.getLastRowNum();
   System.out.println(RowCount);
   int rowsum = RowCount+1;
// here createCell will create column

// and setCellvalue will set the value
//
// sh1.getRow(0).createCell(2).setCellValue("2.41.0");
//
// sh1.getRow(1).createCell(2).setCellValue("2.5");
//
// sh1.getRow(2).createCell(2).setCellValue("2.39");

 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	String CurrentDate = dtf.format(now);
	Row r =sh1.createRow(rowsum);
	sh1.getRow(rowsum).createCell(2).setCellValue(CurrentDate);
	FileOutputStream  FW = new FileOutputStream(src);
// here we need to specify where you want to save file



// finally write content 

 wb.write(FW);

// close the file

 FW.close();

  } catch (Exception e) {

   System.out.println("Error");

  }

 }

}
 