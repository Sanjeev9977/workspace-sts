package in.ashok.generatore;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;

public class EmpCustomIdGeneratore implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // Query using the entity name (not the table name)
        // Entity Name in Query: The query now uses Employee as the entity name, not emp_tbl. Hibernate understands this as the class that corresponds to the emp_tbl table.
        
        // Correcting the query to use Employee as the entity and not the table name
        Query<String> query = session.createQuery("SELECT MAX(e.eid) FROM Employee e", String.class);
        String maxid = query.getSingleResult(); // Get the current maximum ID

        int nextId = 1;  // Default starting value
        if (maxid != null && !maxid.isEmpty()) {
            // Extract the numeric part of the ID (e.g., from "Emp1" to "1")
            String numberPart = maxid.replaceAll("[^0-9]", "");  // Remove non-numeric characters
            if (!numberPart.isEmpty()) {
                nextId = Integer.parseInt(numberPart) + 1;  // Increment the numeric part
            }
        }

        // Return the new ID in the format "Emp1", "Emp2", etc.
        return "Emp" + nextId;
    }
}
