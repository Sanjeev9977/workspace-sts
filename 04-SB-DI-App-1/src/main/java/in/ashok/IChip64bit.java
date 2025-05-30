package in.ashok;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Chip64")
//@Primary
public class IChip64bit implements IChip {
	
	
	public IChip64bit() {
		System.out.println("Chip64bit :constractor");
	}

	@Override
	public boolean process() {
		System.out.println("Chip64bit Processing");
		return false;
	}

}
