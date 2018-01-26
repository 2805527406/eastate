package com.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.scripting.xmltags.VarDeclSqlNode;
import org.pojo.Buliding;
import org.pojo.Homeimg;
import org.pojo.Management;
import org.pojo.Rate;
import org.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.BackstageService;
import com.sun.org.apache.xpath.internal.functions.Function;
import com.util.Base;
import com.util.Picture;
import com.util.Topic;

@Controller
public class BackstageController {
	@Resource(name="backstageservice")
	private BackstageService bss;
	//查询所有分类管理分类
	@RequestMapping(value="/grou")
	@ResponseBody
	public Object find(){
		return bss.findGrou();
	}
	//查询所有房源管理分类
		@RequestMapping(value="/grou2")
		@ResponseBody
		public Object find2(){
			return bss.findHome();
		}
	
	//查询区域管理
	@RequestMapping(value="/region")
	@ResponseBody
	public Object region(Integer id){
		return bss.findManage(id);
	}
	
	
	//区改
	@RequestMapping(value = "/qugai")
	@ResponseBody
	public Object qugai(Management mage) {
		bss.updateManage(mage);
		return "ok";
	}

	// 区删
	@RequestMapping(value = "/qudel")
	@ResponseBody
	public Object qushan(Integer mid) {
		//先查出是否有子类
		List<Management> s=bss.findManage2(mid);
		if(s!=null){
			for(Management m:s){
				bss.delManage(m.getMid());
			} 
		}
		bss.delManage(mid);
		return "ok";
	}
	//区添
	@RequestMapping(value = "/tianjia")
	@ResponseBody
	public Object tianjia(Management m) {
		if(m.getMid()==0&&m.getMid()!=null){
			bss.addManage(m);
			return "ok";
		}
		if(m.getMid()!=0&&m.getMid()!=null){
			bss.addManage2(m);
			return "ok";
		}
		return "no";
	}
	
	
	
	/********************************************************/
	//查询房子
		@RequestMapping(value="/builder")
		@ResponseBody
		public Object builder(Integer id){
			System.out.println("我进来了呀：+"+id);
			return bss.findBuild(id);
		}
	//区改
		@RequestMapping(value = "/fanggai")
		@ResponseBody
		public Object fanggai(Buliding b) {
			bss.updateBuild(b);
			return "ok";
		}

		// 区删
		@RequestMapping(value = "/fangdel")
		@ResponseBody
		public Object fangshan(Integer id) {
			bss.deleteBulid(id);
			return "ok";
		}
		
