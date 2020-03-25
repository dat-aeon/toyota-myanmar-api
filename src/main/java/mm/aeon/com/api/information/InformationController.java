package mm.aeon.com.api.information;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mm.aeon.com.common.CommonConstants;
import mm.aeon.com.dto.information.AvailableParkingReqDto;
import mm.aeon.com.dto.information.CheckAllowChooseParkingReqDto;
import mm.aeon.com.dto.information.CheckAllowChooseParkingResDto;
import mm.aeon.com.dto.information.DriverReqDto;
import mm.aeon.com.dto.information.DriverResDto;
import mm.aeon.com.dto.information.RemarkResDto;
import mm.aeon.com.dto.information.TaskReqDto;
import mm.aeon.com.dto.information.TaskResDto;
import mm.aeon.com.dto.information.TrailerReqDto;
import mm.aeon.com.dto.information.TrailerResDto;
import mm.aeon.com.dto.information.VehicleInfoReqDto;
import mm.aeon.com.dto.information.VehicleInfoResDto;
import mm.aeon.com.dto.information.YardResDto;
import mm.aeon.com.dto.information.ZoneResDto;
import mm.aeon.com.dto.inspectvehicle.VehicleInfoDto;
import mm.aeon.com.services.information.InformationService;
import mm.aeon.com.services.inspectvehicle.InspectVehicleService;

@RestController
@RequestMapping("/information")
public class InformationController {

	@Autowired
	private InformationService informationService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private InspectVehicleService inspectVehicleService;

	@RequestMapping(value = "/yard-list", method = RequestMethod.GET)
	public List<YardResDto> getYardList() throws Exception {
		return informationService.getYardList();
	}

	@RequestMapping(value = "/task-list", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public List<TaskResDto> getTaskList(@Valid @RequestBody TaskReqDto taskReqDto) throws Exception {
		Integer previousVehicleTaskProcessType = informationService.getPreviousVehicleTaskProcessType(taskReqDto.getVehicleInfoId());
		return informationService.getTaskListWithPreviousTaskStatus(previousVehicleTaskProcessType);
	}

	@RequestMapping(value = "/check-allow-choose-parking", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public CheckAllowChooseParkingResDto checkAllowChooseParking(@Valid @RequestBody CheckAllowChooseParkingReqDto checkAllowChooseParkingReqDto) throws Exception {
		Integer previousVehicleZoneColumnStatus = informationService.getPreviousVehicleZoneColumnStatus(checkAllowChooseParkingReqDto.getVehicleInfoId(),
				checkAllowChooseParkingReqDto.getYardId());
		CheckAllowChooseParkingResDto checkAllowChooseParkingResDto = new CheckAllowChooseParkingResDto();
		if (StringUtils.isEmpty(previousVehicleZoneColumnStatus) || previousVehicleZoneColumnStatus == CommonConstants.PARKING_ZONE_COLUMN_STATUS_AVAILABLE
				|| previousVehicleZoneColumnStatus == CommonConstants.PARKING_ZONE_COLUMN_STATUS_SLOT_DAMAGE) {
			checkAllowChooseParkingResDto.setAllowChooseParkingFlag(true);
		} else {
			checkAllowChooseParkingResDto.setAllowChooseParkingFlag(false);
		}
		return checkAllowChooseParkingResDto;
	}

	@RequestMapping(value = "/trailer-list", method = RequestMethod.GET)
	public List<TrailerResDto> getTrailerList() throws Exception {
		return informationService.getTrailerList();
	}

	@RequestMapping(value = "/available-parking-list", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public List<ZoneResDto> getAvailableParkingList(@Valid @RequestBody AvailableParkingReqDto availableParkingReqDto) throws Exception {

		List<ZoneResDto> zoneResDtoList = new ArrayList<ZoneResDto>();

		if (availableParkingReqDto.getAllowChooseParkingFlag()) {
			zoneResDtoList = informationService.getAvailableParkingList(availableParkingReqDto.getYardId());
		} else {
			ZoneResDto previousVehicleParkingInfo = informationService.getPreviousVehicleParkingInfo(availableParkingReqDto.getVehicleInfoId());
			zoneResDtoList.add(previousVehicleParkingInfo);
		}
		return zoneResDtoList;
	}

	@RequestMapping(value = "/get-driver-info-with-staff-id", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public DriverResDto getDriverInfoWithBarcode(@Valid @RequestBody DriverReqDto driverReqDto) throws Exception {
		return informationService.getDriverInfoWithBarcode(driverReqDto.getStaffId());
	}

	@RequestMapping(value = "/get-vehicle-info-with-chassis-no", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public VehicleInfoResDto getVehicleInfoWithChassisNo(@Valid @RequestBody VehicleInfoReqDto cehicleInfoReqDto) throws Exception {
		VehicleInfoResDto vehicleInfoResDto = null;
		VehicleInfoDto vehicleInfoDto = inspectVehicleService.getVehicleInfo(cehicleInfoReqDto.getChassisNo());
		if (vehicleInfoDto != null) {
			vehicleInfoResDto = new VehicleInfoResDto();
			vehicleInfoResDto.setChassisNo(vehicleInfoDto.getChassisNo());
			vehicleInfoResDto.setColor(vehicleInfoDto.getColor());
			vehicleInfoResDto.setModel(vehicleInfoDto.getModel());
			vehicleInfoResDto.setVehicleInfoId(vehicleInfoDto.getVehicleInfoId());
		}

		return vehicleInfoResDto;
	}

	@RequestMapping(value = "/get-trailer-with-barcode", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public TrailerResDto getTrailerWithBarcode(@Valid @RequestBody TrailerReqDto trailerReqDto) throws Exception {
		TrailerResDto trailerResDto = informationService.getTrailerWithBarcode(trailerReqDto.getTrailerBarcode());
		return trailerResDto;
	}

	@RequestMapping(value = "/remark-list", method = RequestMethod.GET)
	public List<RemarkResDto> getRemarkList() throws Exception {
		return informationService.getRemarkList();
	}

}
