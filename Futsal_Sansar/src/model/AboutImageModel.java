package model;

public class AboutImageModel {

	int id;
	String title, url;
	int active;

	public AboutImageModel(int id, String title, String url, int active) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.active = active;
	}
	public AboutImageModel(int id, String title, int active) {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
