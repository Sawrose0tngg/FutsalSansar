package model;

import java.sql.Blob;

public class HomeTitleModel {

	String headName, headDes, active;
	int id;
	Blob img1, img2;

	public HomeTitleModel(int id, String headName, String headDes, String active) {
		super();
		this.id = id;
		this.headName = headName;
		this.headDes = headDes;
		if (active.equals("checked")) {
			this.active = "1";
		} else {
			this.active = "0";
		}
	}

	public Blob getImg1() {
		return img1;
	}

	public void setImg1(Blob img1) {
		this.img1 = img1;
	}

	public Blob getImg2() {
		return img2;
	}

	public void setImg2(Blob img2) {
		this.img2 = img2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeadName() {
		return headName;
	}

	public void setHeadName(String headName) {
		this.headName = headName;
	}

	public String getHeadDes() {
		return headDes;
	}

	public void setHeadDes(String headDes) {
		this.headDes = headDes;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
