package com.kim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kim.dao.UserDao;
import com.kim.mapper.UserMapper;
import com.kim.model.User;

import lombok.RequiredArgsConstructor;

@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserMapper userMapper;

	@Override
	public User getUser(String userId) {
		
		return userMapper.getUser(userId);
	}

	@Override
	public int insertUser(User user) {
		
		return userMapper.insertUser(user);
	}

	@Override
	public int updateUser(User user) {
		
		return userMapper.updateUser(user);
	}

	@Override
	public List<User> getUserList() {
		
		return userMapper.getUserList();
	}

	@Override
	public int deleteUser(String userId) {
		
		return userMapper.deleteUser(userId);
	}

	@Override
	public User findId(String name, String email) {
		
		return userMapper.findId(name, email);
	}

	@Override
	public User findPass(String id, String email) {
		
		return userMapper.findPass(id, email);
	}

	@Override
	public List<User> selectAll() {
		
		return userMapper.selectAll();
	}

	@Override
	public int updateRole(int no, String role) {
		
		return userMapper.updateRole(no, role);
	}

	@Override
	public List<User> getAdminPage() {
		
		return userMapper.getAdminPage();
	}

}
