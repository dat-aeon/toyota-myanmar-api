package mm.aeon.com.dto.information;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrailerResDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1249466388156839388L;

	private Integer trailerId;
	private String trailerName;

}
