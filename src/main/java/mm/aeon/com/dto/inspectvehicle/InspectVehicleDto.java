package mm.aeon.com.dto.inspectvehicle;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspectVehicleDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -6546838983678790177L;

	private Integer inspectVehicleId;
	private Integer vehicleId;

	@NotNull
	@NotEmpty
	private String chassisNo;

	@NotNull
	private Integer taskId;

	private Integer trailerId;

	private Boolean carBodyGoodFlag;

	private Boolean engineGoodFlag;

	private Boolean interiorGoodFlag;

	@Size(max = 256)
	private String remark;

	@NotNull
	private Integer parkingColumnId;

	@NotNull
	private Integer parkingStatus;

	@NotNull
	private Boolean ownerDriverFlag;

	@NotNull
	private Boolean trailerFlag;

	@NotNull
	private Integer createdUser;

	@NotNull
	@NotEmpty
	@Valid
	private List<InspectVehicleDriverDto> inspectVehicleDriverDtoList;

	@Valid
	private List<InspectVehicleAttachmentDto> inspectVehicleAttachmentDtoList;

}
