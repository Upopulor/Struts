package cn.wyc.strutsparam;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ��̬������װ3 ģ������
 * ʵ��ģ�������Ĳ���
 * 		1ʵ��һ��ModelDrivern�Ľӿ�
 * 	    2ʵ�ֽӿ��еķ���getModel()
 *      3��ʹ��ʱ������Ҫ�Լ�ʵ����ģ�Ͷ���
 * ����һ��ModeDrivern��������Ϊ�������ģ�ʵ�ʿ���ʹ�õ�
 * @author xd
 *
 */
public class param3 extends ActionSupport implements ModelDriven<User>{
	//��������ģ�Ͷ���
	private User user = new User();
	public String sayParam2() {
		System.out.println(user.getUserName()+"-->"+user.getAge());
		return null;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