		// 区删
		@RequestMapping(value = "/urlList")
		@ResponseBody
		public Object urlList(HttpServletRequest request) throws ParseException {
			
			//先查出是否有子类
				System.out.println("我到这来了");
				String num=request.getParameter("num");
				Date d=new Date();
				System.out.println("数量："+num);
				if(num!=null&&num!="0"){
					String viewimg=request.getParameter("viewimg");
					String image2 = viewimg.substring(viewimg.indexOf(",") + 1);//获取开始截取的位置
					String[] strings3=viewimg.split(",");
					String[] strings4=strings3[0].split("/|;");
					String suffix2=strings4[1];//后缀
					String str2="."+suffix2;
					String pic2=d.getTime()+"ggl"+str2;
					Base.generateImage(image2,"D:\\资源\\三期项目图片路径\\home\\"+pic2);
					Buliding build = obj(request);
					build.setViewimg("/img/"+pic2);
					bss.addbuil(build);
					//图片上传
					int n=Integer.parseInt(num);
					for(int i=1;i<=n;i++){
						String wenjian1=request.getParameter("s"+i);
						
						String image = wenjian1.substring(wenjian1.indexOf(",") + 1);//获取开始截取的位置
						String[] strings=wenjian1.split(",");
						String[] strings2=strings[0].split("/|;");
						String suffix=strings2[1];//后缀
						String str="."+suffix;
						String pic=d.getTime()+i+str;
						Base.generateImage(image,"D:\\资源\\三期项目图片路径\\home\\"+pic);
						Homeimg img=new Homeimg();
						img.setHsrc("/img/"+pic);
						img.setBulid(build.getBulid());
						img.setMid(24);//先给个固定值楼盘图
						bss.addImg(img);
					}
				}
				
				return "ok";
		}
		//和上面的方法紧密相连，整理对象
		public Buliding obj(HttpServletRequest request) throws ParseException{
			Buliding buliding=new Buliding();
			String bulid=request.getParameter("bulid");
			buliding.setBulid(Integer.parseInt(bulid));
			String buliname=request.getParameter("buliname");
			buliding.setBuliname(buliname);
			String reid=request.getParameter("reid");
			buliding.setReid(Integer.parseInt(reid));
			String regnid=request.getParameter("regnid");
			buliding.setRegnid(Integer.parseInt(regnid));
			String sid=request.getParameter("sid");
			buliding.setSid(Integer.parseInt(sid));
			String manid=request.getParameter("manid");
			buliding.setManid(Integer.parseInt(manid));
			String moid=request.getParameter("moid");
			buliding.setMoid(Integer.parseInt(moid));
			String fid=request.getParameter("fid");
			buliding.setFid(Integer.parseInt(fid));
			String jprice=request.getParameter("jprice");
			buliding.setJprice(Float.parseFloat(jprice));
			String starttime=request.getParameter("starttime");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			buliding.setStarttime(sdf.parse(starttime));
			String endtime=request.getParameter("endtime");
			buliding.setEndtime(sdf.parse(endtime));
			String addres=request.getParameter("addres");
			buliding.setAddres(addres);
			String phone=request.getParameter("phone");
			buliding.setPhone(phone);
			
			String district=request.getParameter("district");
			buliding.setDistrict(district);
			String developers=request.getParameter("developers");
			buliding.setDevelopers(developers);
			String licence=request.getParameter("licence");
			buliding.setLicence(licence);
			String jzarea=request.getParameter("jzarea");
			buliding.setJzarea(Float.parseFloat(jzarea));
			String zdarea=request.getParameter("zdarea");
			buliding.setZdarea(Float.parseFloat(zdarea));
			String volume=request.getParameter("volume");
			buliding.setVolume(Float.parseFloat(volume));
			String green=request.getParameter("green");
			buliding.setGreen(Float.parseFloat(green));
			String company=request.getParameter("company");
			buliding.setCompany(company);
			String cost=request.getParameter("cost");
			buliding.setCost(Float.parseFloat(cost));
			String garage=request.getParameter("garage");
			buliding.setGarage(Integer.parseInt(garage));
			String message=request.getParameter("message");
			buliding.setMessage(message);
			String information=request.getParameter("information");
			buliding.setInformation(information);
			return buliding;
		}
	/*******************************************************************************************************/
		//按揭利率的查询
		@RequestMapping(value="/rate")
		@ResponseBody
		public Object findRate(){
			return bss.findRate();
		}
		
		//添加按揭利率 web
			@RequestMapping(value="/addrate")
			@ResponseBody
			public Object  add(Rate rate){
				bss.saverate(rate);
				 //Map<Object,Object> map = new HashMap<Object,Object>();
				 //map.put("rates", bss.findRate());
				
				return "ok";
			}
				
		
		//单独查询按揭利率
		@RequestMapping(value="/loadrate")
		@ResponseBody
		public Object loadrate(Integer raid){
			System.out.println("修改的raid"+raid);
			return bss.loadrate(raid);
		}
		
		//修改按揭利率
		@RequestMapping(value="/updaterate")
		@ResponseBody
		public Object updaterate(Rate rate){
			Rate oldrate= bss.loadrate(rate.getRaid());
			oldrate.setNature(rate.getNature());
			oldrate.setRetname(rate.getRetname());
			oldrate.setRayear(rate.getRayear());
			oldrate.setReyear2(rate.getReyear2());
			oldrate.setRet(rate.getRet());
			oldrate.setRet2(rate.getRet2());
			oldrate.setRetime(rate.getRetime());
			oldrate.setStatu(rate.getStatu());
			
			bss.updaterate(oldrate);
			return "ok";
		}
		
		//删除按揭利率
		@RequestMapping(value="/deleterate")
		@ResponseBody
		public Object deleterate(Integer raid){//raid这个和数据库表中的字段一样
					bss.del(raid);
					return "ok";
		}
		
		/**********************************************************************************************/
	     
