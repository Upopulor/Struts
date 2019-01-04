package cn.wyc.Contextmap;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * ����ValueStack������
 * @author xd
 *
 */
public class context2 extends ActionSupport {
	private String name = "���ȿ�";
	public String execute() {
		/*//��ȡValueStack������
		//1
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack vs1 = (ValueStack) request.getAttribute("struts.valueStack");
		System.out.println(vs1.hashCode());
		//2�Ȼ�ȡActionContext����-ȡ��requestmap
		ActionContext ct = ActionContext.getContext();
		Map<String,Object> requestAttribute = (Map<String, Object>) ct.get("request");
		ValueStack vs2 = (ValueStack) requestAttribute.get("struts.valueStack");
		System.out.println(vs2.hashCode());
		//3
		ValueStack vs3 = ct.getValueStack();
		System.out.println(vs3.hashCode());*/
		
		//ջ�Ĳ���
		ActionContext ct = ActionContext.getContext();
		ValueStack vs4 = ct.getValueStack();
		//ѹջ����
		vs4.push(new Student("��˹��",12));
		vs4.push(new Student("��˹��",14));
		/**
		 * setValue(String expr,Object value)
		 * String expr һ��OGNL���ʽ
		 * OBJECT value ����Ҫ����������
		 * �����ݴ浽����ȡ����expr�Ƿ�ʹ��#�����Ǵ浽ContextMap����浽ValueStack
		 */
		vs4.setValue("#name", "����");//�����ݷŵ�Contextmap�У�key��name,value�Ǵ���
		vs4.setValue("name", "ά����");//��ValueStack�е�һ��name����ֵ����ά���У����û��name��Ӧ��setName�������򱨴�
		
		/**
		 * set(String key , Object o);
		 * String key: Map��key
		 * OBject o : map��value
		 * ���ջ����һ��mapԪ�أ�ֱ�Ӱ�key��Ϊmap��key����Object��Ϊmap��value���룬�������ջ��
		 * ���ջ������mapԪ�أ�����һ��mapԪ�أ���key��Ϊmap��key����Object��Ϊmap��value����ջ��
		 */
		vs4.set("s1",new Student("����˿",18));
		vs4.push(new Student("ά³˹",23));
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
