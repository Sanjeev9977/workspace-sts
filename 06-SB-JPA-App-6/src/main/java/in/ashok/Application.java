package in.ashok;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;

import in.ashok.service.EmpDataToExcel;
import in.ashok.service.EmpDataToPdf;
import in.ashok.service.EmpExcelService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		    ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		
		
		try {
			String filePath = new ClassPathResource("excel-file.xlsx").getFile().getAbsolutePath();
			
			System.out.println("Processing Excel file: " + filePath);

	        // Get the ExcelService bean from the context
	        EmpExcelService excelService = context.getBean(EmpExcelService.class);

	        try {
	            // Call the saveExcelData method with the file path
	           // excelService.ExcelDataSave(filePath);
	            System.out.println("Data successfully saved to the database.");
	        } catch (Exception e) {
	            System.err.println("Error processing Excel file: " + e.getMessage());
	        }
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String outputPath = "C:\\Users\\Admin\\Documents\\employees-output.xlsx";
		
		EmpDataToExcel dataToExcel=context.getBean(EmpDataToExcel.class);
		
		//dataToExcel.WriteExcel(outputPath);
       //context.close();
       
       String pdfPath = "C:\\Users\\Admin\\Documents\\employees-output.pdf";
		
		EmpDataToPdf dataTopdf=context.getBean(EmpDataToPdf.class);
		
		dataTopdf.WritePdf(pdfPath);
      context.close();
	}

}
