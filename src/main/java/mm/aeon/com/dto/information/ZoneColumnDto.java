package mm.aeon.com.dto.information;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZoneColumnDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -570832836655731195L;

	private Integer zoneColumnId;
	private String zoneColumnName;

}
