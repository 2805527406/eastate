package org.pojo;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
//利率管理表
@Alias("rate")
public class Rate implements Serializable {
	private Integer raid;//
	private String nature;//利率性质
	private String retname;//利率名称
	private float rayear;//利率年限1
	private float ret;//利率在5年以内按
	private float reyear2;//利率年限2
	private float ret2;//利率在5-30年按
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GTM+8")
	private Date retime;
	private String statu;//状态
	public Integer getRaid() {
		return raid;
	}
	public void setRaid(Integer raid) {
		this.raid = raid;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getRetname() {
		return retname;
	}
	public void setRetname(String retname) {
		this.retname = retname;
	}
	public float getRayear() {
		return rayear;
	}
	public void setRayear(float rayear) {
		this.rayear = rayear;
	}
	public float getRet() {
		return ret;
	}
	public void setRet(float ret) {
		this.ret = ret;
	}
	public float getReyear2() {
		return reyear2;
	}
	public void setReyear2(float reyear2) {
		this.reyear2 = reyear2;
	}
	
	public float getRet2() {
		return ret2;
	}
	public void setRet2(float ret2) {
		this.ret2 = ret2;
	}
	public Date getRetime() {
		return retime;
	}
	public void setRetime(Date retime) {
		this.retime = retime;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	@Override
	public String toString() {
		return "Lilv [raid=" + raid + ", nature=" + nature + ", retname=" + retname + ", rayear=" + rayear + ", ret="
				+ ret + ", reyear2=" + reyear2 + ", ret2=" + ret2 + ", retime=" + retime + ", statu=" + statu + "]";
	}
	
	
	
}
