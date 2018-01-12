package model;

public class ContactModel {

	int id;
	String title, icon, description;
	int active;

	public ContactModel(int id, String title, String icon, String description, int active) {
		super();
		this.id = id;
		this.title = title;
		this.icon = icon;
		this.description = description;
		this.active = active;
	}

	public ContactModel(int id, String icon, String description, int active) {
		super();
		this.id = id;
		this.icon = icon;
		this.description = description;
		this.active = active;
	}

	public ContactModel(int id, String description, int active) {
		super();
		this.id = id;
		this.description = description;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
