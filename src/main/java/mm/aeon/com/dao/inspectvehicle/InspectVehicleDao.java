package mm.aeon.com.dao.inspectvehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mm.aeon.com.common.BeanConverter;
import mm.aeon.com.common.CommonUtil;
import mm.aeon.com.custommapper.inspectvehicle.InspectVehicleCustomMapper;
import mm.aeon.com.dto.inspectvehicle.InspectVehicleDto;
import mm.aeon.com.dto.inspectvehicle.VehicleInfoDto;
import mm.aeon.com.zgen.entity.InspectVehicle;
import mm.aeon.com.zgen.entity.ZoneColumn;
import mm.aeon.com.zgen.entity.ZoneColumnExample;
import mm.aeon.com.zgen.mapper.ZoneColumnMapper;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class InspectVehicleDao {

	@Autowired
	private BeanConverter beanConverter;

	@Autowired
	private InspectVehicleCustomMapper inspectVehicleCustomMapper;

	@Autowired
	private ZoneColumnMapper zoneColumnMapper;

	public Integer insertInspectVehicle(InspectVehicleDto inspectVehicleDto) {
		Integer inspectVehicleId;
		InspectVehicle inspectVehicle = beanConverter.convert(inspectVehicleDto, InspectVehicle.class);
		inspectVehicle.setCreatedDate(CommonUtil.getCurrentTime());
		inspectVehicleCustomMapper.insertInspectVehicle(inspectVehicle);
		inspectVehicleId = inspectVehicle.getInspectVehicleId();
		return inspectVehicleId;
	}

	public VehicleInfoDto getVehicleInfo(String chassisNo) {
		VehicleInfoDto vehicleInfoDto = inspectVehicleCustomMapper.getVehicleInfo(chassisNo);
		return vehicleInfoDto;
	}

	public void updateZoneColumnStatus(Integer zoneColumnId, Integer zoneColumnStatus, Integer updatedUserId) {
		ZoneColumn zoneColumn = new ZoneColumn();
		zoneColumn.setId(zoneColumnId);
		zoneColumn.setStatus(zoneColumnStatus);
		zoneColumn.setUpdatedDate(CommonUtil.getCurrentTime());
		zoneColumn.setUpdatedUser(updatedUserId);
		ZoneColumnExample zoneColumnExample = new ZoneColumnExample();
		zoneColumnExample.createCriteria().andIdEqualTo(zoneColumnId);
		zoneColumnMapper.updateByExampleSelective(zoneColumn, zoneColumnExample);
	}

	public Integer getParkingZoneColumnStatus(Integer parkingZoneColumnId) {
		Integer parkingZoneColumnStatus = inspectVehicleCustomMapper.getParkingZoneColumnStatus(parkingZoneColumnId);
		return parkingZoneColumnStatus;
	}

}