		//新楼盘添加
		@RequestMapping(value="/addbuil")
		@ResponseBody
		public Object addbuil(Buliding b ){
			System.out.println("tianjiazhi:"+b);
			bss.addbuil(b);
			return "ok";
		}
		//状态下拉列表查询
		@RequestMapping(value="/findzt")
		@ResponseBody
		public Object findzt(){
			return bss.findzt();
		}
		//区域下拉列表查询
				@RequestMapping(value="/findqy")
				@ResponseBody
				public Object findqy(){
					return bss.findqy();
				}
	  //商圈下拉列表查询
				@RequestMapping(value="/findsq")
				@ResponseBody
				public Object findsq(Integer mid){
					System.out.println("我进来了呀：+"+mid );
					return bss.findsq(mid);
				}
		//楼型下拉列表查询
				@RequestMapping(value="/findlx")
				@ResponseBody
				public Object findlx(){
					return bss.findlx();
				}
		//类型下拉列表查询
				@RequestMapping(value="/findliex")
				@ResponseBody
				public Object findleix(){
					return bss.findleix();
				}
		//类型下拉列表查询
				@RequestMapping(value="/findzhx")
				@ResponseBody
				public Object findzhx(){
					return bss.findzhx();
				}
				
	   //新房楼盘修改加载
				@RequestMapping(value="/loadbiu")
				@ResponseBody
				public Object loadbiu(Integer bulid){
					System.out.println("新房id"+bulid);
					Buliding b=bss.loadbiu(bulid);
					b.setViewimg(subimg(b.getViewimg()));
					if(!b.getHomeimg().isEmpty()){
						ArrayList<Homeimg> homeimg=(ArrayList<Homeimg>)b.getHomeimg();
						for(int i=0;i<homeimg.size();i++){
							homeimg.get(i).setHsrc(subimg(homeimg.get(i).getHsrc()));
						}
						b.setHomeimg(homeimg);
					}
					return b;
				}
				//
				public String subimg(String varchar){
					String[] strings3=varchar.split("/");
					String str=strings3[strings3.length-1];
					String[] strings=str.split("\\.");
					String pre=strings[1];
					String img=Picture.GetImageStr("D:\\资源\\三期项目图片路径\\home\\"+str);
					String prefix="data:image/"+pre+";base64,"+img;
					return prefix;
				}
		//新房楼盘修改加载
				@RequestMapping(value="/updatebiu")
				@ResponseBody
				public Object updatebiu(HttpServletRequest request,String starttime,String endtime) throws ParseException{
					Buliding biu=obj(request);
					System.out.println("修改新房id"+biu);
					Buliding oldbiu =bss.loadbiu(biu.getBulid());
					oldbiu.setBulid(biu.getBulid());
					oldbiu.setBuliname(biu.getBuliname());
					oldbiu.setReid(biu.getReid());
					oldbiu.setRegnid(biu.getRegnid());
					oldbiu.setSid(biu.getSid());
					oldbiu.setManid(biu.getManid());
					oldbiu.setMoid(biu.getMoid());
					oldbiu.setFid(biu.getFid());
					oldbiu.setJprice(biu.getJprice());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					oldbiu.setStarttime(sdf.parse(starttime));
					oldbiu.setEndtime(sdf.parse(endtime));
					oldbiu.setStatu("y");
					oldbiu.setAddres(biu.getAddres());
					oldbiu.setPhone(biu.getPhone());
					oldbiu.setDistrict(biu.getDistrict());
					oldbiu.setDevelopers(biu.getDevelopers());
					oldbiu.setLicence(biu.getLicence());
					oldbiu.setJzarea(biu.getJzarea());
					oldbiu.setZdarea(biu.getZdarea());
					oldbiu.setVolume(biu.getVolume());
					oldbiu.setGreen(biu.getGreen());
					oldbiu.setCompany(biu.getCompany());
					oldbiu.setCost(biu.getCost());
					oldbiu.setGarage(biu.getGarage());
					oldbiu.setMessage(biu.getMessage());
					oldbiu.setInformation(biu.getInformation());
					oldbiu.setMaid(biu.getMaid());
					oldbiu.setHid(1);
					
					System.out.println("我到修改这来了");
					String num=request.getParameter("num");
					Date d=new Date();
					System.out.println("数量："+num);
					if(num!=null&&num!="0"){
						String viewimg=request.getParameter("viewimg");
						String image2 = viewimg.substring(viewimg.indexOf(",") + 1);//获取开始截取的位置
						String[] strings3=viewimg.split(",");
						String[] strings4=strings3[0].split("/|;");
						String suffix2=strings4[1];//后缀
						String str2="."+suffix2;
						String pic2=d.getTime()+"ggl"+str2;
						Base.generateImage(image2,"D:\\资源\\三期项目图片路径\\home\\"+pic2);
						oldbiu.setViewimg("/img/"+pic2);
						bss.updatebiu(oldbiu);
						//图片上传
						int n=Integer.parseInt(num);
						System.out.println("你猜我收到几张图片:"+n);
						bss.delImg(biu.getBulid());//根据房源id删除图片
						for(int i=1;i<=n;i++){
							String wenjian1=request.getParameter("s"+i);
							String image = wenjian1.substring(wenjian1.indexOf(",") + 1);//获取开始截取的位置
							String[] strings=wenjian1.split(",");
							String[] strings2=strings[0].split("/|;");
							String suffix=strings2[1];//后缀
							String str="."+suffix;
							String pic=d.getTime()+i+str;
							Base.generateImage(image,"D:\\资源\\三期项目图片路径\\home\\"+pic);
							Homeimg img=new Homeimg();
							img.setHsrc("/img/"+pic);
							img.setBulid(biu.getBulid());
							img.setMid(24);//先给个固定值楼盘图
							bss.addImg(img);//重新添加图片
						}
					}
				
				 return "ok";
				}
//				@RequestMapping(value="/updatebiu")
//				@ResponseBody
//				public Object updatebiu(HttpServletRequest request) throws ParseException{
//					//System.out.println("修改新房id"+biu);
//					Buliding biu=obj(request);
//					Buliding oldbiu =bss.loadbiu(biu.getBulid());
//					oldbiu.setBulid(biu.getBulid());
//					oldbiu.setBuliname(biu.getBuliname());
//					oldbiu.setReid(biu.getReid());
//					oldbiu.setRegnid(biu.getRegnid());
//					oldbiu.setSid(biu.getSid());
//					oldbiu.setManid(biu.getManid());
//					oldbiu.setMoid(biu.getMoid());
//					oldbiu.setFid(biu.getFid());
//					oldbiu.setJprice(biu.getJprice());
//					oldbiu.setStarttime(biu.getStarttime());
//					oldbiu.setEndtime(biu.getEndtime());
//					oldbiu.setStatu("y");
//					oldbiu.setAddres(biu.getAddres());
//					oldbiu.setPhone(biu.getPhone());
//					//oldbiu.setViewimg(biu.getViewimg());
//					oldbiu.setDistrict(biu.getDistrict());
//					oldbiu.setDevelopers(biu.getDevelopers());
//					oldbiu.setLicence(biu.getLicence());
//					oldbiu.setJzarea(biu.getJzarea());
//					oldbiu.setZdarea(biu.getZdarea());
//					oldbiu.setVolume(biu.getVolume());
//					oldbiu.setGreen(biu.getGreen());
//					oldbiu.setCompany(biu.getCompany());
//					oldbiu.setCost(biu.getCost());
//					oldbiu.setGarage(biu.getGarage());
//					oldbiu.setMessage(biu.getMessage());
//					oldbiu.setInformation(biu.getInformation());
//					oldbiu.setMaid(biu.getMaid());
//					oldbiu.setHid(1);
//				 bss.updatebiu(oldbiu);
//				 return "ok";
//				}	
				
			
				@RequestMapping(value="/dd")
				@ResponseBody
				public String dd(Integer bulid){
					Buliding b=bss.loadbiu(bulid);
					
					return "ok";
				}
				
