package com.report.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.report.entity.CitizenPlan;
import com.report.repo.CitizenPlanRepository;
import com.report.request.SearchRequest;
import com.report.util.EmailUtils;
import com.report.util.ExcelGenerator;
import com.report.util.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

	// private final DataLoader dataLoader;

	@Autowired
	private CitizenPlanRepository planRepo;
	@Autowired
	private ExcelGenerator excelGenerator;
	@Autowired
	private PdfGenerator pdfGenerator;
     @Autowired
	private EmailUtils emailUtils;

//
//    ReportServiceImpl(DataLoader dataLoader) {
//        this.dataLoader = dataLoader;
//    }

	@Override
	public List<String> getPlanNames() {

//		List<String> list1 = planRepo.getPlanNames();
//		return list1;

		return planRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {

		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan entity = new CitizenPlan();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {

			String startDate = request.getStartDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// convert string to local date
			LocalDate localDate = LocalDate.parse(startDate, formatter);

			entity.setPlanStartDate(localDate);

		}

		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {

			String endDate = request.getEndDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// convert string to local date
			LocalDate localDate = LocalDate.parse(endDate, formatter);

			entity.setPlanEndDate(localDate);

		}

		// BeanUtils.copyProperties(request, entity);
		return planRepo.findAll(Example.of(entity));
		// based of entity query construct
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {

		File f = new File("plans.xls");
		
		List<CitizenPlan> plans = planRepo.findAll();

		excelGenerator.generate(response, plans,f);

		String subject = "Test mail Subject  ";
		String body = "<h1>Test mail body </h1>";
		String to = "vickychaudhary14130@gmail.com";
		
	//	File f = new File("plans.xls");

		emailUtils.sendEmail(subject, body, to,f);
		f.delete();
        // delete the file in folder
		
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {

		File f = new File("plans.pdf");
		 
		List<CitizenPlan> plans = planRepo.findAll();

		pdfGenerator.generate(response, plans,f);
		String subject = "Test mail Subject  ";
		String body = "<h1>Test mail body </h1>";
		String to = "vickychaudhary14130@gmail.com";
		
		//	File f = new File("plans.xls");

		emailUtils.sendEmail(subject, body, to,f);
		f.delete();
        // delete the file in folder

		return true;
	}

}
