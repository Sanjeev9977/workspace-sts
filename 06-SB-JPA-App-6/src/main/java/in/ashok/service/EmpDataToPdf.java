package in.ashok.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import in.ashok.entity.EmpExcel;
import in.ashok.repo.EmpExcelRepo;
 

@Service
public class EmpDataToPdf {
	
	@Autowired
	private EmpExcelRepo excelRepo;
	
	public void WritePdf(String filePath) throws FileNotFoundException {
       
		
		List<EmpExcel>   Emps=excelRepo.findAll();
		PdfWriter writer = new PdfWriter(new FileOutputStream(filePath));
		PdfDocument document=new PdfDocument(writer);
		Document document2=new Document(document);
		
		document2.add(new Paragraph("User Data Report").setBold().setFontSize(16));
		
		Table table=new Table(4);
		table.addCell(new Cell().add(new Paragraph("ID")));
		table.addCell(new Cell().add(new Paragraph("Name")));
		table.addCell(new Cell().add(new Paragraph("Email")));
		table.addCell(new Cell().add(new Paragraph("Department")));
		
		for(EmpExcel emp:Emps) {
			
			table.addCell(new Cell().add(new Paragraph(emp.getId().toString())));
            table.addCell(new Cell().add(new Paragraph(emp.getName())));
            table.addCell(new Cell().add(new Paragraph(emp.getEmail())));
            table.addCell(new Cell().add(new Paragraph(emp.getDepartment())));
		}

		document2.add(table);

        // Close document
        document.close();

        System.out.println("PDF exported successfully to: " + filePath);
		
	}
	

}
