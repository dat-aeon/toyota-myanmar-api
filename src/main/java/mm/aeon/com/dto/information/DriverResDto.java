package mm.aeon.com.dto.information;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverResDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -7753411008111487935L;

	private Integer driverId;
	private String driverName;
	private String licenseNo;
	private String phoneNo;

}
