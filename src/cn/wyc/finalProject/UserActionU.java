package cn.wyc.finalProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserActionU extends ActionSupport implements ModelDriven<User> {
	private IUserService service = new UserServiceImpl();
	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	//��������ѯ
	private String isUpload;
	public String sayfindUserByCondition() {
		//�����������isUpload���������������1��ѡ��-���Դ���� 2�м���-ֻ��ѯ�м����� 3�޼���-��ѯ�޼�����
		users = service.findByCondition(user.getUserName(), user.getSex(), user.getEducation(), isUpload);
		return SUCCESS;
	}
	//�༭�û�
	public String sayedit() {
		//1�ж��û��Ƿ�����ѡ�����ļ�
		if(upload == null) {
			//����ԭ����
			User duser = service.findUserById(user.getUserID());
			//����û��ѡ���ļ���userģ�͵�filename��path������null,��Ҫ�ò�������û����ֵ�滻
			user.setFilename(duser.getFilename());
			user.setPath(duser.getPath());
			int res1 = service.modifyUser(user);
			if(res1 > 0) {
				return SUCCESS;
			}
		}else {
			//�û�����ѡ����
			//1�ļ������·��
			String realPath = ServletActionContext.getServletContext().getRealPath("/files");
			String dir = generateChildPath(realPath);
			//2 ���ɴ�������Ե��ļ���
			String fileName = TokenHelper.generateGUID()+"_"+uploadFileName;//HHDJH234234_fileNameû�к�ڣ�������uuidһ������JavaScript�У��ַ��������NAN
			//3 ��user��ȱ�ٵĲ������ȥ
			user.setPath(dir);
			user.setFilename(fileName);//������ļ��������Ǵ���GUID���ļ��������ص�ʱ��Ҫ��
			service.saveUser(user);
			//4 �ϴ��ļ�����
			upload.renameTo(new File(realPath+File.separator+dir,fileName));
			//5 �����û�
			int res = service.modifyUser(user);
			if(res>0) {
				return SUCCESS;
			}
		}
		return null;
	}
	//��ʾ�༭ҳ��
	public String sayeditUI() {
		//user����ֵ
		user = service.findUserById(user.getUserID());
		//��user����ѹ��ջ��.�������ѹ�룬�ͻ�д�������һ��user������ջ����һ�� ���ݻ��������
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}
	//ɾ���û�
	public String saydelete() {
		int res = service.removeUser(user.getUserID());
		if(res>0) {
			return SUCCESS;
		}
		return null;
	}
	//�ļ�����
	private InputStream input;
	private String oldFileName;//ԭʼ�ļ���
	public String saydownload() throws Exception {
		//1��ȡ�û���Ϣ
		User dbuser = service.findUserById(user.getUserID());
		//2�ļ���ŵ�ַ
		String realPath = ServletActionContext.getServletContext().getRealPath("/files");
		//��ԭʼ�ļ�����ֵ
		oldFileName = dbuser.getFilename().substring(dbuser.getFilename().indexOf("_")+1);
		//3��һ���ֽ���������ֵ
		input = new FileInputStream(realPath+File.separator+dbuser.getPath()+File.separator+dbuser.getFilename());
		//4���سɹ�
		//5����stream�����ͼ
		return SUCCESS;
	}
	//�鿴�û���ϸ��Ϣ
	public String sayfindById() {
		//user����ֵ
		user = service.findUserById(user.getUserID());
		//��user����ѹ��ջ��.�������ѹ�룬�ͻ�д�������һ��user������ջ����һ�� ���ݻ��������
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}
	//��ѯ�����û�
	private List<User> users;
	public String sayfindAll() {
		users = service.findAllUser();
		return SUCCESS;
	}
	//�û����
	//�����ļ���file
	private File upload;
	private String uploadFileName;
	public String sayadd() {
		//1�ļ������·��
		String realPath = ServletActionContext.getServletContext().getRealPath("/files");
		String dir = generateChildPath(realPath);
		//2 ���ɴ�������Ե��ļ���
		String fileName = TokenHelper.generateGUID()+"_"+uploadFileName;//HHDJH234234_fileNameû�к�ڣ�������uuidһ������JavaScript�У��ַ��������NAN
		//3 ��user��ȱ�ٵĲ������ȥ
		user.setPath(dir);
		user.setFilename(fileName);//������ļ��������Ǵ���GUID���ļ��������ص�ʱ��Ҫ��
		service.saveUser(user);
		//4 �ϴ��ļ�����
		upload.renameTo(new File(realPath+File.separator+dir,fileName));
		//5 �����û�
		int res = service.saveUser(user);
		if(res>0) {
			return SUCCESS;
		}
		return null;
	}
	//�����ļ���Ŀ¼��׺��
	private String generateChildPath(String filePath) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dir = format.format(date);
		File file = new File(filePath,dir);
		if(!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}
	//�û���¼
	public String saylogin() {
		User dbUser = service.login(user.getLogonName(), user.getLogonPwd());
		if(dbUser == null) {
			addActionError("�û������������");
			return "input";
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", dbUser);
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public InputStream getInput() {
		return input;
	}
	public void setInput(InputStream input) {
		this.input = input;
	}
	public String getOldFileName() {
		return oldFileName;
	}
	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}
	public String getIsUpload() {
		return isUpload;
	}
	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}
	
}
