package cn.wyc.convert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * ���󣺰�MM/dd/yyyyת��Ϊ��������
 * 	        �����ݿ��еı������ڸ�ʽת����MM/dd/yyyy���
 * �Զ�������ת����
 * 1 ��дһ���ࡣ�̳���StrutsTypeConverter��ʵ��convertFromString���󷽷�
 * @author xd
 *
 */
public class MyTypeConvert extends StrutsTypeConverter{
	//����һ������ת����
	private DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
    //���ַ����е�����ת��Ϊ����
	//����������⣺
	// Map context����OGNL�������Ķ���������ʱ��֪����������ʱҲ����
	// String[] values��Ҫת��������
	// Class toClass��Ŀ������
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		//1.�ȿ�����û������
		if(values == null || values.length == 0){
			return null;
		}
		//2.ȡ�������еĵ�һ��Ԫ��
		String date = values[0];
		//3.�ж�Ŀ�����͵��ֽ����ǲ�����������
		if(toClass == java.util.Date.class){
			try {
				//4.ʹ��DateFormat����ת�������ҷ���ת����Ľ��
				return format.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	//��������������ת�����ַ���
	//����������⣺
	// Map context����OGNL�������Ķ���������ʱ��֪����������ʱҲ����
	// Object o��Ҫת��������
	@Override
	public String convertToString(Map context, Object o) {
		//1.�ж�object�ǲ�����������
		if(o instanceof Date){
			Date date = (Date)o;
			//2.���������ͣ�ʹ��ת����ת��ָ����ʽ���ַ�����������
			return format.format(date);
		}
		return null;
	}

}
