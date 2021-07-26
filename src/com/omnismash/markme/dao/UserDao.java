package com.omnismash.markme.dao;

import com.omnismash.markme.DataStore;
import com.omnismash.markme.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
