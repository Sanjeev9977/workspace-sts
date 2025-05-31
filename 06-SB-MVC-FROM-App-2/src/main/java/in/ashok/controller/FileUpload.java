package in.ashok.controller;

 
import java.io.IOException;
import java.util.Optional;

import org.hibernate.grammars.hql.HqlParser.JpaSelectObjectSyntaxContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import in.ashok.Service.DocumentService;
import in.ashok.entity.Document;

@Controller
public class FileUpload {
	
	@Autowired
    private	DocumentService service;
    
	
	
	@GetMapping("/file")
	public ModelAndView loadfile() {
		ModelAndView m=new ModelAndView();
		m.addObject("fileObj",new Document());
		m.setViewName("FileUpload");
		return m;
	}
	 
	/*
	 * @PostMapping("/file") public String upload(Model model,Document document) {
	 * 
	 * Boolean save=service.saveData(document); if(save) {
	 * model.addAttribute("fileObj",document);
	 * model.addAttribute("msg","File Uploaded Succsefully"); return "FileUpload";
	 * }else { model.addAttribute("fileObj",document);
	 * model.addAttribute("msg","File Not Uploaded Successfuly"); return
	 * "FileUpload"; } }
	 */
	 
	 @PostMapping("/file")
	 public String upload(@RequestParam("file") MultipartFile file, Model model) {
	     try {
	         if (file.isEmpty()) {
	             model.addAttribute("msg", "File upload failed: No file selected.");
	             return "FileUpload";
	         }

	         Document document = new Document();
	         document.setFileName(file.getOriginalFilename());
	         document.setData(file.getBytes());  // Store file content as byte[]

	         boolean save = service.saveData(document);
	         model.addAttribute("fileObj", document);
	         model.addAttribute("msg", save ? "File Uploaded Successfully" : "File Not Uploaded Successfully");

	         return "FileUpload";
	     } catch (IOException e) {
	         model.addAttribute("msg", "File upload failed: " + e.getMessage());
	         return "FileUpload";
	     }
	 }

	 
	
	 @GetMapping("/load")
	    public String downloadPage() {
	        return "download.html";  // Spring Boot will look in /static folder
	    } 
	 
	  
	 
	 
	 @GetMapping("/download")
	 public ResponseEntity<byte[]> downloadFile(@RequestParam String name) {
	     Optional<Document> documentOpt = service.file(name);

	     if (documentOpt.isEmpty()) {
	         return ResponseEntity.notFound().build();
	     }

	     Document document = documentOpt.get();
	     byte[] fileData = document.getData();

	     if (fileData == null || fileData.length == 0) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                 .body("File content is empty.".getBytes());
	     }

	     System.out.println("Downloading file: " + document.getFileName() + " | Size: " + fileData.length + " bytes");

	     return ResponseEntity.ok()
	             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
	             .header(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate")
	             .header(HttpHeaders.PRAGMA, "no-cache")
	             .header(HttpHeaders.EXPIRES, "0")
	             .contentType(MediaType.APPLICATION_PDF) // Ensure correct content type for PDFs
	             .body(fileData);
	 }


}
