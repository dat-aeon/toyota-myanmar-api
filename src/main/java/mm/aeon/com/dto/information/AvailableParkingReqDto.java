package mm.aeon.com.dto.information;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailableParkingReqDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -2587439780624163790L;

	@NotNull
	private Integer yardId;

	@NotNull
	private Boolean allowChooseParkingFlag;

	@NotNull
	private Integer vehicleInfoId;

}
