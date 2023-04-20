package com.pojo;

public class User {

	private Integer userId;
	private String userName;
	private String userAddress;
	private Long userPhoneNumber;
	private String userEmail;
	private String userPassword;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String userName, String userAddress, Long userPhoneNumber, String userEmail,
			String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userPhoneNumber = userPhoneNumber;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public User(String userName, String userAddress, Long userPhoneNumber, String userEmail, String userPassword) {
		super();
		this.userName = userName;
		this.userAddress = userAddress;
		this.userPhoneNumber = userPhoneNumber;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress
				+ ", userPhoneNumber=" + userPhoneNumber + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Long getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(Long userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
