package mm.aeon.com.services.information;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mm.aeon.com.dao.information.InformationDao;
import mm.aeon.com.dto.information.DriverResDto;
import mm.aeon.com.dto.information.RemarkResDto;
import mm.aeon.com.dto.information.TaskResDto;
import mm.aeon.com.dto.information.TrailerResDto;
import mm.aeon.com.dto.information.YardResDto;
import mm.aeon.com.dto.information.ZoneResDto;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InformationService {

	@Autowired
	private InformationDao informationDao;

	public List<YardResDto> getYardList() {
		return informationDao.getYardList();
	}

	public List<TaskResDto> getTaskListWithPreviousTaskStatus(Integer previousTaskStatus) {
		return informationDao.getTaskListWithPreviousTaskStatus(previousTaskStatus);
	}

	public List<TrailerResDto> getTrailerList() {
		return informationDao.getTrailerList();
	}

	public List<ZoneResDto> getAvailableParkingList(Integer yardId) {
		return informationDao.getAvailableParkingList(yardId);
	}

	public DriverResDto getDriverInfoWithBarcode(String staffId) {
		return informationDao.getDriverInfoWithBarcode(staffId);
	}

	public Integer getPreviousVehicleTaskProcessType(Integer vehicleInfoId) {
		return informationDao.getPreviousVehicleTaskProcessType(vehicleInfoId);
	}

	public Integer getPreviousVehicleZoneColumnStatus(Integer vehicleInfoId, Integer yardId) {
		return informationDao.getPreviousVehicleZoneColumnStatus(vehicleInfoId, yardId);
	}

	public ZoneResDto getPreviousVehicleParkingInfo(Integer vehicleInfoId) {
		return informationDao.getPreviousVehicleParkingInfo(vehicleInfoId);
	}

	public TrailerResDto getTrailerWithBarcode(String trailerBarcode) {
		return informationDao.getTrailerWithBarcode(trailerBarcode);
	}

	public List<RemarkResDto> getRemarkList() {
		return informationDao.getRemarkList();
	}

}
