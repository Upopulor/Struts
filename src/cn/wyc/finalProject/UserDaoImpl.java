package cn.wyc.finalProject;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;


public class UserDaoImpl implements IUserDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	@Override
	public User selectUserByInfo(String logonName, String logonPwd) {
		try{
			return qr.query("select * from S_User where logonName=? and logonPwd=? ", new BeanHandler<User>(User.class),logonName,logonPwd);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public int addUser(User user) {
		try{
			return qr.update("insert into S_User(userID,userName,logonName,logonPwd,sex,birthday,education,telephone,interest,path,filename,remark)values(?,?,?,?,?,?,?,?,?,?,?,?)",
					user.getUserID(),user.getUserName(),user.getLogonName(),user.getLogonPwd(),user.getSex(),user.getBirthday(),user.getEducation(),user.getTelephone(),
					user.getInterest(),user.getPath(),user.getFilename(),user.getRemark());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateUser(User user) {
		try{
			return qr.update("update S_User set userName=?,logonName=?,logonPwd=?,sex=?,birthday=?,education=?,telephone=?,interest=?,path=?,filename=?,remark=? where userID = ?",
					user.getUserName(),user.getLogonName(),user.getLogonPwd(),user.getSex(),user.getBirthday(),user.getEducation(),user.getTelephone(),
					user.getInterest(),user.getPath(),user.getFilename(),user.getRemark(),user.getUserID());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteUser(Integer userID) {
		try{
			return qr.update("delete from S_User where userID = ?",userID);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public User selectUserById(Integer userID) {
		try{
			return qr.query("select * from S_User where userID = ? ", new BeanHandler<User>(User.class),userID);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> selectAllUser() {
		try{
			return qr.query("select * from S_User ", new BeanListHandler<User>(User.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> selectUserByCondition(String userName, String sex, String education, String isUpload) {
		//������������������ûѡ�Ļ�
		if(StringUtils.isBlank(userName) && StringUtils.isBlank(sex) && StringUtils.isBlank(education) && StringUtils.isBlank(isUpload)){
			return selectAllUser();
		}else{
			try {
				List<Object> parameters = new ArrayList<Object>();
				String sql = " select * from S_User ";//ǰ�����ո�
				StringBuffer ss = new StringBuffer(sql);
				ss.append(" where 1=1 ");
				if(StringUtils.isNotBlank(userName)){
					ss.append(" and userName like ? ");
					parameters.add("%"+userName+"%");
				}
				if(StringUtils.isNotBlank(sex)){
					ss.append(" and sex = ? ");
					parameters.add(sex);
				}
				if(StringUtils.isNotBlank(education)){
					ss.append(" and education = ? ");
					parameters.add(education);
				}
				if(StringUtils.isNotBlank(isUpload)){
					//�û���Ҫʹ�ô�����
					if("true".equals(isUpload)){
						ss.append(" and filename is not null ");//���ݿ����ж��Ƿ�Ϊnull ������!=  =���õ���is not  /is
					}else{
						ss.append(" and filename is null ");
					}
				}
				sql = ss.toString();
				return qr.query(sql, new BeanListHandler<User>(User.class),parameters.toArray());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

}
