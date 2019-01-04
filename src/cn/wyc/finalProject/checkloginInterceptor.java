package cn.wyc.finalProject;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * ����¼��������
 * @author xd
 *
 */
public class checkloginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		//1��ȡsession
		HttpSession session = ServletActionContext.getRequest().getSession();
		//2��session�л�ȡuser����
		User user = (User) session.getAttribute("user");
		//3.û�� ǰ����¼ҳ��
		if(user == null){
			return "login";
		}
		//4.�� ����
		return arg0.invoke();
		
	}

}
