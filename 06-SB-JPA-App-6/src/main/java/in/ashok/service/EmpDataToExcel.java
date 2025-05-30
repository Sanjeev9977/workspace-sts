package in.ashok.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.RowId;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.entity.EmpExcel;
import in.ashok.repo.EmpExcelRepo;

@Service
public class EmpDataToExcel {
	@Autowired
	private EmpExcelRepo empExcelRepo;
	
	
	public void WriteExcel(String filepath) throws FileNotFoundException, IOException {
		
		List<EmpExcel>  Emps=empExcelRepo.findAll();
		
		Workbook workbook=new XSSFWorkbook();
		 Sheet  sheet=workbook.createSheet("Employee");
		 
		 Row  headerrow=sheet.createRow(0);
		 
		 headerrow.createCell(0).setCellValue("ID");
		 headerrow.createCell(1).setCellValue("name");
		 headerrow.createCell(2).setCellValue("email");
		 headerrow.createCell(3).setCellValue("department");
		 
		 int Rowinx=1;
		 for(EmpExcel Emp:Emps) {
			 
			 Row row=sheet.createRow(Rowinx++);
			 row.createCell(0).setCellValue(Emp.getId());
			 row.createCell(1).setCellValue(Emp.getName());
			 row.createCell(2).setCellValue(Emp.getEmail());
			 row.createCell(3).setCellValue(Emp.getDepartment());
			 
			 
			 
		 }
		 
		try(FileOutputStream file=new FileOutputStream(filepath)){
			workbook.write(file);
		}
        workbook.close();
        System.out.println("Data exported to Excel file: " + filepath);
		
		
	}
	

}
