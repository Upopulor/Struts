package cn.wyc.Contextmap;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * struts2��EL���ʽ�ĸı�
 * @author xd
 *
 */
public class context3 extends ActionSupport {
	private String name = "�������е�name";
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("name", "�������е�name");//�����ڴ�map��һ��keyΪСmap�е�ֵ
		return SUCCESS;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
