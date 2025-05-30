package in.ashok.service;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ashok.bilderclass.ExcepInfo;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value = ProductNotFound.class)
	public  ResponseEntity<ExcepInfo> handlePNFE(ProductNotFound pe){
		
		ExcepInfo info=new ExcepInfo();
		info.setExCode("SBT002");
		info.setExMsg(pe.getMessage());
		info.setExDate(LocalDate.now());
		
		return new ResponseEntity<ExcepInfo>(info,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = Exception.class)
	public  ResponseEntity<ExcepInfo> handleException(Exception pe){
		
		ExcepInfo info=new ExcepInfo();
		info.setExCode("SBT001");
		info.setExMsg(pe.getMessage());
		info.setExDate(LocalDate.now());
		
		return new ResponseEntity<ExcepInfo>(info,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	

}
