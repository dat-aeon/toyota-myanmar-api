package mm.aeon.com.dto.inspectvehicle;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspectVehicleAttachmentDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1533737021393877196L;

	private Integer inspectVehicleAttachmentId;
	private Integer inspectVehicleId;

	@NotNull
	@NotBlank
	@Size(max = 256)
	private String fileName;

	private String filePath;
	private Integer createdUser;

}
