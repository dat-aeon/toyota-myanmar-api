package mm.aeon.com.dao.information;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mm.aeon.com.custommapper.information.InformationCustomMapper;
import mm.aeon.com.dto.information.DriverResDto;
import mm.aeon.com.dto.information.RemarkResDto;
import mm.aeon.com.dto.information.TaskResDto;
import mm.aeon.com.dto.information.TrailerResDto;
import mm.aeon.com.dto.information.VehicleInfoResDto;
import mm.aeon.com.dto.information.YardResDto;
import mm.aeon.com.dto.information.ZoneResDto;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class InformationDao {

	@Autowired
	private InformationCustomMapper informationCustomMapper;

	public List<YardResDto> getYardList() {
		List<YardResDto> yardResDtoList = informationCustomMapper.getYardList();
		return yardResDtoList;
	}

	public List<TaskResDto> getTaskListWithPreviousTaskStatus(Integer previousTaskStatus) {
		List<TaskResDto> taskResDtoList = informationCustomMapper.getTaskListWithPreviousTaskStatus(previousTaskStatus);
		return taskResDtoList;
	}

	public List<TrailerResDto> getTrailerList() {
		List<TrailerResDto> trailerResDtoList = informationCustomMapper.getTrailerList();
		return trailerResDtoList;
	}

	public List<ZoneResDto> getAvailableParkingList(Integer yardId) {
		List<ZoneResDto> zoneResDtoList = informationCustomMapper.getAvailableParkingList(yardId);
		return zoneResDtoList;
	}

	public DriverResDto getDriverInfoWithBarcode(String staffId) {
		DriverResDto driverResDto = informationCustomMapper.getDriverInfoWithBarcode(staffId);
		return driverResDto;
	}

	public VehicleInfoResDto getVehicleInfoWithChassisNo(String chassisNo) {
		VehicleInfoResDto vehicleInfoResDto = informationCustomMapper.getVehicleInfoWithChassisNo(chassisNo);
		return vehicleInfoResDto;
	}

	public Integer getPreviousVehicleTaskProcessType(Integer vehicleInfoId) {
		Integer previousVehicleTaskProcessType = informationCustomMapper.getPreviousVehicleTaskProcessType(vehicleInfoId);
		return previousVehicleTaskProcessType;
	}

	public Integer getPreviousVehicleZoneColumnStatus(Integer vehicleInfoId, Integer yardId) {
		Integer previousVehicleZoneColumnStatus = informationCustomMapper.getPreviousVehicleZoneColumnStatus(vehicleInfoId, yardId);
		return previousVehicleZoneColumnStatus;
	}

	public ZoneResDto getPreviousVehicleParkingInfo(Integer vehicleInfoId) {
		ZoneResDto previousVehicleParkingInfo = informationCustomMapper.getPreviousVehicleParkingInfo(vehicleInfoId);
		return previousVehicleParkingInfo;
	}

	public TrailerResDto getTrailerWithBarcode(String trailerBarcode) {
		TrailerResDto trailerResDto = informationCustomMapper.getTrailerWithBarcode(trailerBarcode);
		return trailerResDto;
	}

	public List<RemarkResDto> getRemarkList() {
		List<RemarkResDto> remarkResDtoList = informationCustomMapper.getRemarkList();
		return remarkResDtoList;
	}

}
