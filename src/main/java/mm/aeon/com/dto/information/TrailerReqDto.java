package mm.aeon.com.dto.information;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrailerReqDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -629558561184420177L;

	@NotNull
	@NotEmpty
	private String trailerBarcode;

}
