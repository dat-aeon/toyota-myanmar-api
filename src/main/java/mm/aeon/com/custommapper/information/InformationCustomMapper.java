package mm.aeon.com.custommapper.information;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import mm.aeon.com.dto.information.DriverResDto;
import mm.aeon.com.dto.information.RemarkResDto;
import mm.aeon.com.dto.information.TaskResDto;
import mm.aeon.com.dto.information.TrailerResDto;
import mm.aeon.com.dto.information.VehicleInfoResDto;
import mm.aeon.com.dto.information.YardResDto;
import mm.aeon.com.dto.information.ZoneResDto;

public interface InformationCustomMapper {

	List<YardResDto> getYardList();

	List<TaskResDto> getTaskListWithPreviousTaskStatus(@Param("previousTaskStatus") Integer previousTaskStatus);

	List<TrailerResDto> getTrailerList();

	List<ZoneResDto> getAvailableParkingList(@Param("yardId") Integer yardId);

	DriverResDto getDriverInfoWithBarcode(@Param("staffId") String staffId);

	VehicleInfoResDto getVehicleInfoWithChassisNo(@Param("chassisNo") String chassisNo);

	Integer getPreviousVehicleTaskProcessType(@Param("vehicleInfoId") Integer vehicleInfoId);

	Integer getPreviousVehicleZoneColumnStatus(@Param("vehicleInfoId") Integer vehicleInfoId, @Param("yardId") Integer yardId);

	ZoneResDto getPreviousVehicleParkingInfo(@Param("vehicleInfoId") Integer vehicleInfoId);

	TrailerResDto getTrailerWithBarcode(@Param("trailerBarcode") String trailerBarcode);

	List<RemarkResDto> getRemarkList();

}
