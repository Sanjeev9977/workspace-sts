package in.ashok.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Document {
	
	
	@Id
	@GeneratedValue(generator ="file_custom_id")
	@GenericGenerator(name ="file_custom_id" ,strategy ="in.ashok.idGenrateor.FileCustomId")
	private String id;
	
	private String fileName;

    @Lob  // Marks this field as a Large Object (BLOB)
    @Column(columnDefinition = "LONGBLOB")  // MySQL specific
    private byte[] data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
    
}
