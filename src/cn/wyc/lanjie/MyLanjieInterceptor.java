package cn.wyc.lanjie;

import java.lang.reflect.InvocationHandler;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * �Զ���������
 * 	1 ����һ����ͨ��̳�AbstractInterceptor��ʵ�ֳ��󷽷�
 *  2 ��Struts������
 *  	1����������
 *  	2ʹ���Զ���������
 * @author xd
 *
 */
public class MyLanjieInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Mylanjie��������-ִ�ж�������֮ǰ");
		//���У��������һ������������ǰ������û�У��͵��ﶯ������
		String invoke = invocation.invoke();
		System.out.println("Mylanjie��������-ִ�ж�������֮��");
		return invoke;
	}

}
