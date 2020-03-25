package mm.aeon.com.dao.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mm.aeon.com.common.CommonUtil;
import mm.aeon.com.custommapper.userinfo.UserInfoCustomMapper;
import mm.aeon.com.zgen.entity.UserInfo;
import mm.aeon.com.zgen.mapper.UserInfoMapper;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserInfoDao {

	@Autowired
	private UserInfoCustomMapper userInfoCustomMapper;

	@Autowired
	private UserInfoMapper userInfoMapper;

	public String getUserPassword(Integer userId) {
		String encodedPassword = userInfoCustomMapper.getUserPassword(userId);
		return encodedPassword;
	}

	public void changePassword(Integer userId, String encodedNewPassword) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(userId);
		userInfo.setPassword(encodedNewPassword);
		userInfo.setUpdatedBy(userId);
		userInfo.setUpdatedDate(CommonUtil.getCurrentTime());
		userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}

	public void changeYard(Integer userId, Integer yardId) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(userId);
		userInfo.setYardId(yardId);
		userInfo.setUpdatedBy(userId);
		userInfo.setUpdatedDate(CommonUtil.getCurrentTime());
		userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}

}
