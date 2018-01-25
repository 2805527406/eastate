package com.util;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Topic {
	@Resource(name="jms")
	private JmsTemplate jmsTemplate;
	public void sendss(){
		jmsTemplate.send(new MessageCreator(){
			public Message createMessage(Session session) throws JMSException {
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("op","send");
				ObjectMapper om=new ObjectMapper();//1
				String str="";
				try {
					str = om.writeValueAsString(map);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}//2  借助spring将map解析成json文本
				return session.createTextMessage(str);
			}
		});
	}
}
