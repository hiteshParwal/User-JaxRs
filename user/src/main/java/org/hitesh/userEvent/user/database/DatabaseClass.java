package org.hitesh.userEvent.user.database;

import org.hitesh.userEvent.user.model.UserModel;
import java.util.HashMap;
import java.util.Map;

//this is databse class 
public class DatabaseClass {
	
	private static Map<String, UserModel> users = new HashMap<>();
	

	public static Map<String, UserModel> getUsers()
	{
		return users;
	}
	
}
