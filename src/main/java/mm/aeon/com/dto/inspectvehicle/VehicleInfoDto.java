package mm.aeon.com.dto.inspectvehicle;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1183782538123142227L;

	private Integer vehicleInfoId;
	private String chassisNo;
	private String model;
	private String color;
	private String colorCode;

}
