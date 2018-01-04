package org.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.ibatis.type.Alias;

//分类管理
@Alias("grou")
public class Grou implements Serializable{
	private Integer id;
	private String gname;
	//一对多
	private Collection managements=new ArrayList<Management>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Collection getManagements() {
		return managements;
	}
	public void setManagements(Collection managements) {
		this.managements = managements;
	}
	@Override
	public String toString() {
		return "Grou [id=" + id + ", gname=" + gname + ", managements=" + managements + "]";
	}
	
	
}
