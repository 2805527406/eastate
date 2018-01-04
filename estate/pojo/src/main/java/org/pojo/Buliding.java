package org.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Alias("buliding")
public class Buliding implements Serializable{
	private Integer bulid;
	private String buliname;
	private Integer regnid;
	private Integer sid;
	private Integer  manid;
	private Integer moid;
	private Integer fid;
	private Float jprice;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GTM+8")
	private Date stattime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GTM+8")
	private Date endtime;
	private String addres;
	private String phone;
	private String viewimg;
	private String district;
	private String developers;
	private String licence;
	private Float jzarea;
	private Float zdarea;
	private Float volume;
	private Float green;
	private String company;
	private Float cost;
	private Integer garage;
	private Float message;
	private String information;
	private Integer maid;//图片
	//几个外键吧 多对一
	private Management management;
	//一对多
	private Collection homeimg=new ArrayList<Homeimg>();
	public Integer getBulid() {
		return bulid;
	}
	public void setBulid(Integer bulid) {
		this.bulid = bulid;
	}
	public String getBuliname() {
		return buliname;
	}
	public void setBuliname(String buliname) {
		this.buliname = buliname;
	}
	public Integer getRegnid() {
		return regnid;
	}
	public void setRegnid(Integer regnid) {
		this.regnid = regnid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getManid() {
		return manid;
	}
	public void setManid(Integer manid) {
		this.manid = manid;
	}
	public Integer getMoid() {
		return moid;
	}
	public void setMoid(Integer moid) {
		this.moid = moid;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Float getJprice() {
		return jprice;
	}
	public void setJprice(Float jprice) {
		this.jprice = jprice;
	}
	public Date getStattime() {
		return stattime;
	}
	public void setStattime(Date stattime) {
		this.stattime = stattime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getViewimg() {
		return viewimg;
	}
	public void setViewimg(String viewimg) {
		this.viewimg = viewimg;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getDevelopers() {
		return developers;
	}
	public void setDevelopers(String developers) {
		this.developers = developers;
	}
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	public Float getJzarea() {
		return jzarea;
	}
	public void setJzarea(Float jzarea) {
		this.jzarea = jzarea;
	}
	public Float getZdarea() {
		return zdarea;
	}
	public void setZdarea(Float zdarea) {
		this.zdarea = zdarea;
	}
	public Float getVolume() {
		return volume;
	}
	public void setVolume(Float volume) {
		this.volume = volume;
	}
	public Float getGreen() {
		return green;
	}
	public void setGreen(Float green) {
		this.green = green;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public Integer getGarage() {
		return garage;
	}
	public void setGarage(Integer garage) {
		this.garage = garage;
	}
	public Float getMessage() {
		return message;
	}
	public void setMessage(Float message) {
		this.message = message;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public Integer getMaid() {
		return maid;
	}
	public void setMaid(Integer maid) {
		this.maid = maid;
	}
	public Management getManagement() {
		return management;
	}
	public void setManagement(Management management) {
		this.management = management;
	}
	public Collection getHomeimg() {
		return homeimg;
	}
	public void setHomeimg(Collection homeimg) {
		this.homeimg = homeimg;
	}
	@Override
	public String toString() {
		return "Buliding [bulid=" + bulid + ", buliname=" + buliname + ", regnid=" + regnid + ", sid=" + sid
				+ ", manid=" + manid + ", moid=" + moid + ", fid=" + fid + ", jprice=" + jprice + ", stattime="
				+ stattime + ", endtime=" + endtime + ", addres=" + addres + ", phone=" + phone + ", viewimg=" + viewimg
				+ ", district=" + district + ", developers=" + developers + ", licence=" + licence + ", jzarea="
				+ jzarea + ", zdarea=" + zdarea + ", volume=" + volume + ", green=" + green + ", company=" + company
				+ ", cost=" + cost + ", garage=" + garage + ", message=" + message + ", information=" + information
				+ ", maid=" + maid + ", management=" + management + ", homeimg=" + homeimg + "]";
	}
	
	
}
