package model;

public class BookStatusModel {

	int id;
	String date, time;

	int duration, pay, total;

	public BookStatusModel(String date, String time, int duration, int pay) {
		super();
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.pay = pay;
	}

	public BookStatusModel(int id, String date, String time, int duration, int pay, int total) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.pay = pay;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

}
