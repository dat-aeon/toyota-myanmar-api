package mm.aeon.com.api.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mm.aeon.com.dto.userinfo.ChangePasswordReqDto;
import mm.aeon.com.dto.userinfo.ChangeYardReqDto;
import mm.aeon.com.services.userinfo.UserInfoService;
import mm.aeon.com.zconfig.MessageCode;
import mm.aeon.com.zconfig.exception.BusinessLogicException;
import mm.aeon.com.zconfig.oauth2.CustomPasswordEncoder;

@RestController
@RequestMapping("/user-info-management")
public class UserInfoManagementController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "/change-yard", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public void changeYard(@RequestBody ChangeYardReqDto changeYardReqDto) throws Exception {
		if (StringUtils.isEmpty(changeYardReqDto.getUserId()) || StringUtils.isEmpty(changeYardReqDto.getYardId())) {
			throw new BusinessLogicException(MessageCode.REQUIRED_INPUT, messageSource.getMessage(MessageCode.REQUIRED_INPUT, null, null));
		}
		userInfoService.changeYard(changeYardReqDto.getUserId(), changeYardReqDto.getYardId());

	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public void changePassword(@RequestBody ChangePasswordReqDto changePasswordReqDto) throws Exception {
		checkChangePasswordInputAndValidation(changePasswordReqDto);
		String encodedNewPassword = CustomPasswordEncoder.customEncode(changePasswordReqDto.getNewPassword());
		userInfoService.changePassword(changePasswordReqDto.getUserId(), encodedNewPassword);

	}

	private void checkChangePasswordInputAndValidation(ChangePasswordReqDto changePasswordReqDto) {
		if (StringUtils.isEmpty(changePasswordReqDto.getUserId()) || StringUtils.isEmpty(changePasswordReqDto.getCurrentPassword())
				|| StringUtils.isEmpty(changePasswordReqDto.getNewPassword()) || StringUtils.isEmpty(changePasswordReqDto.getConfirmNewPassword())) {
			throw new BusinessLogicException(MessageCode.REQUIRED_INPUT, messageSource.getMessage(MessageCode.REQUIRED_INPUT, null, null));
		}
		String encodedPassword = userInfoService.getUserPassword(changePasswordReqDto.getUserId());

		if (!CustomPasswordEncoder.customMatches(changePasswordReqDto.getCurrentPassword(), encodedPassword)) {
			throw new BusinessLogicException(MessageCode.INCORRECT_CURRENT_PASSWORD, messageSource.getMessage(MessageCode.INCORRECT_CURRENT_PASSWORD, null, null));
		}

		if (!changePasswordReqDto.getNewPassword().equals(changePasswordReqDto.getConfirmNewPassword())) {
			throw new BusinessLogicException(MessageCode.UNMATCH_CONFIRM_NEW_PASSWORD, messageSource.getMessage(MessageCode.UNMATCH_CONFIRM_NEW_PASSWORD, null, null));
		}

	}
}
