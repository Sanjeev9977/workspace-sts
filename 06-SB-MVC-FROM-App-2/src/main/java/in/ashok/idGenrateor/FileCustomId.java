package in.ashok.idGenrateor;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import jakarta.persistence.Query;

public class FileCustomId implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		// TODO Auto-generated method stub
	Query	query=session.createQuery("SELECT MAX(d.id) FROM Document d");
	String maxid = (String) query.getSingleResult();
	int nextid=1;
	if(maxid !=null && !maxid.isEmpty()) {
		
		String numpart=maxid.replaceAll("[^0-9]", "");
		if (!numpart.isEmpty()) {
            nextid = Integer.parseInt(numpart) + 1;  // Increment the numeric part
        }
	}
		
	return "File" + nextid;
	}

}
