package cn.wyc.strutsparam;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ��̬������װ2 �ֿ�д
 * @author xd
 *
 */
public class param2 extends ActionSupport{
	//��������ģ�Ͷ���
	private User user;
	public String sayParam2() {
		System.out.println(user.getUserName()+"-->"+user.getAge());
		return null;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
