package com.pama.common.view;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import org.springframework.beans.factory.annotation.Value;

import com.pama.common.util.RequestUtil;

public class JXLSExcelView extends AbstractExcelView {

	@Value("#{config['template.path']}")
	private String templatePath;

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		XLSTransformer transformer = new XLSTransformer();
		String templateFileName = RequestUtil.getContextRealPath(request) + templatePath + "/excel/rowstyle.xls";
		String destFileName = "1.xls";

		InputStream is = getTemplateSource(templateFileName);
		Workbook resultWorkbook = transformer.transformXLS(is, model);

		StringBuffer contentDisposition = new StringBuffer();
		contentDisposition.append("attachment;fileName=\"");
		contentDisposition.append(destFileName);
		contentDisposition.append("\";");

		response.setHeader("Content-Disposition", contentDisposition.toString());
		response.setContentType("application/x-msexcel");
		resultWorkbook.write(response.getOutputStream());

	}

	private InputStream getTemplateSource(String url) throws Exception {
		return new FileInputStream(new java.io.File(url));
	}


}
