package in.ashok.idGenrateor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import jakarta.persistence.Query;

public class IrctcCustomerId implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
	    Query query = session.createQuery("SELECT MAX(tb.id) FROM TicketBookers tb");
	    String maxid = (String) query.getSingleResult();
	    
	    // Generate current date
	    LocalDate today = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
	    String datePart = today.format(formatter);

	    int nextid = 1; // Default sequence

	    if (maxid != null && !maxid.isEmpty()) {
	        // Ensure maxid starts with "IRCTC-" before extracting
	        if (maxid.startsWith("IRCTC-")) {
	            String existingDate = maxid.substring(6, 12); // Extract the date part
	            
	            if (existingDate.equals(datePart)) {
	                // Extract the sequence number part (after the date)
	                String numPart = maxid.substring(12); // Get the part after "IRCTC-" + date
	                if (!numPart.isEmpty()) {
	                    nextid = Integer.parseInt(numPart) + 1;
	                }
	            }
	        }
	    }
	    
	    return "IRCTC-" + datePart + nextid;
	}


}
