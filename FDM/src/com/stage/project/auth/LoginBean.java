package com.stage.project.auth;

public class LoginBean
{
private String userName;
private String password;

public String getUserName() {
	System.out.println("Get avviato");
	return userName;
}
public void setUserName(String userName) {
	System.out.println("Set avviato");
this.userName = userName;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
}
