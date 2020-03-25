package mm.aeon.com.dao.inspectvehicledriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mm.aeon.com.common.BeanConverter;
import mm.aeon.com.common.CommonUtil;
import mm.aeon.com.dto.inspectvehicle.InspectVehicleDriverDto;
import mm.aeon.com.zgen.entity.InspectVehicleDriver;
import mm.aeon.com.zgen.mapper.InspectVehicleDriverMapper;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class InspectVehicleDriverDao {

	@Autowired
	private BeanConverter beanConverter;

	@Autowired
	private InspectVehicleDriverMapper inspectVehicleDriverMapper;

	public void insertInspectVehicleDriver(InspectVehicleDriverDto inspectVehicleDriverDto) {
		InspectVehicleDriver inspectVehicleDriver = beanConverter.convert(inspectVehicleDriverDto, InspectVehicleDriver.class);
		inspectVehicleDriver.setCreatedDate(CommonUtil.getCurrentTime());
		inspectVehicleDriverMapper.insertSelective(inspectVehicleDriver);
	}

}
