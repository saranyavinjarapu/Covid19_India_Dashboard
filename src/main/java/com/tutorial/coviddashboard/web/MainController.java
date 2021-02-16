package com.tutorial.coviddashboard.web;

import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tutorial.coviddashboard.model.CovidData;
import com.tutorial.coviddashboard.service.CovidDataService;

@Controller
public class MainController {

	@Autowired
	CovidDataService covidDataService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home(Model model) {
		List<CovidData> finalCovidData = covidDataService.getAllData();
		int totalReportedCases = finalCovidData.stream().mapToInt(stat -> stat.getConfirmed()).sum();
         		
		model.addAttribute("finalCovidData", finalCovidData);
		model.addAttribute("totalReportedCases", totalReportedCases);
      
		return "data_display";
	}
}

