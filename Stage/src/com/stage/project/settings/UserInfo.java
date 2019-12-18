package com.stage.project.settings;

public class UserInfo {
	
	private String fullName;
	 private String email;
	 private String userName;
	 private String password;
	 private String role;
	 
	 public UserInfo(String fullName, String email, String userName, String role) {
		 
		 this.fullName = fullName;
		 this.email = email;
		 this.userName = userName;
		 this.role = role;
	 }
	 
public UserInfo(String email) {
		 
		 this.email = email;
		 
	 }
	 
	 public String getUserName() {
	 return userName;
	 }
	 public void setUserName(String userName) {
	 this.userName = userName;
	 }
	 public String getPassword() {
	 return password;
	 }
	 public void setPassword(String password) {
	 this.password = password;
	 }
	 public void setFullName(String fullName) {
	 this.fullName = fullName;
	 }
	 public String getFullName() {
	 return fullName;
	 }
	 public void setEmail(String email) {
	 this.email = email;
	 }
	 public String getEmail() {
	 return email;
	 }
	 public void setRole(String role) {
	 this.role = role;
	 }
	 public String getRole() {
	 return role;
	 }

}
