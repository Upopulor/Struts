package cn.wyc.upload;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * struts2���ļ��ϴ����Ű��� 
 * @author xd
 *
 */
public class upload2 extends ActionSupport {
	//�����ṩ���ֶ�
	private String username;
	private File[] photo;
	//Struts2���ļ��ϴ�ʱ�ṩ������
	private String[] photoFileName; //�ϴ��ļ������ϴ��ֶ�����+FileName��ע���Сд
	private String[] photoContentType; //�ϴ��ļ���MIME���ͣ��ϴ��ֶ�����+ContentType��ע���Сд
	public String sayUpload() {
		//1 �õ�ServletContext
		ServletContext application = ServletActionContext.getServletContext();
		//2����realpath��������ȡ����һ������Ŀ¼�õ���ʵĿ¼
		String realPath = application.getRealPath("/WEB-INF/files");
		//3 ��������ʵ��Ŀ¼�����ڣ���Ҫ����
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//4 ��photo���ȥ
		// ��������photo����ʱ�ļ����Ƶ�ָ����λ�ã�ע�⣬��ʱ�ļ�����
		//FileUtils.copyFile(photo, new File(file,photoFileName));
		//���У�����ʱ�ļ����е�ָ����λ�ã�����������,ע����ʱ�ļ�������
		for(int i = 0 ;i < photo.length;i++) {
			photo[i].renameTo(new File(file,photoFileName[i]));
		}
		return null;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public File[] getPhoto() {
		return photo;
	}
	public void setPhoto(File[] photo) {
		this.photo = photo;
	}
	public String[] getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String[] photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String[] getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String[] photoContentType) {
		this.photoContentType = photoContentType;
	}
	
	
}
