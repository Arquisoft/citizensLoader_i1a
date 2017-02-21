package es.uniovi.asw.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.User;

public class ReaderImpl implements Reader{

	List<User> users = new ArrayList<User>();
	@Override
	public List<User> readFile(String path) {
		try
        {
			
			
			//Load the .xlsx
            FileInputStream file = new FileInputStream(new File(path));
            
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            DataFormatter formatter = new DataFormatter();
            int counter = 0;
            
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) 
            {
            	String[] values = new String[8];
            	counter = 0;
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 
                while (cellIterator.hasNext()) 
                {
                	Cell cell = cellIterator.next();
                	
                    // Take the cell value as a String
                    String value = formatter.formatCellValue(cell);
                    
                    // Add it to the array
                    values[counter] = value;
                    counter++;
                }
                
                User user = new User(values[0], values[1], values[2], values[4], values[5], values[6]);
                //user.setDateOfBirth(Date.valueOf(values[3]));
                users.add(user);
                
                System.out.println("");
            }
            file.close();
            
        }catch(IOException e){
        	e.printStackTrace();
        }
		return users;
	}

}
