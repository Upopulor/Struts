package cn.wyc.Contextmap;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ����һ��С����
 * @author xd
 *
 */
public class context7 extends ActionSupport implements ModelDriven<Customer>{
	//����һ��ģ�ͣ������Լ�ʵ����
	private Customer customer = new Customer();
	public String context7() {
		System.out.println(customer);
		return null;
	}
	@Override
	public Customer getModel() {
		return customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
