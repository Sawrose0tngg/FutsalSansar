package model;

public class BookContentModel {

	int id;
	String title, titleDes, bulletDes, conclueDes;
	int active;

	public BookContentModel(int id, String title, String titleDes, String bulletDes, String conclueDes, int active) {
		super();
		this.id = id;
		this.title = title;
		this.titleDes = titleDes;
		this.bulletDes = bulletDes;
		this.conclueDes = conclueDes;
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

	public String getTitleDes() {
		return titleDes;
	}

	public void setTitleDes(String titleDes) {
		this.titleDes = titleDes;
	}

	public String getBulletDes() {
		return bulletDes;
	}

	public void setBulletDes(String bulletDes) {
		this.bulletDes = bulletDes;
	}

	public String getConclueDes() {
		return conclueDes;
	}

	public void setConclueDes(String conclueDes) {
		this.conclueDes = conclueDes;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
