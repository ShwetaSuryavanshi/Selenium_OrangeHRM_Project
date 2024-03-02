package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Readxceldata {
	

	@DataProvider(name="excelldata")
	public String[][] readdataFile(Method m) throws EncryptedDocumentException, IOException {
		String excellsheet= m.getName();
		File f= new File("D:\\Devops\\TestNG_Updated2\\OrangeHRM_Project\\src\\test\\resources\\Excel\\Logintestdata.xlsx");
		FileInputStream fs= new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sheet= wb.getSheet(excellsheet);
		
		int totalRows= sheet.getLastRowNum();
		System.out.println("Excell totalRows"+ totalRows);
		
		Row rowcells= sheet.getRow(0);
		int totalcols= rowcells.getLastCellNum();
		System.out.println("Excell totalcolumns"+ totalcols);
		
		DataFormatter format= new DataFormatter();
		String testdata[][]= new String[totalRows][totalcols];	
		
		for(int i=1; i<=totalRows;i++) {
			for(int j=0; j<totalcols; j++) {
				testdata[i-1][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
				System.out.println("testdata"+testdata[i-1][j]);
				
			}
			
			
		}
		return testdata;
	}

}
