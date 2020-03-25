package mm.aeon.com.dto.inspectvehicle;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspectVehicleDriverDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2553842471591224750L;

	private Integer inspectVehicleDriver;
	private Integer inspectVehicleId;

	@NotNull
	private Integer driverId;

	private Integer createdUser;

}
