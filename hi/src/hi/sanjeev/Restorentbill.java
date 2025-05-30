package hi.sanjeev;

public class Restorentbill  {
	
	IPeyment peyment;
	
	
	
	
	public Restorentbill(IPeyment peyment) {
		 
		this.peyment = peyment;
	}



	public void setPeyment(IPeyment peyment) {
		this.peyment=peyment;
		
	}
	
	
	
	public void collectingBill(double amt) {
		
		boolean status=peyment.payBill(amt);
		
		if(status)
			System.out.println("peyment is sucessfull");
		else
			System.out.println("cord is denaided");
		
	}

}
