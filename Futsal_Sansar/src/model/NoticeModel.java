package model;

public class NoticeModel {

	int id;
	String title;
	int active;

	public NoticeModel(int id, String title, int active) {
		super();
		this.id = id;
		this.title = title;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
