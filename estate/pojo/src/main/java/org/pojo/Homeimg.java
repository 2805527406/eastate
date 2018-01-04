package org.pojo;
//图片管理

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.ibatis.type.Alias;
@Alias("homeimg")
public class Homeimg implements Serializable{
	
	private Integer maid;
	private String hsrc;
	private Integer mid;
	private Integer bulid;
	//一对多
	private Buliding buliding;
	public Integer getMaid() {
		return maid;
	}
	public void setMaid(Integer maid) {
		this.maid = maid;
	}
	public String getHsrc() {
		return hsrc;
	}
	public void setHsrc(String hsrc) {
		this.hsrc = hsrc;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getBulid() {
		return bulid;
	}
	public void setBulid(Integer bulid) {
		this.bulid = bulid;
	}
	public Buliding getBuliding() {
		return buliding;
	}
	public void setBuliding(Buliding buliding) {
		this.buliding = buliding;
	}
	@Override
	public String toString() {
		return "Homeimg [maid=" + maid + ", hsrc=" + hsrc + ", mid=" + mid + ", bulid=" + bulid + ", buliding="
				+ buliding + "]";
	}
	
	
}
