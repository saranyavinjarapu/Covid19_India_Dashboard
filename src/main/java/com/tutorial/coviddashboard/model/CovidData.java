package com.tutorial.coviddashboard.model;

public class CovidData {

	private String state;
    private int confirmed;
    private int recovered;
    private int deaths;
    private int active;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	public int getRecovered() {
		return recovered;
	}

	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "CovidData{" + "state='" + state + '\'' + "confirmed='" + confirmed + '\'' + "recovered='"
				+ recovered + '\'' + "deaths='" + deaths + '\'' + "active='" + active + '\'' + '}';
	}
}

