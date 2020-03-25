package mm.aeon.com.dao.inspectvehicleattachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mm.aeon.com.common.BeanConverter;
import mm.aeon.com.common.CommonUtil;
import mm.aeon.com.dto.inspectvehicle.InspectVehicleAttachmentDto;
import mm.aeon.com.zgen.entity.InspectVehicleAttachment;
import mm.aeon.com.zgen.mapper.InspectVehicleAttachmentMapper;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class InspectVehicleAttachmentDao {

	@Autowired
	private BeanConverter beanConverter;

	@Autowired
	private InspectVehicleAttachmentMapper inspectVehicleAttachmentMapper;

	public void insertInspectVehicleAttachment(InspectVehicleAttachmentDto inspectVehicleAttachmentDto) {
		InspectVehicleAttachment inspectVehicleAttachment = beanConverter.convert(inspectVehicleAttachmentDto, InspectVehicleAttachment.class);
		inspectVehicleAttachment.setCreatedDate(CommonUtil.getCurrentTime());
		inspectVehicleAttachmentMapper.insertSelective(inspectVehicleAttachment);
	}
}
