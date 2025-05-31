package in.ashok.bean2;

import in.ashok.beans1.IuserDao;

public class UserServiceImp implements UserService {
	
	private IuserDao IuserDao;
	
	public UserServiceImp(IuserDao IuserDao) {
		System.out.println("par constructor for UserServiceImp");
		this.IuserDao=IuserDao;
	}
	

	public UserServiceImp() {
		System.out.println("0 par constructor for UserServiceImp");
	}

	@Override
	public String getName(int id) {
		// TODO Auto-generated method stub
		return IuserDao.findName(id);
	}

}
