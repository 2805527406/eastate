package org.pojo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
@Alias("users")
public class Users implements Serializable{
private Integer userid;
private String username;
private String password;
private String sex;
private String phone;
private String email;
private String tximg;
private String statu;

public Integer getUserid() {
	return userid;
}

public void setUserid(Integer userid) {
	this.userid = userid;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTximg() {
	return tximg;
}

public void setTximg(String tximg) {
	this.tximg = tximg;
}

public String getStatu() {
	return statu;
}

public void setStatu(String statu) {
	this.statu = statu;
}

@Override
public String toString() {
	return "Users [userid=" + userid + ", username=" + username + ", password=" + password + ", sex=" + sex + ", phone="
			+ phone + ", email=" + email + ", tximg=" + tximg + ", statu=" + statu + ", getUserid()=" + getUserid()
			+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getSex()=" + getSex()
			+ ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail() + ", getTximg()=" + getTximg()
			+ ", getStatu()=" + getStatu() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}




}
