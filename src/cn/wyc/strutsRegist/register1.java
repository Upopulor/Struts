package cn.wyc.strutsRegist;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class register1 extends ActionSupport implements ModelDriven<User>{
	//����һ���û�������ģ�ͣ�ʹ��ģ�������������Լ�ʵ����
	private User user = new User();
	private IUserService us = new UserServiceImpl();
	@Override
	public User getModel() {
		return user;
	}
	/**
	 * ��Struts2�Ŀ����Ҳ�ṩ��һ��MAp<�����ֶ�����������ʾ>
	 *  ���ʽ��֤
	 * 	1���������̳�ActionSupport
	 * 	2����validate����
	 * 
	 * validate�������ڶ�������ִ��֮ǰ������֤
	 *  ����д��validate����������Զ������е����ö�������������֤��
	 *  �����֤���ж������������⣺
	 * 	��һ�ַ�ʽ��
	 * 		ʹ��@SkipValidation��ע��
	 *       �ڶ��ַ�ʽ��
	 *  	������֤���������ƣ�validate+��������  �������Ƶ����ַ���Ҫ��д
	 * @return
	 */
//	public void validateRegister(){
//		if(StringUtils.isEmpty(user.getUsername())){
//			//���������Ϣ��ֱ�ӵ��ø����addFieldError���������������Ϣ����һ�������Ǳ�name���Ե�ֵ���ڶ��������Ǵ�����ʾ
//			addFieldError("username", "�������û���");
//		}
//	}
//	public void validate() {
//		if(StringUtils.isEmpty(user.getUsername())) {
//			//���������Ϣ,ֱ�ӵ��ø����addFieldError���������Ϣ����һ�������Ǳ�name����ֵ���ڶ���������ʾ
//			addFieldError("username", "�������û���");
//		}
//	}
	public String sayRegister1() {
		//�����û�����ȡ���ݿ��û����ж϶����Ƿ����
		User dbUser = us.findUserByName(user.getUsername());
		if(dbUser!=null) {
			return "exists";
		}
		int res = us.register(user);
		if(res > 0) {
			return SUCCESS;
		}
		return null;	
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
