package com.Service;

import com.itextpdf.text.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.stereotype.Service;

import com.entity.ProductEntity;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ProductExportService 
{
	public void exportToCSV(List<ProductEntity> products,HttpServletResponse response) throws IOException 
	{

		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=products.csv");

		PrintWriter writer = response.getWriter();
		writer.println("ID,Name,Description,Price,Stock,Customized");

		for (ProductEntity p : products) 
		{
			writer.println(
			p.getProduct_id() + "," +
			p.getProduct_name() + "," +
			p.getDescription() + "," +
			p.getPrice() + "," +
			p.getStock() + "," +
			p.getIsCustomized());
		}
		writer.flush();
	}
	
	public void exportToExcel(List<ProductEntity> products,HttpServletResponse response) throws IOException 
	{

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Products");

		// Header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("ID");
		header.createCell(1).setCellValue("Name");
		header.createCell(2).setCellValue("Description");
		header.createCell(3).setCellValue("Price");
		header.createCell(4).setCellValue("Stock");
		header.createCell(5).setCellValue("Customized");

		int rowNum = 1;
		for (ProductEntity p : products) 
		{
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(p.getProduct_id());
			row.createCell(1).setCellValue(p.getProduct_name());
			row.createCell(2).setCellValue(p.getDescription());
			row.createCell(3).setCellValue(p.getPrice().doubleValue());
			row.createCell(4).setCellValue(p.getStock());
			row.createCell(5).setCellValue(p.getIsCustomized());
		}

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition","attachment; filename=products.xlsx");

		workbook.write(response.getOutputStream());
		workbook.close();
	}
	public void exportToPDF(List<ProductEntity> products,HttpServletResponse response) throws Exception 
	{

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition","attachment; filename=products.pdf");

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

		// Title
		Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
		Paragraph title = new Paragraph("Product List", titleFont);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingAfter(10);
		document.add(title);

		// Table (6 columns)
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100);

		// Header cells
		String[] headers = {
		"ID", "Name", "Description", "Price", "Stock", "Customized"
		};

		for (String h : headers) 
		{
		PdfPCell cell = new PdfPCell(new Phrase(h));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);
		}

		// Data rows
		for (ProductEntity p : products) 
		{
			table.addCell(String.valueOf(p.getProduct_id()));
			table.addCell(p.getProduct_name());
			table.addCell(p.getDescription());
			table.addCell(String.valueOf(p.getPrice()));
			table.addCell(String.valueOf(p.getStock()));
			table.addCell(String.valueOf(p.getIsCustomized()));
		}

		document.add(table);
		document.close();
	}

	public void exportToWord(List<ProductEntity> products, HttpServletResponse response) throws Exception 
	{
	    response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
	    response.setHeader("Content-Disposition", "attachment; filename=products.docx");

	    XWPFDocument document = new XWPFDocument();

	    // Title
	    XWPFParagraph title = document.createParagraph();
	    title.setAlignment(ParagraphAlignment.CENTER);
	    XWPFRun run = title.createRun();
	    run.setText("Product List");
	    run.setBold(true);
	    run.setFontSize(16);

	    // Add a little space after title
	    title.setSpacingAfter(500);

	    // Create table with 6 columns
	    XWPFTable table = document.createTable();

	    // Create header row
	    XWPFTableRow headerRow = table.getRow(0); // First row created by default
	    String[] headers = {"ID", "Name", "Description", "Price", "Stock", "Customized"};
	    for (int i = 0; i < headers.length; i++) {
	        if (i == 0) {
	            headerRow.getCell(0).setText(headers[0]);
	        } else {
	            headerRow.addNewTableCell().setText(headers[i]);
	        }
	    }

	    // Fill data rows
	    for (ProductEntity p : products) {
	        XWPFTableRow row = table.createRow();
	        row.getCell(0).setText(String.valueOf(p.getProduct_id()));
	        row.getCell(1).setText(p.getProduct_name());
	        row.getCell(2).setText(p.getDescription());
	        row.getCell(3).setText(String.valueOf(p.getPrice()));
	        row.getCell(4).setText(String.valueOf(p.getStock()));
	        row.getCell(5).setText(String.valueOf(p.getIsCustomized()));
	    }

	    document.write(response.getOutputStream());
	    document.close();

	}
	public void exportToXML(List<ProductEntity> products, HttpServletResponse response) throws Exception {

	    response.setContentType("application/xml");
	    response.setHeader("Content-Disposition", "attachment; filename=products.xml");

	    StringBuilder xml = new StringBuilder();

	    xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
	    xml.append("<products>\n");

	    for (ProductEntity p : products) {
	        xml.append("  <product>\n");
	        xml.append("    <id>").append(p.getProduct_id()).append("</id>\n");
	        xml.append("    <name>").append(p.getProduct_name()).append("</name>\n");
	        xml.append("    <description>").append(p.getDescription()).append("</description>\n");
	        xml.append("    <price>").append(p.getPrice()).append("</price>\n");
	        xml.append("    <stock>").append(p.getStock()).append("</stock>\n");
	        xml.append("    <customized>").append(p.getIsCustomized()).append("</customized>\n");
	        xml.append("  </product>\n");
	    }

	    xml.append("</products>");

	    response.getWriter().write(xml.toString());
	}

}
