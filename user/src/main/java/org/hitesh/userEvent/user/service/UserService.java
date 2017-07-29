package org.hitesh.userEvent.user.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hitesh.userEvent.user.database.DatabaseClass;
import org.hitesh.userEvent.user.model.UserModel;
public class UserService
{
	
	private Map<String, UserModel> users = DatabaseClass.getUsers();
	
	public UserService() {

		  users.put("ce1e2dea-7e06-4d2a-9e2d-ea7e068d2a17", new UserModel("ce1e2dea-7e06-4d2a-9e2d-ea7e068d2a17","Htesh", "indore","8897745556","male" ));
		}
	
	/*Method to get all the users*/
	public List<UserModel> getAllUsers()
	{
		return new ArrayList<UserModel>(users.values());
	}
	
	
	/*Use-Case 1: GET specific User*/
	public UserModel getUser(String guid)
	{
		return users.get(guid);
	}
	
	
	
	/*Use-Case 2: GET all user based on gender*/
	public List<UserModel> getAllUserforGender(String gender)
	{
		List<UserModel> userForGender = new ArrayList<>();
		for(UserModel user : users.values())
		{
			if(user.getGender().equals(gender))
			{
				userForGender.add(user);
			}
		}
		return userForGender;
 	}
	
	/*Use-Case 3: GET particular request Attribute */
	public List<UserModel> getSpecificAttribute(String returnAttrs)
	{
		List<UserModel> getSpecificAttributes = new ArrayList<>();
		//String st[]= attribute.split(",");
	 
		for(UserModel user : users.values())
		{
			UserModel user1 = new UserModel();
			if(returnAttrs.contains("name"))
			{
				user1.setName(user.getName());
			}
			if(returnAttrs.contains("guid"))
			{
				user1.setGuid(user.getGuid());
			}if(returnAttrs.contains("gender"))
			{
				user1.setGender(user.getGender());
			}if(returnAttrs.contains("city"))
			{
				user1.setCity(user.getCity());
			}if(returnAttrs.contains("creationTime"))
			{
				user1.setCreationTime(user.getCreationTime());
			}if(returnAttrs.contains("lastUpdationTime"))
			{
				user1.setLastUpdationTime(user.getLastUpdationTime());
			}
			getSpecificAttributes.add(user1);
		}
		return getSpecificAttributes;
	}

	
	/*Use_case 4: GET On pending
	 * 
	 * 
	 * write a method here
	 * 
	 * */
	
	/*Post to add user*/
	public UserModel addUser(UserModel user)
	{
		 UUID uuid = UUID.randomUUID();
	     String randomUUIDString = uuid.toString();
	     user.setGuid(randomUUIDString);
         user.setCreationTime(new Date());
         user.setLastUpdationTime(new Date());
         users.put(user.getGuid(), user);
         return user;
	}
	
	/*PUT method to update the user*/
	public UserModel updateUser(UserModel user)
	{
		if(user.getGuid() == null || !users.containsKey(user.getGuid()))
		{
			return null;
		}
		UserModel use = users.get(user.getGuid());
		user.setCreationTime(use.getCreationTime());
		user.setLastUpdationTime(new Date());
		users.put(user.getGuid(),user);
		return user;
	}
	
	/*Delete Method to remove Users*/
	public UserModel removeUser(String guid)
	{
		if(guid == null || !users.containsKey(guid))
		{
			return null;
		}

		return users.remove(guid);
	}
	
	
	
}