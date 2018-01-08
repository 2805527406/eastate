package org.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.ibatis.type.Alias;

@Alias("home")
public class Home implements Serializable{
	private Integer hid;
	private String hname;
	
	private Collection buliding=new ArrayList<Buliding>();

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public Collection getBuliding() {
		return buliding;
	}

	public void setBuliding(Collection buliding) {
		this.buliding = buliding;
	}

	@Override
	public String toString() {
		return "Home [hid=" + hid + ", hname=" + hname + ", buliding=" + buliding + "]";
	}
	
	
	
}
