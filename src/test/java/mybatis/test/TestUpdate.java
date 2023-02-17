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

public class TestUpdate {
    @Test
    public void testMybatis() throws IOException {
        // 0. 模拟用户输入
        User user = new User();
        int id = 7; // 要修改的数据项的id
        // ---------输入要修改的值-----------
        String userName = "黄XX";
        String sex = "女";
        String address = "上海市";
        user.setId(id);
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
        // 5. 执行修改方法
        dao.update(user);
        // 6. 手动提交事务（默认事务是开启的，也就是默认关闭自动提交），否则会回滚事务
//        sqlSession.commit();
        // 7. 释放资源
        sqlSession.close();
    }
}
