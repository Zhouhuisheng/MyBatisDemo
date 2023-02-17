package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectAll();
    User selectByName(String name);
    User selectById(int id);
    List<User> selectByLessId(int id);

    /**
     *  多条件查询
     *      * 必须标注参数在sql中占位符的名字 @Param("占位符名")参数
     */
    List<User> selectByCondition(@Param("sex")String sex, @Param("address")String address);
    List<User> selectByCondition2(Map map);
}
