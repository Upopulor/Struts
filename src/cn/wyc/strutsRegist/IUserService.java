package cn.wyc.strutsRegist;

public interface IUserService {
	//�ж��û��Ƿ����
	User findUserByName(String username);
	//�û�ע��
	int register(User user);
}
