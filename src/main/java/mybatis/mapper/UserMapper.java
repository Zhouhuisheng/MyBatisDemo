package mybatis.mapper;

import mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    User selectByName(String name);
    User selectById(int id);
}
