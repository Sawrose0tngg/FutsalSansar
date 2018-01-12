package model;

public class HomeWelcomeModel {

	String title, description, conclusion;
	int id, active;

	public HomeWelcomeModel(int id, String title, String description, String conclusion, int active) {
		super();
		this.title = title;
		this.description = description;
		this.conclusion = conclusion;
		this.id = id;
		this.active = active;
	}

	public HomeWelcomeModel(int id, String title, String description, int active) {
		super();
		this.title = title;
		this.description = description;
		this.id = id;
		this.active = active;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
