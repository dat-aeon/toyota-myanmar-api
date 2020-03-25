package mm.aeon.com.custommapper.userinfo;

import org.apache.ibatis.annotations.Param;

public interface UserInfoCustomMapper {

	String getUserPassword(@Param("userId") Integer userId);

}
