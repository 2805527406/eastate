package com.util;

import java.util.Collection;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

import io.goeasy.GoEasy;

@SuppressWarnings("deprecation")
public class DwrPush implements MessageListener{

    public static void sendmes(String msg){
    	 System.out.println("�ҵ�����");
        WebContext webContext = WebContextFactory.get();
        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();
        // �������������JS�ű�
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // ���ÿͻ��˵�js�ű�����
       
        scriptBuffer.appendScript("callback(");
        // ���msg���Ա����˴���һ�£������������Ĵ���������������������
        //scriptBuffer.appendData(msg);
        scriptBuffer.appendScript(")");
        // Ϊ���е��û�����)
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);

    }

	public void onMessage(Message message) {
		System.out.println("��������");
		
	}
}
