package cn.itcast.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UploadFileService {
    private Workbook wb;
		//½âÎöexcelÎÄ¼þ
	public ArrayList<ArrayList<String>> f2m() throws Exception{
		ArrayList<ArrayList<String>> rowal= new ArrayList<ArrayList<String>>();
		wb = new XSSFWorkbook(new FileInputStream("C:/tomcat7/webapps/car2car4/upload/UploadTestData.xlsx"));
	    for (int i = 0; i <= wb.getActiveSheetIndex(); i++) {
            System.out.println("sheet" + (i + 1));
            Sheet sheet = wb.getSheetAt(i);
            for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
                Row row = sheet.getRow(j);
                ArrayList<String> cellal= new ArrayList<String>();
                for (int z = 0; z < row.getPhysicalNumberOfCells(); z++) {
                    cellal.add(row.getCell(z).toString());
                }
                rowal.add(cellal);
                System.out.println();
            }
        }
	    return rowal;
	}
}
