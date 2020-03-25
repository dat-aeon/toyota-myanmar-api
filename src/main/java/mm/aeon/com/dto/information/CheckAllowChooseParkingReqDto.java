package mm.aeon.com.dto.information;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckAllowChooseParkingReqDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4093379565821824075L;

	@NotNull
	private Integer vehicleInfoId;

	@NotNull
	private Integer yardId;
}
