package cn.wyc.lanjie;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * ����¼��������
 * @author xd
 *
 */
public class CheckLoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//1 ��ȡhttpsession����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//2 ��ȡsession�еĵ�¼���
		Object obj = session.getAttribute("user");
		//3 �ж��Ƿ��е�¼���
		if(obj == null) { //�û�û�е�¼
			return "input";
		}
		//��¼�� ����
		String invoke = arg0.invoke();
		return invoke;
	}

}
