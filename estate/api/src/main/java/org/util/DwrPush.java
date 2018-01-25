package org.util;

import java.util.Collection;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

@SuppressWarnings("deprecation")
public class DwrPush {

    public static void Send(String msg){
        WebContext webContext = WebContextFactory.get();

        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();

        // �������������JS�ű�
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // ���ÿͻ��˵�js�ű�����
        scriptBuffer.appendScript("callback(");
        // ���msg���Ա����˴���һ�£������������Ĵ���������������������
        scriptBuffer.appendData(msg);
        scriptBuffer.appendScript(")");
        // Ϊ���е��û�����)
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);


    }

}
