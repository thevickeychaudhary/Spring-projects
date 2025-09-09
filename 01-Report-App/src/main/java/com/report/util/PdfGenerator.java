package com.report.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.openpdf.text.Document;
import org.openpdf.text.Font;
import org.openpdf.text.FontFactory;
import org.openpdf.text.PageSize;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import com.report.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {

	public void generate(HttpServletResponse response, List<CitizenPlan> plans,File file) throws Exception {
		Document document = new Document(PageSize.A4);
 
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
		

		document.open();

		// creating font

		Font fontTittle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTittle.setSize(20);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("Citizen Plans", fontTittle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(paragraph);

		PdfPTable table = new PdfPTable(6);
		// spacing table to paragraph
		table.setSpacingBefore(5);

		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date ");

		// List<CitizenPlan> plans = planRepo.findAll();

		for (CitizenPlan plan : plans) {

			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate() + "");
			table.addCell(plan.getPlanEndDate() + "");

		}

		document.add(table);

		document.close();
	}

}
