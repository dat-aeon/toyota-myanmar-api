package mm.aeon.com.dto.information;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemarkResDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2262026633187016616L;
	private Integer remarkId;
	private String remark;

}
