package hi.sanjeev;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Restorentbill obj=new Restorentbill(new Debitcard()); //CI
		//obj.peyment=new Debitcard();          // FI
		
		//obj.setPeyment(new Creditcard());     //  SI
		
		
		obj.collectingBill(200.2);

	}

}
