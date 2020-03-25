package mm.aeon.com.dto.information;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskReqDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -3224442075226639640L;

	@NotNull
	private Integer vehicleInfoId;
}
