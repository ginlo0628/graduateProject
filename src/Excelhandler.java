import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import ProjectUtils.News;
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

	public ArrayList<News> getParsing(String Location) throws BiffException, IOException {

		ArrayList<News> parsingList = new ArrayList<News>();
		InputStream is = new FileInputStream("/Users/apple/Documents/workspace/graduateProject/src/Workbook1.xls");
		jxl.Workbook rwb = Workbook.getWorkbook(is);
		Sheet rs = rwb.getSheet(0);
		int rsColumns = rs.getRows();
		for (int i = 1; i < rsColumns; i++) {
			Cell date = rs.getCell(0, i);
			Cell url = rs.getCell(1, i);
			Cell title = rs.getCell(2, i);
			News temp = new News();
			temp.setTitle(title.getContents());
			temp.setTime(date.getContents());
			temp.setUrl(url.getContents());			
			parsingList.add(temp);
		}
		rwb.close();
		return parsingList;

	}

	public void writeContent(ArrayList<News> writeList,String news_type)
			throws BiffException, IOException, RowsExceededException, WriteException {

		WritableWorkbook workbook = Workbook.createWorkbook(new File("output_"+news_type+".xls"));
		WritableSheet sheet = workbook.createSheet("TEST", 0);

		for (int i = 0; i < writeList.size(); i++) {
			Label label_date = new Label(0, i, writeList.get(i).getTime());
			Label label_url = new Label(1, i, writeList.get(i).getUrl());
			Label label_title = new Label(2, i, writeList.get(i).getTitle());
			Label label_content = new Label(3, i, writeList.get(i).getContent());
			
			sheet.addCell(label_date);
			sheet.addCell(label_url);
			sheet.addCell(label_title);
			sheet.addCell(label_content);
			

		}
		workbook.write();
		workbook.close();
	}

}
