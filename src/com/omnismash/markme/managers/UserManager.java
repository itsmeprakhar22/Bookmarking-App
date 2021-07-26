package com.omnismash.markme.managers;

import com.omnismash.markme.dao.UserDao;
import com.omnismash.markme.entities.User;

//Singleton pattern
public class UserManager {
	private static UserManager instance = new UserManager();
	private static UserDao dao = new UserDao();
	
	private UserManager() {
		
	}
	
	public static UserManager getInstance(){
		return instance;
	}
	
	public User createUser(long id, String email, String pwd, String firstName, String lastName, int gender, String userType) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		
		return user;
	}
	
	public User[] getUser() {
		return dao.getUsers();
	}
	
}
