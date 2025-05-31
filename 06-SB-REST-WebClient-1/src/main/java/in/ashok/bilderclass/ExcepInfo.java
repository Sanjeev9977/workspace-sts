package in.ashok.bilderclass;

import java.time.LocalDate;

public class ExcepInfo {
	
	
	
	private String exCode;
	private String exMsg;
	private LocalDate exDate;
	public String getExCode() {
		return exCode;
	}
	public void setExCode(String exCode) {
		this.exCode = exCode;
	}
	public String getExMsg() {
		return exMsg;
	}
	public void setExMsg(String exMsg) {
		this.exMsg = exMsg;
	}
	public LocalDate getExDate() {
		return exDate;
	}
	public void setExDate(LocalDate exDate) {
		this.exDate = exDate;
	}
	@Override
	public String toString() {
		return "ExcepInfo [exCode=" + exCode + ", exMsg=" + exMsg + ", exDate=" + exDate + "]";
	}
	
	

}
