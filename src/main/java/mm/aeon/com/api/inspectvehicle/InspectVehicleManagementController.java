package mm.aeon.com.api.inspectvehicle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mm.aeon.com.common.CommonConstants;
import mm.aeon.com.dto.inspectvehicle.InspectVehicleDto;
import mm.aeon.com.dto.inspectvehicle.VehicleInfoDto;
import mm.aeon.com.services.inspectvehicle.InspectVehicleService;
import mm.aeon.com.zconfig.MessageCode;
import mm.aeon.com.zconfig.exception.BusinessLogicException;

@RestController
@RequestMapping("/inspect-vehicle-management")
public class InspectVehicleManagementController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private InspectVehicleService inspectVehicleService;

	@RequestMapping(value = "/insert-multipart", method = RequestMethod.POST, produces = "application/json; charset=utf-8", headers = ("content-type=multipart/*"))
	public void registerNewApplicationWithMultipart(@Valid @RequestPart(required = true) InspectVehicleDto inspectVehicleDto,
			@RequestPart(name = "img", required = true) List<MultipartFile> multipartFileList) throws Exception {

		VehicleInfoDto vehicleInfoDto = inspectVehicleService.getVehicleInfo(inspectVehicleDto.getChassisNo());
		if (vehicleInfoDto == null) {
			throw new BusinessLogicException(MessageCode.NOT_EXIST_VEHICLE_INFO, messageSource.getMessage(MessageCode.NOT_EXIST_VEHICLE_INFO, null, null));
		}
		inspectVehicleDto.setVehicleId(vehicleInfoDto.getVehicleInfoId());

		if (inspectVehicleDto.getParkingStatus().equals(CommonConstants.PARKING_ZONE_COLUMN_STATUS_OCCUPIED)) {
			Integer parkingZoneColumnStatus = inspectVehicleService.getParkingZoneColumnStatus(inspectVehicleDto.getParkingColumnId());
			if (!parkingZoneColumnStatus.equals(CommonConstants.PARKING_ZONE_COLUMN_STATUS_AVAILABLE)) {
				throw new BusinessLogicException(MessageCode.INVALID_PARKING_ZONE_COLUMN, messageSource.getMessage(MessageCode.INVALID_PARKING_ZONE_COLUMN, null, null));
			}
		}

		inspectVehicleService.registerNewApplicationWithMultipart(inspectVehicleDto, multipartFileList);

	}

}
