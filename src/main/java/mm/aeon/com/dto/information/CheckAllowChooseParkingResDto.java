package mm.aeon.com.dto.information;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckAllowChooseParkingResDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6802102572967450115L;
	private Boolean allowChooseParkingFlag;

}
