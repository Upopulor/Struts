package cn.wyc.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class I18nDemo {
	@Test
	public void test1() {
		//ʹ��ResourceBundle��getBundle��ȡ���󣬲�������Դ���ļ�·��+�������������Ի���
		ResourceBundle boudle = ResourceBundle.getBundle("cn.wyc.i18n.message",Locale.CHINA);
		ResourceBundle boudle2 = ResourceBundle.getBundle("cn.wyc.i18n.message",Locale.US);
		String key = boudle.getString("key");
		String key2 = boudle2.getString("key");
		System.out.println(key);
		System.out.println(key2);
	}
}
