package mm.aeon.com.zgen.mapper;

import java.util.List;
import mm.aeon.com.zgen.entity.StateDivisionInfo;
import mm.aeon.com.zgen.entity.StateDivisionInfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StateDivisionInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.state_division_info
     *
     * @mbg.generated
     */
    long countByExample(StateDivisionInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.state_division_info
     *
     * @mbg.generated
     */
    int deleteByExample(StateDivisionInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.state_division_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.state_division_info
     *
     * @mbg.generated
     */
    int insert(StateDivisionInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.state_division_info
     *
     * @mbg.generated
     */
    int insertSelective(StateDivisionInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.state_division_info
     *
     * @mbg.generated
     */
    List<StateDivisionInfo> selectByExampleWithRowbounds(StateDivisionInfoExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.state_division_info
     *
     * @mbg.generated
     */
    List<StateDivisionInfo> selectByExample(StateDivisionInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.state_division_info
     *
     * @mbg.generated
     */
    StateDivisionInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.state_division_info
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") StateDivisionInfo record, @Param("example") StateDivisionInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.state_division_info
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") StateDivisionInfo record, @Param("example") StateDivisionInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.state_division_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(StateDivisionInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.state_division_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(StateDivisionInfo record);
}