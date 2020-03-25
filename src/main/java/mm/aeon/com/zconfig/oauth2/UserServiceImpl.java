package mm.aeon.com.zconfig.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mm.aeon.com.dto.LoginUserDto;
import mm.aeon.com.dto.userinfo.UserInformationResDto;

@Service(value = "UserService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	public CustomPasswordEncoder passwordEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginUserDto user;
		user = userDao.findLoginUserByLoginId(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		UserInformationResDto userInformationResDto = new UserInformationResDto();
		userInformationResDto.setUserId(user.getLoginUserId());
		userInformationResDto.setName(user.getName());
		userInformationResDto.setYardId(user.getYardId());
		user.setUserInformationResDto(userInformationResDto);

		return user;
	}

}