package com.kim.dao;

import java.util.List;

import com.kim.model.User;

public interface UserDao {
	User getUser(String userId);
	
	int insertUser(User user);
	
	int updateUser(User user);
	
	List<User> getUserList();
	
	List<User> getAdminPage();

	int deleteUser(String userId);
	
	User findId(String name, String email);
	
	User findPass(String id, String email);
	
	List<User> selectAll();
	
	int updateRole(int no, String role);
	

}
