package mm.aeon.com.dto.information;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverReqDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -8848956075804828675L;

	@NotNull
	@NotBlank
	private String staffId;

}
