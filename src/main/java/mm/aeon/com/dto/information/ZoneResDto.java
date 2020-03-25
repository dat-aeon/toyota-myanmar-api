package mm.aeon.com.dto.information;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZoneResDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 8244878983778777890L;

	private Integer zoneId;
	private String zoneName;
	private List<ZoneRowDto> zoneRowDtoList;

}
