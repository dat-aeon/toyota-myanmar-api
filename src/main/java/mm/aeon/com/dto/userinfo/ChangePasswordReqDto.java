package mm.aeon.com.dto.userinfo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordReqDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4697684783033929L;

	private Integer userId;

	private String currentPassword;

	private String newPassword;

	private String confirmNewPassword;

}
