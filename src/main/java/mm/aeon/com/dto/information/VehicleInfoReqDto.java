package mm.aeon.com.dto.information;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleInfoReqDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1578452408097975517L;

	@NotNull
	@NotEmpty
	private String chassisNo;

}
