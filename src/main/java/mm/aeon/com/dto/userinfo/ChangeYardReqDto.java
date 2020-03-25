package mm.aeon.com.dto.userinfo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeYardReqDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -6541596228278275606L;

	private Integer userId;
	private Integer yardId;

}
