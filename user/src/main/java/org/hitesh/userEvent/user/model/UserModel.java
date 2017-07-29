package org.hitesh.userEvent.user.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class UserModel {

	private String guid;
	private String name;
	private String city;
	private String phoneNo;
	private String gender;
	private Date creationTime;
	private Date lastUpdationTime;

	public UserModel() {
	}

	public UserModel(String guid, String name, String city, String phoneNo, String gender) {
		this.guid = guid;
		this.name = name;
		this.city = city;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.creationTime = new Date();
		this.lastUpdationTime = new Date();
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastUpdationTime() {
		return lastUpdationTime;
	}

	public void setLastUpdationTime(Date lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}

}
