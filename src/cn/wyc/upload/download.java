package cn.wyc.upload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * �ļ�����
 * @author xd
 */
public class download extends ActionSupport {
	private String filename;
	//�ڸ�inputStreamָ������ʱ����ʹ��in
	private InputStream abc;
	public String sayDownload() throws FileNotFoundException {
		//1�ҵ��ļ���ַ
		String realPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files/5.jpg");
		//2���ļ�����һ��inputStream��
		abc = new FileInputStream(realPath);
		filename = "��Ƭ.pic";
		//3����һ���ɹ�
		return SUCCESS;
		//4��һ����stream�Ľ�����Ͱ�ʣ�µ���������
	}
	public InputStream getAbc() {
		return abc;
	}
	public void setAbc(InputStream abc) {
		this.abc = abc;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
