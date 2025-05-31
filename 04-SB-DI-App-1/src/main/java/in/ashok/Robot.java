package in.ashok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Robot {
	
	
	 
	//@Qualifier("Chip32")
	@Autowired
	//private IChip Chip32;
	
	private IChip iChip;
	
//	public Robot() {
//		System.out.println("Robot :Constractor");
//	}
	
	
	
//	public Robot(IChip iChip) {
//		System.out.println("Robot :Para constractor"); 
//		this.iChip = iChip;
//	}



	public void workdo() {
	 boolean status=	iChip.process();
	 if(status)
		 System.out.println("Robot is working");
	 else
		 System.out.println("Robot is not workoing");
		
	}

}
