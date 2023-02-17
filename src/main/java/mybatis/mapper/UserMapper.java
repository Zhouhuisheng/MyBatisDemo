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
    /**
     *  动态条件查询（SQL语句会随着用户的输入和外部条件的变化而变化）
     */
    List<User> selectByDynamicCondition(Map map);
    /**
     *  动态单条件查询
     */
    List<User> selectByDynamicSingleCondition(Map map);

    /**
     *  添加(参数为除了id以外的所有参数)
     */
    void add(User user);
    /**
     *  修改所有
     */
    void update(User user);
    /**
     *  动态修改
     */
    void updateByDynamic(User user);
}
