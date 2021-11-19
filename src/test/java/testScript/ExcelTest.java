package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest {

	@Test
	public void testOne() throws IOException {
		String[][] srr = excelDP();

		// List<HashMap> list1=new ArrayList<HashMap>();
		// List<HashMap> list11=new ArrayList<HashMap>();
		// HashMap<String, List> map11=new HashMap<String, List>();
		// HashMap<String, String> map1=new HashMap<String, String>();
		//
		// for(int i=1;i<=3;i++) {
		// for(int j=1;j<5;j++) {
		//
		// map1.put(srr[0][j], srr[i][j]);
		// list1.add(map1);
		// map11.put(srr[i][0], list1);
		// }
		//
		// list11.add(map11);
		// System.out.println(list11.get(i-1));
		//
		// }

	}

	public String[][] excelDP() throws IOException {

		String fileName = "C:\\Users\\BIPLAB\\eclipse-workspace\\StartFramework\\src\\test\\java\\testScript\\testdata.xlsx";
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		String sheetName = "Sheet1";
		XSSFSheet sh = wb.getSheet(sheetName);
		XSSFRow row = sh.getRow(0);
		int noOfRows = sh.getPhysicalNumberOfRows();
		int noOfCols = row.getLastCellNum();
		XSSFCell cell;

		DataFormatter format = new DataFormatter();
		String[][] str = new String[5][5];

		noOfRows = sh.getLastRowNum();
		System.out.println(noOfRows);

		String key = null;
		String value = null;
		String mapKey = null;

		Map<String, List<Map<String, String>>> rowMap = null;
		for (int i = 0; i <= noOfRows; i++) // To iterate over all the rows
		{
			try {
				System.out.println("noOfCols" + noOfCols);
				List<Map<String, String>> list = new ArrayList<Map<String, String>>();
				rowMap = new HashMap<String, List<Map<String, String>>>();
				for (int j = 0; j < noOfCols; j++) {
					if (j == 0) {
						XSSFCell c = sh.getRow(i + 1).getCell(j);
						mapKey = c.getStringCellValue();
						continue;
					}
					XSSFCell keyCell = sh.getRow(0).getCell(j);
					key = keyCell.getStringCellValue();

					XSSFCell c = sh.getRow(i + 1).getCell(j);
					if (c.getCellType() == CellType.STRING)
						value = c.getStringCellValue();
					else if (c.getCellType() == CellType.NUMERIC)
						value = String.valueOf(format.formatCellValue(c));

					Map<String, String> map = new HashMap<String, String>();
					map.put(key, value);
					list.add(map);

				}
				//System.out.println(mapKey);
				//System.out.println(list);
				rowMap.put(mapKey, list);
				//mainList.add(rowMap);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println("================");
		System.out.println(rowMap);
		return str;

	}
}
