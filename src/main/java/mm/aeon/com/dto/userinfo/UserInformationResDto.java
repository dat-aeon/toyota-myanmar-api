package mm.aeon.com.dto.userinfo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInformationResDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 6068987989592775264L;
	private Integer userId;
	private String name;
	private Integer yardId;

}
