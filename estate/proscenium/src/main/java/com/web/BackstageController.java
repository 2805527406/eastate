package com.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.api.ServiceAPI;
import org.pojo.Buliding;
import org.pojo.Homeimg;
import org.pojo.Management;
import org.pojo.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.BackstageService;
import com.sun.org.apache.xpath.internal.functions.Function;
import com.util.Base;

@Controller
public class BackstageController {
	@Resource(name="api")
	private ServiceAPI bss;
	/********************************************************/
	//查询房子****
		@RequestMapping(value="/builder")
		@ResponseBody
		public Object builder(Integer id){
			System.out.println("我进来了呀：+"+id);
			return bss.findBuild(id);
		}
	   //新房楼盘修改加载***
				@RequestMapping(value="/loadbiu")
				@ResponseBody
				public Object loadbiu(Integer bulid){
					System.out.println("新房id"+bulid);
					return bss.loadbiu(bulid);
				}
}
