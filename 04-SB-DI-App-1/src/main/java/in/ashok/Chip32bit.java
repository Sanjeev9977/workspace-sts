package in.ashok;

import org.springframework.stereotype.Component;

@Component("Chip32")
public class Chip32bit implements IChip {
	
	public  Chip32bit() {
		System.out.println("Chip32bit :Constractor");
	}

	@Override
	public boolean process() {
		 System.out.println("Chip32bit processing");
		return true;
	}

}
