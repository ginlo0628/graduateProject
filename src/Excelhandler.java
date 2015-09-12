import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Excelhandler {
	public Excelhandler() {

	}

	public ArrayList<String> getParsing(String Location) throws BiffException, IOException {

		ArrayList<String> parsingList = new ArrayList<String>();
		InputStream is = new FileInputStream("/Users/apple/Documents/workspace/graduateProject/src/Workbook1.xls");
		jxl.Workbook rwb = Workbook.getWorkbook(is);
		Sheet rs = rwb.getSheet(0);
		int rsColumns = rs.getRows();
		for (int i = 1; i < rsColumns; i++) {
			Cell c = rs.getCell(1, i);
			String strc12 = c.getContents();
			parsingList.add(strc12);
		}
		rwb.close();
		return parsingList;

	}

	public void writeContent(ArrayList<String> writeList,String news_type)
			throws BiffException, IOException, RowsExceededException, WriteException {

		WritableWorkbook workbook = Workbook.createWorkbook(new File("output_"+news_type+".xls"));
		WritableSheet sheet = workbook.createSheet("TEST", 0);

		for (int i = 0; i < writeList.size(); i++) {
			Label label = new Label(0, i, writeList.get(i));
			sheet.addCell(label);

		}
		workbook.write();
		workbook.close();
	}

}
