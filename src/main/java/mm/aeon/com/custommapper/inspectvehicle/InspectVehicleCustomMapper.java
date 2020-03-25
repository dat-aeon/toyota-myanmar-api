package mm.aeon.com.custommapper.inspectvehicle;

import org.apache.ibatis.annotations.Param;

import mm.aeon.com.dto.inspectvehicle.VehicleInfoDto;
import mm.aeon.com.zgen.entity.InspectVehicle;

public interface InspectVehicleCustomMapper {

	Integer insertInspectVehicle(InspectVehicle inspectVehicle);

	VehicleInfoDto getVehicleInfo(@Param("chassisNo") String chassisNo);

	Integer getParkingZoneColumnStatus(@Param("parkingZoneColumnId") Integer parkingZoneColumnId);

}
