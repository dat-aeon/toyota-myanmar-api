package mm.aeon.com.services.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mm.aeon.com.dao.userinfo.UserInfoDao;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	public String getUserPassword(Integer userId) {
		return userInfoDao.getUserPassword(userId);
	}

	public void changePassword(Integer userId, String encodedNewPassword) {
		userInfoDao.changePassword(userId, encodedNewPassword);
	}

	public void changeYard(Integer userId, Integer yardId) {
		userInfoDao.changeYard(userId, yardId);
	}
}
