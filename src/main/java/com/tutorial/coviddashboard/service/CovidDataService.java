package com.tutorial.coviddashboard.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tutorial.coviddashboard.model.CovidData;

@Service
public class CovidDataService {

	private static String COVID_DATA_URL = "https://api.covid19india.org/csv/latest/state_wise.csv";

	private List<CovidData> allData = new ArrayList<>();

	public List<CovidData> getAllData() {
		return allData;
	}

	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchVirusData() throws IOException, InterruptedException {
		List<CovidData> newData = new ArrayList<>();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(COVID_DATA_URL)).build();
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		StringReader csvBodyReader = new StringReader(httpResponse.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		for (CSVRecord record : records) {
			CovidData covidstat = new CovidData();
			covidstat.setState(record.get("State"));
			covidstat.setConfirmed(Integer.parseInt(record.get("Confirmed")));
			covidstat.setRecovered(Integer.parseInt(record.get("Recovered")));
			covidstat.setDeaths(Integer.parseInt(record.get("Deaths")));
			covidstat.setActive(Integer.parseInt(record.get("Active")));
			newData.add(covidstat);
		}
		this.allData = newData;
	}

}

