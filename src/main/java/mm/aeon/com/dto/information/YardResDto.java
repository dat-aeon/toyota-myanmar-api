package mm.aeon.com.dto.information;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YardResDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4971080428370402781L;

	private Integer yardId;
	private String name;

}
