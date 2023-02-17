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

    /**
     *  根据id删除
     */
    void deleteById(int id);
    /**
     *  根据id批量删除
     */
    void deleteByIds(@Param("ids")int[] ids);

    /**
     *  测试多个参数
     *      * 底层会自动地将多个参数封装成Map集合(尽量用@Param注解，这种方式可读性太差了)
     *          map.put("arg0", 参数值1)
     *          map.put("param1", 参数值1)
     *          map.put("arg1", 参数值2)
     *          map.put("param2", 参数值2)
     */
    List<User> MultipleParam(String userName, String address);
}
