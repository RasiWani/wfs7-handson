package com.hsbc.springbootdataapp.model.sevice;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsbc.springbootdataapp.model.beans.User;
import com.hsbc.springbootdataapp.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User createUser(User user) {
		User createdUser = userDao.save(user); // save method takes the object and maps to the table
		return createdUser;
	}

	@Override
	public List<User> fetchUsers() {
		List<User> usersList = userDao.findAll(); // findAll method takes all the records and gives you the List of User
		return usersList;
	}

	@Override
	public User fetchUserById(int id) {
		// TODO Auto-generated method stub
		User userById=userDao.findById(id).get();
		return userById;
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);
	}

	@Override
	public User updateDob(int id, LocalDate dob) {
		// TODO Auto-generated method stub
		//System.out.println(dob);
		User user=userDao.findById(id).get();
		user.setDob(dob);
		userDao.save(user);
		//System.out.println(user);
		return user;
	}

}
