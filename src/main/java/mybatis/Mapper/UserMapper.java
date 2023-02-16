package mybatis.Mapper;

import mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}
