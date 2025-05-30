package hi.sanjeev;

public class Debitcard implements IPeyment {

	@Override
	public boolean payBill(double amt) {
		// TODO Auto-generated method stub
		System.out.println("payment is completed usig debitcard ...");
		return true;
	}
	

}
