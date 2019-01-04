package cn.wyc.strutsfirst;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

import cn.dsna.util.images.ValidateCode;

/**
 * �Զ���������
 *  1 ��д��ͨ�࣬�̳�StrutsResultSupport����д����
 * @author xd
 *
 */
public class MyResult extends StrutsResultSupport{

	//ͨ�������ļ�����������ͼƬ�Ĵ�С
		private int width;
		private int height;
	@Override
	protected void doExecute(String arg0, ActionInvocation arg1) throws Exception {
		/*
		 * ʹ�õ�����������֤���jar��
		 * 	 1.����ValidateCode.jar������libĿ¼
		 * 	 2.����ValidateCode�Ķ���
		 * 	 3.��ȡ��Ӧ���������
		 * 	 4.����������
		 */
		//����ValidateCode�Ķ���
		//������⣺1:ͼ���� 2.ͼ��߶� 3.���ֵĸ�ʽ 4.����������
		ValidateCode code = new ValidateCode(width,height,4,10);
		//��ȡ��Ӧ����
		HttpServletResponse response = ServletActionContext.getResponse();
		//����������
		code.write(response.getOutputStream());
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
