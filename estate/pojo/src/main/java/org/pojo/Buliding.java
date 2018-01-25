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
	private Integer bulid;//id*
	private Integer hid;//所属类型
	private String buliname;//楼盘名称*
	private Integer reid;//区域id*
	private Integer regnid;//商圈id
	private Integer sid;//状态id
	private Integer  manid;//楼型id
	private Integer moid;//类型id*
	private Integer fid;//装修度id*
	private Float jprice;//参考价格/二手房单价
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GTM+8")
	private Date starttime;//开盘时间/二手房的建成时间（年代）
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GTM+8")
	private Date endtime;//交房时间
	private String addres;//地址*
	private String phone;//联系电话*
	private String viewimg;//列表封面图片
	private String district;//学区所属
	private String developers;//开发商
	private String licence;//许可证
	private Float jzarea;//建筑面机
	private Float zdarea;//占地面积
	private Float volume;//容积面积
	private Float green;//绿化面积
	private String company;//物业公司
	private Float cost;//物业费
	private Integer garage;//车库
	private String message;//优惠信息/二手房的房源描述*
	private String information;//周边配套*
	private Integer maid;//图片*
	private String statu;//状态
	//几个外键吧 多对一类型
	private Management management;
	//一对多图片
	private Collection homeimg=new ArrayList<Homeimg>();
	//多对一房源类型类型
	private Home home;
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

	public Integer getReid() {
		return reid;
	}
	public void setReid(Integer reid) {
		this.reid = reid;
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
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
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
	
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public Home getHome() {
		return home;
	}
	public void setHome(Home home) {
		this.home = home;
	}
	
	
	public Integer getRegnid() {
		return regnid;
	}
	public void setRegnid(Integer regnid) {
		this.regnid = regnid;
	}
	
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	@Override
	public String toString() {
		return "Buliding [bulid=" + bulid + ", hid=" + hid + ", buliname=" + buliname + ", reid=" + reid + ", regnid="
				+ regnid + ", sid=" + sid + ", manid=" + manid + ", moid=" + moid + ", fid=" + fid + ", jprice="
				+ jprice + ", starttime=" + starttime + ", endtime=" + endtime + ", addres=" + addres + ", phone=" + phone
				+ ", viewimg=" + viewimg + ", district=" + district + ", developers=" + developers + ", licence="
				+ licence + ", jzarea=" + jzarea + ", zdarea=" + zdarea + ", volume=" + volume + ", green=" + green
				+ ", company=" + company + ", cost=" + cost + ", garage=" + garage + ", message=" + message
				+ ", information=" + information + ", maid=" + maid + ", management=" + management + ", homeimg="
				+ homeimg + ", home=" + home + "]";
	}
	
	
	
}
