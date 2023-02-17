package mybatis.test;

import mybatis.mapper.UserMapper;
import mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAdd {
    @Test
    public void testMybatis() throws IOException {
        // 0. 模拟用户输入
        User user = new User();
        String userName = "周XX";
        String sex = "男";
        String address = "北京市";
        user.setuserName(userName);
        user.setSex(sex);
        user.setAddress(address);
        // 1. 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2. 构建sqlSessionFactory工厂
        SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 3. 打开SqlSession(默认是false，想打开自动提交事务，参数填true)
        SqlSession sqlSession = sqlsessionFactory.openSession(true);
        // 4. 获取接口代理对象（代理开发的方式）
        UserMapper dao = sqlSession.getMapper(UserMapper.class);
        // 5. 执行查询方法
        dao.add(user);
        // 6. 手动提交事务（默认事务是开启的，也就是默认关闭自动提交），否则会回滚事务
//        sqlSession.commit();
        // 7. 释放资源
        sqlSession.close();
    }
}
