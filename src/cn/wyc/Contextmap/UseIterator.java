package cn.wyc.Contextmap;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
/**
 * s:iterator��ǩ��ʹ��
 * @author xd
 *
 */
public class UseIterator extends ActionSupport {
	//Action����������ã�Ĭ�Ͼ���ValueStack��ջ��
	private List<Student> students;
	public String findAll() {
		//����service��ķ�����findAllStudent()
		students = new ArrayList<Student>();
		students.add(new Student("Ϲ��",28));
		students.add(new Student("ѹ��",24));
		students.add(new Student("����",22));
		return SUCCESS;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
