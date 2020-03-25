package mm.aeon.com.dto.information;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZoneRowDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -890272399930413614L;

	private Integer zoneRowId;
	private String zoneRowName;
	private List<ZoneColumnDto> zoneColumnDtoList;

}
