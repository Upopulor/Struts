package cn.wyc.strutsRegist;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {
	public static void main(String[] args) {
		String s1 = null;
		String s2 = "";
		String s3 = "  ";
		//�Ƿ�Ϊnull���߿��ַ��������ǲ�ȥ�ո�
		System.out.println(StringUtils.isEmpty(s1));
		System.out.println(StringUtils.isEmpty(s2));
		System.out.println(StringUtils.isEmpty(s3));
		//�Ƿ�Ϊnull�����߿��ַ���������ȥ�ո�
		System.out.println(StringUtils.isBlank(s1));
		System.out.println(StringUtils.isBlank(s2));
		System.out.println(StringUtils.isBlank(s3));
	}
}
