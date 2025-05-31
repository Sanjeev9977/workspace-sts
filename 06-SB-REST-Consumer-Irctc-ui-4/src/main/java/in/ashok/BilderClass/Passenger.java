package in.ashok.BilderClass;

public class Passenger {
	
	
	private String name;
	private String dob;
	private String gender;
	private String doj;
	private String from;
	private String to;
	private String trainNum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", dob=" + dob + ", gender=" + gender + ", doj=" + doj + ", from=" + from
				+ ", to=" + to + ", trainNum=" + trainNum + "]";
	}

}
