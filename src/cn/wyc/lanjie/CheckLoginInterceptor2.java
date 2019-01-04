package cn.wyc.lanjie;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * ����¼��������2��
 * @author xd
 *
 */
public class CheckLoginInterceptor2 extends MethodFilterInterceptor{

	@Override
	public String doIntercept(ActionInvocation arg0) throws Exception {
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
