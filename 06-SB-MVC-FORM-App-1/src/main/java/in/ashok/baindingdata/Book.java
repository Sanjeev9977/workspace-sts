package in.ashok.baindingdata;

public class Book {
	
	private String BookName;
	private String Bookathor;
	private String BookPrrice;
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getBookathor() {
		return Bookathor;
	}
	public void setBookathor(String bookathor) {
		Bookathor = bookathor;
	}
	public String getBookPrrice() {
		return BookPrrice;
	}
	public void setBookPrrice(String bookPrrice) {
		BookPrrice = bookPrrice;
	}
	@Override
	public String toString() {
		return "Book [BookName=" + BookName + ", Bookathor=" + Bookathor + ", BookPrrice=" + BookPrrice + "]";
	}
	 
	
	
	

}
