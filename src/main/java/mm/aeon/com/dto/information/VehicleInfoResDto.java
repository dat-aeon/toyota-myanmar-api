package mm.aeon.com.dto.information;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleInfoResDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1290433476515957210L;

	private Integer vehicleInfoId;
	private String chassisNo;
	private String color;
	private String model;
}
