package com.kim.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.kim.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);

	}

	@Override
	public User getUser(String userId) {

		String sql = "SELECT * FROM member_tbl WHERE id = ?";

		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);

		User user = (User) this.jdbcTemplate.queryForObject(sql, mapper, userId);

		return user;
	}

	@Override
	public int insertUser(User user) {

		String SQL_INS = "INSERT INTO member_tbl (id, pass, name, zip, addr1, addr2, phone, email)"
				+ "VALUES(:Id, :pass, :Name, :zip, :addr1, :addr2, :phone, :email)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);

		user.setRole("user");

		return this.jdbcTemplate2.update(SQL_INS, parameterSource);

	}

	@Override
	public int updateUser(User user) {

		String SQL_UP = "update member_tbl set pass=:pass, zip=:zip, addr1=:addr1,"
				+ "addr2=:addr2, phone=:phone, email=:email where id=:id";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
		return this.jdbcTemplate2.update(SQL_UP, parameterSource);
	}

	@Override
	public List<User> getUserList() {

		String SQL = "select * from member_tbl order by no asc";

		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);

		List<User> userList = (List) this.jdbcTemplate.query(SQL, mapper);
		return userList;
	}

	@Override
	public int deleteUser(String userId) {

		String SQL_DEL = "delete from member_tbl where id=?";

		return this.jdbcTemplate.update(SQL_DEL, userId);
	}

	@Override
	public User findId(String name, String email) {

		String SQL = "select * from member_tbl where name=? and email-?";
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		User user = this.jdbcTemplate.queryForObject(SQL, mapper, name, email);
		return user;
	}

	@Override
	public User findPass(String id, String email) {

		String SQL = "select * from member_tbl where id=? and email-?";
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		User user = this.jdbcTemplate.queryForObject(SQL, mapper, id, email);
		return user;
	}

	@Override
	public List<User> selectAll() {

		return null;
	}

	@Override
	public List<User> getAdminPage() {
		String SQL = "SELECT * FROM member_tbl WHERE role = 'admin' ORDER BY no ASC";
		RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);
		return jdbcTemplate.query(SQL, mapper);
	}



	@Override
	public int updateRole(int no, String role) {

		return 0;
	}

}
