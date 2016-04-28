package com.pama.common.view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.pama.common.vo.RssContentVO;

public class ExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception {
	    //CREATE THE SHEET
		HSSFSheet sheet = workbook.createSheet("Widget List");

		//GETCELL: getCell(SHEET, ROW, COLUMN);
		short currentRow = 0;
		//WRITE ROW FOR HEADER
		HSSFCell header0 = getCell(sheet, currentRow, 0); setText(header0, "NAME");
		HSSFCell header1 = getCell(sheet, currentRow, 1);
		setText(header1, "SIZE");
		List<?> widgetList = (List<?>) model.get("excel");
		Iterator<?> widgetListIterator = widgetList.iterator();
		while (widgetListIterator.hasNext())    {
			currentRow++;
			RssContentVO widget = (RssContentVO) widgetListIterator.next();
			HSSFRow row = sheet.createRow(currentRow);
			row.createCell(0)
				.setCellValue(widget.getTitle());
			row.createCell(1)
				.setCellValue(widget.getLink());
		}

	}

}