				//用户
				@RequestMapping(value="/findallu",method={RequestMethod.POST})
				@ResponseBody
				public Object findallu(@RequestParam(name="username") String username,
						@RequestParam(name="password") String password
						){
					System.out.println("username======"+username+"password:"+password);
				    Users users =new Users();
				    users.setUsername(username);
				    users.setPassword(password);
				    //	return bss.findallu();
				//	Users userl=bss.findallu(users);
				//	System.out.println("我等到的值："+userl);
					Map<Object,Object> map=new HashMap<Object, Object>();
					//bss.findallu(username, password);
					Users u=bss.findallu(users);
					if(u==null){
						map.put("e", "ee");
					}else{
						map.put("e", bss.findallu(users));
					}
					
					
					
					return map;
				}		
		
				
				
				
				@RequestMapping(value="/zcpd",method={RequestMethod.POST})
				@ResponseBody//@RequestParam(name="zcusername") String zcusername
				public Object zcpd(Users users){
				    System.out.println("我输出对象："+users);
					Map<Object,Object> map=new HashMap<Object, Object>();
					Users u=bss.findzc(users);
					 System.out.println("我输出对象yyyy："+bss.findzc(users));
					if(u==null){
						bss.adduser(users);
						map.put("e", "addok");
					}else{
						map.put("e", "no");
					}
					return map;
				}	
		
}
