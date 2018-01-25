package com.service;

import java.util.List;

import org.pojo.Buliding;
import org.pojo.Grou;
import org.pojo.Home;
import org.pojo.Homeimg;
import org.pojo.Management;
import org.pojo.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BackstageDao;
@Service("backstageservice")
public class BackstageService {
	@Autowired
	private BackstageDao bsd;
	
	public List<Grou> findGrou(){
		return bsd.findGrou();
	}
	
	public List<Management> findManage(Integer id){
		return bsd.findManage(id);//
	}
	public List<Management> findManage2(Integer id){
		return bsd.findManage2(id);//
	}
	//修改管理
	public void updateManage(Management man){
		bsd.updateManage(man);
	}
	//删除
	public void delManage(Integer man){
		bsd.delManage(man);
	}
	//添加区域
	public void addManage(Management m){
		bsd.addManage(m);
	}
	//添加商圈
		public void addManage2(Management m){
			bsd.addManage2(m);
		}
		
		/********************************************************************************/
		//查询所有房源管理
	public List<Home> findHome(){
		return bsd.findHome();
	}
	public List<Buliding> findBuild(Integer id){
		return bsd.findBulid(id);
	}
	public void updateBuild(Buliding id){
		bsd.updateBulid(id);
	}
	public void deleteBulid(Integer  id){
		bsd.deleteBulid(id);
	}
	
	/*************按揭利率*******************************************************************/
	//查询按揭利率
		public List<Rate> findRate(){
			return bsd.findRate();
		}
		
		//添加按揭利率
		@Transactional
		public void saverate(Rate rate) {
			bsd.save(rate);
		}
		
		//单独查询按揭利率
		public Rate loadrate(Integer id){
			return bsd.loadrate(id);//
		}
		
		//修改按揭利率
		public  void updaterate(Rate rate) {
			bsd.updaterate(rate);
		}
		//删除按揭利率
		public void del(Integer id) {
			bsd.del(id);
		};
		
		/*****************************************************************/
	    //新楼盘添加
		public void addbuil(Buliding b){
			bsd.addbuil(b);
		}
		//状态下拉列表查询
		public List<Management> findzt(){
			return bsd.findzt();
		}
		//区域下拉列表查询
			public List<Management> findqy(){
				return bsd.findqy();
			}
		//商圈下拉列表查询
			public List<Management > findsq(Integer mid){
				return bsd.findsq(mid);
			}
		//楼型下拉列表查询
			public List<Management> findlx(){
				return bsd.findlx();
			}
		//类型下拉列表查询
			public List<Management> findleix(){
				return bsd.findleix();
			}
			//类型下拉列表查询
			public List<Management> findzhx(){
				return bsd.findzhx();
			}
			//新房楼盘修改加载
			public Buliding loadbiu(Integer id){
				return bsd.loadbiu(id);
			}
			//新房楼盘修改
			public void updatebiu(Buliding biu){
			 bsd.updatebiu(biu);
			}
			/*************添加图片****************************************************/
			
			public void addImg(Homeimg img){
				bsd.addImg(img);
			}

}
