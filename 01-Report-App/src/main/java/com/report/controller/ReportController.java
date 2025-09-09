package com.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.report.entity.CitizenPlan;
import com.report.request.SearchRequest;
import com.report.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
//@RequestMapping("/hello")
public class ReportController {

	@Autowired
	private ReportService service;

	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response,Model model) throws Exception {

		response.setContentType("application/pdf");

		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		
		
		boolean status = service.exportPdf(response);
		if(status)
		{  
			model.addAttribute("msg","Pdf Report send your Email");
		
		}
		
	}

	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response,Model model) throws Exception {
		// octel-stream for excel file
		response.setContentType("application/octel-stream");

		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
		//service.exportExcel(response);
		
		boolean status = service.exportPdf(response);
		if(status)
		{  
			model.addAttribute("msg","Excel Report send your Email");
		
		}
	}

	@PostMapping("/search")
	public String handleSearch(SearchRequest search, Model model) {

		// System.out.println(search);

		List<CitizenPlan> plans = service.search(search);
		model.addAttribute("plans", plans);

		model.addAttribute("search", search); // instead of this we can use model attribute
		// in method @modelAtribute(("search) SearchRequest search, Model model) like
		// this
		init(model);
		return "index";
	}

	@GetMapping("/")
	public String indexPage(Model model) {

		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";

	}

	private void init(Model model) {

		model.addAttribute("names", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatuses());
	}
	
	
	
}
