package model;

public class CostModel {

	int week, month, year, nonmember;

	public CostModel(int week, int month, int year, int nonmember) {
		super();
		this.week = week;
		this.month = month;
		this.year = year;
		this.nonmember = nonmember;
	}

	public int getNonmember() {
		return nonmember;
	}

	public void setNonmember(int nonmember) {
		this.nonmember = nonmember;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
