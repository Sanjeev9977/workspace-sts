package in.ashok.beans1;

public class UserDaoImp implements IuserDao {

	public UserDaoImp() {
		System.out.println("0 par constructor for UserDaoImp");
	}
	
	@Override
	public String findName(int id) {
		// TODO Auto-generated method stub
		if(id==100)
			return "sanjeev";
		else if(id==200)
			return "sanjeev shishunal";
		   
		return null;
	}



}
