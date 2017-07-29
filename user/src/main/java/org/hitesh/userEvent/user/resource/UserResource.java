package org.hitesh.userEvent.user.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hitesh.userEvent.user.model.UserModel;
import org.hitesh.userEvent.user.service.UserService;

@Path("/users")
public class UserResource {

	UserService userSer = new UserService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel addUser(UserModel user) {
		return userSer.addUser(user);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserModel> getUsers(@QueryParam("gender") String gender,
			@QueryParam("returnAttrs") String returnAttrs) {
		if (gender != null && returnAttrs != null) {
			List<UserModel> getUsersOfGender = userSer.getAllUserforGender(gender);
			List<UserModel> getAllQueryValue = new ArrayList<>();
			int length = getUsersOfGender.size();
			for (int i = 0; i < length; i++) {
				UserModel user1 = new UserModel();
				UserModel user = getUsersOfGender.get(i);
				if (returnAttrs.contains("name")) {
					user1.setName(user.getName());
				}
				if (returnAttrs.contains("guid")) {
					user1.setGuid(user.getGuid());
				}
				if (returnAttrs.contains("gender")) {
					user1.setGender(user.getGender());
				}
				if (returnAttrs.contains("city")) {
					user1.setPhoneNo(user.getPhoneNo());
				}
				if (returnAttrs.contains("creationTime")) {
					user1.setCreationTime(user.getCreationTime());
				}
				if (returnAttrs.contains("lastUpdationTime")) {
					user1.setLastUpdationTime(user.getLastUpdationTime());
				}
				getAllQueryValue.add(user1);
			}
			return getAllQueryValue;
		} else {
			if (returnAttrs != null) {
				return userSer.getSpecificAttribute(returnAttrs);
			} else if (gender != null) {
				return userSer.getAllUserforGender(gender);
			}

		}
		return userSer.getAllUsers();
	}

	@PUT
	@Path("/{userGuid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel updateUser(@PathParam("userGuid") String guid, UserModel user) {
		user.setGuid(guid);
		return userSer.updateUser(user);
	}
	
	@DELETE
	@Path("/{userGuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("userGuid") String guid)
	{
	    userSer.removeUser(guid);
	}
	
}
