package cn.wyc.lanjie;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class mylanjie2 extends ActionSupport{
	//�û���¼�ķ���
	public String login() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", "suc");
		return SUCCESS;
	}
	//��������ʾ��ҳ������ʾ��һ��ҳ�涼ִ�д˷����������سɹ�
	public String execute() {
		System.out.println("mylanjie2�Ķ�������ִ���� ");
		return SUCCESS;
	}
}
