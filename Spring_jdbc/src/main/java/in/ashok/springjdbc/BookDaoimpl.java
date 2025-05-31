package in.ashok.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BookDaoimpl implements BookDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean save(int id,String Name,int price) {
		 
		
		String sql="insert into book values(?,?,?)";
		try {
	        int rowsAffected = jdbcTemplate.update(sql, id, Name, price);
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        // Log the exception or handle it
	        System.out.println("Error inserting record: " + e.getMessage());
	        return false;
	    }
	}

	@Override
	public String findbyid(int id) {
		// TODO Auto-generated method stub
	String sql="SELECT book_name FROM book WHERE book_id = ?";
	 
		

	return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
	}

	@Override
	public List<Book> findAll() {
	    String sql = "SELECT * FROM book";
	    
	    // Use jdbcTemplate.query to retrieve multiple rows and map each row to a Book object
	    return jdbcTemplate.query(sql, new RowMapper<Book>() {
	        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Book book = new Book();
	            book.setBook_id(rs.getInt("book_id"));
	            book.setBook_name(rs.getString("book_name"));
	            book.setBook_price(rs.getInt("book_price"));
	            // Add other fields as necessary
	            return book;
	        }
	    });
	}

	@Override
	public boolean Update(int id, int price) {
		// TODO Auto-generated method stub
		 String sql = "update book set book_price = ? where book_id = ?";
			jdbcTemplate.update(sql,price,id);
	          
			return true;
	}

	@Override
	public boolean delet(int id) {
		// TODO Auto-generated method stub
        String sql = "DELETE FROM book WHERE book_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0;
		 
	}

	 

}
