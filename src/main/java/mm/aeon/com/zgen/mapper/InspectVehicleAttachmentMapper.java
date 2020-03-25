package mm.aeon.com.zgen.mapper;

import java.util.List;
import mm.aeon.com.zgen.entity.InspectVehicleAttachment;
import mm.aeon.com.zgen.entity.InspectVehicleAttachmentExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface InspectVehicleAttachmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.inspect_vehicle_attachment
     *
     * @mbg.generated
     */
    long countByExample(InspectVehicleAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.inspect_vehicle_attachment
     *
     * @mbg.generated
     */
    int deleteByExample(InspectVehicleAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.inspect_vehicle_attachment
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer inspectVehicleAttachmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.inspect_vehicle_attachment
     *
     * @mbg.generated
     */
    int insert(InspectVehicleAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.inspect_vehicle_attachment
     *
     * @mbg.generated
     */
    int insertSelective(InspectVehicleAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.inspect_vehicle_attachment
     *
     * @mbg.generated
     */
    List<InspectVehicleAttachment> selectByExampleWithRowbounds(InspectVehicleAttachmentExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.inspect_vehicle_attachment
     *
     * @mbg.generated
     */
    List<InspectVehicleAttachment> selectByExample(InspectVehicleAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.inspect_vehicle_attachment
     *
     * @mbg.generated
     */
    InspectVehicleAttachment selectByPrimaryKey(Integer inspectVehicleAttachmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.inspect_vehicle_attachment
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") InspectVehicleAttachment record, @Param("example") InspectVehicleAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.inspect_vehicle_attachment
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") InspectVehicleAttachment record, @Param("example") InspectVehicleAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.inspect_vehicle_attachment
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(InspectVehicleAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.inspect_vehicle_attachment
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(InspectVehicleAttachment record);
}