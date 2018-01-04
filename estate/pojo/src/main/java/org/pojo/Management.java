package org.pojo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
//功能管理
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Alias("management")
public class Management implements Serializable{
	private Integer mid;
	private Integer id;
	private Integer parid;
	private String mname;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GTM+8")
	private Date time;
	private String statu;
	//一对多
//	private Collection bulidings=new ArrayList<Buliding>();
	//多对一
	private Grou grou;
	//自身关联（一对多）
	private Collection<Management> managements=new ArrayList<Management>();
	
	
	
	public Collection<Management> getManagements() {
		return managements;
	}
	public void setManagements(Collection<Management> managements) {
		this.managements = managements;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParid() {
		return parid;
	}
	public void setParid(Integer parid) {
		this.parid = parid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
//	public Collection getBulidings() {
//		return bulidings;
//	}
//	public void setBulidings(Collection bulidings) {
//		this.bulidings = bulidings;
//	}
	public Grou getGrou() {
		return grou;
	}
	public void setGrou(Grou grou) {
		this.grou = grou;
	}
	@Override
	public String toString() {
		return "Management [mid=" + mid + ", id=" + id + ", parid=" + parid + ", mname=" + mname + ", time=" + time
				+ ", statu=" + statu + ", bulidings=" + "buliding" + ", grou=" + grou + "]";
	}
	
	
}
