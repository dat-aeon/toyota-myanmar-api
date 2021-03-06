package mm.aeon.com.zgen.mapper;

import java.util.List;
import mm.aeon.com.zgen.entity.Charges;
import mm.aeon.com.zgen.entity.ChargesExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ChargesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.charges
     *
     * @mbg.generated
     */
    long countByExample(ChargesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.charges
     *
     * @mbg.generated
     */
    int deleteByExample(ChargesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.charges
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.charges
     *
     * @mbg.generated
     */
    int insert(Charges record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.charges
     *
     * @mbg.generated
     */
    int insertSelective(Charges record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.charges
     *
     * @mbg.generated
     */
    List<Charges> selectByExampleWithRowbounds(ChargesExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.charges
     *
     * @mbg.generated
     */
    List<Charges> selectByExample(ChargesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.charges
     *
     * @mbg.generated
     */
    Charges selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.charges
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Charges record, @Param("example") ChargesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.charges
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Charges record, @Param("example") ChargesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.charges
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Charges record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.charges
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Charges record);
}