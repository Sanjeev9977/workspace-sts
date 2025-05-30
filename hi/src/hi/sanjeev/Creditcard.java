package hi.sanjeev;

public class Creditcard implements IPeyment {

	@Override
	public boolean payBill(double amt) {
		 System.out.println("peyment is completed using craditcard...");
		return true;
	}

}
