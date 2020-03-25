package mm.aeon.com.dto.information;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2642484019861104639L;

	private Integer taskId;
	private String taskName;
	private Integer processType;

}
