package model;

public class MemberModel {

	int id;
	String name, email, phone, question, answer, gender, memberType, date, time;
	int pay, totalcost;

	public MemberModel(int id, String name, String email, String phone, String question, String answer, String gender,
			String memberType, String date, String time, int pay, int totalcost) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.answer = answer;
		this.gender = gender;
		this.memberType = memberType;
		this.date = date;
		this.time = time;
		this.pay = pay;
		this.totalcost = totalcost;
	}

	public MemberModel(int id, String name, String email, String date, String time, String memberType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.memberType = memberType;
		this.date = date;
		this.time = time;
	}

	public MemberModel(int id, String name, String email, String phone, String question, String answer, String gender,
			int pay) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.answer = answer;
		this.gender = gender;
		this.pay = pay;
	}

	public MemberModel(int id, String name, String email, String phone, String question, String answer, String gender,
			String memberType) {
		super();
		this.id = id;
		this.name = name.toUpperCase();
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.answer = answer;
		this.gender = gender;
		this.memberType = memberType;
	}

	public MemberModel(int id, String name, String email, String phone, String gender, int pay) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.pay = pay;
	}

	public MemberModel(int id, String name, String phone, String time) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.time = time;
	}

	public MemberModel(int id, String name, String phone, String date, String time) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.date = date;
		this.time = time;
	}

	public MemberModel(int id, String memberType) {
		super();
		this.id = id;
		this.memberType = memberType;
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

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

}
