package kr.or.iei.file.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value="mDAO")
public class FileDAO {

	@Autowired
	@Qualifier(value="jdbcTemplate")
	private JdbcTemplate jdbc;
	
	
}
