package in.ashok.generators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import jakarta.persistence.Query;

public class EmpCustomIdGeneratore implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // Query using the entity name (not the table name)
    	//Entity Name in Query: The query now uses Employee as the entity name, not emp_tbl. Hibernate understands this as the class that corresponds to the emp_tbl table.
    	
    	//You're using the string SELECT MAX(e.id) FROM emp_tbl e in your custom ID generator (EmpCustomIdGeneratore), which refers to the table name (emp_tbl).
    	//Hibernate requires you to use the entity class name in HQL queries, not the table name.
    	//Since your entity class is Employee, the correct query should use Employee as the root entity, not emp_tbl.
    	
        Query query = session.createQuery("SELECT MAX(e.eid) FROM Employee e");
        String maxid = (String) query.getSingleResult();

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
