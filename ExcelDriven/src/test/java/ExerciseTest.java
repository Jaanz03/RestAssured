import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExerciseTest {
	
	public ArrayList getDetails(String	studentname) throws IOException {
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream	fis = new FileInputStream("C://Users//vjansi//eclipse-workspace//ExcelDriven//Book.xlsx");
		XSSFWorkbook	workbook = new XSSFWorkbook(fis);
		int	sheets=workbook.getNumberOfSheets();
		for (int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("excersise")) {
				XSSFSheet	sheet=workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator(); //collection of rows
				Row  firstrow = rows.next();
				int k=0;
				int column=0;
				Iterator<Cell> cells = firstrow.cellIterator();
				while(cells.hasNext()){
					Cell value = cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("Name")) {
						column = k;
						System.out.println(column);
					}
					k++;
				}
				while(rows.hasNext()) {
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(studentname)) {
						Iterator<Cell>  cv=r.cellIterator();
						while(cv.hasNext())
						{
						Cell c=	cv.next();
						if(c.getCellType()==CellType.STRING)
						{
							
						a.add(c.getStringCellValue());
						}
						else{
							
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						
						}
						}
						
					}
				}
				
			}
		}
		return a;
		
		
	}
	

}

