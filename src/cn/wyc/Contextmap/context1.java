package cn.wyc.Contextmap;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ����actioncontext������
 * @author xd
 *
 */
public class context1 extends ActionSupport {
	public String execute() {
		//1�õ�actionContext����
		ActionContext ct = ActionContext.getContext();//�ӵ�ǰ�̵߳ľֲ������л�ȡ����
		//2��contextmap�д�������
		ct.put("contextMap", "hello1"); //������ֱ�Ӵ浽��map
		//��session�д�����
		//1 ��ȡkeyֵΪsession��map
		Map<String,Object> sessionAttribute = ct.getSession();//�õ�keyֵΪsession��Сmap
		sessionAttribute.put("sessionMap", "hellosessionmap");
		//2ֱ��ʹ��ԭʼ��httpSession����
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("sessionMap1", "hellosessionmap1");
		
		//��ServletContext���д�����
		//1��ȡkeyֵΪapplication��map
		Map<String, Object> app = ct.getApplication();
		app.put("applicationMap", "hello application");
		//2ֱ�ӻ�ȡԭʼ��ServletContext����
		ServletContext appl = ServletActionContext.getServletContext();
		appl.setAttribute("applicationMap1", "hello application1");
		
		return SUCCESS;
	}
}
