package in.ashok.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.entity.EmpExcel;
import in.ashok.repo.EmpExcelRepo;

@Service
public class EmpExcelService {
	
	
	@Autowired
	private EmpExcelRepo excelRepo;
	
	
	public void  ExcelDataSave(String filePath) throws FileNotFoundException, IOException {
		List<EmpExcel>  EmplDatas=new ArrayList<>();
		
		try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) rows.next();

            while (rows.hasNext()) {
                Row row = rows.next();
                EmpExcel employee = new EmpExcel();
                employee.setName(row.getCell(0).getStringCellValue());
                employee.setEmail(row.getCell(1).getStringCellValue());
                employee.setDepartment(row.getCell(2).getStringCellValue());
                EmplDatas.add(employee);
            }
        }
	    excelRepo.saveAll(EmplDatas);
	}
	

}
