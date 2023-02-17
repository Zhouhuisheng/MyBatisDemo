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
import java.util.List;

public class TestSelectByCondition {
    @Test
    public void testMybatis() throws IOException {
        // 0. 模拟用户输入
        String sex = "男";
        String address = "%" + "辽宁" + "%";
        // 1. 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2. 构建sqlSessionFactory工厂
        SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 3. 打开SqlSession
        SqlSession sqlSession = sqlsessionFactory.openSession();
        // 4. 获取接口代理对象（代理开发的方式）
        UserMapper dao = sqlSession.getMapper(UserMapper.class);
        // 5. 执行查询方法
        List<User> users = dao.selectByCondition(sex, address);
        // 6. 输出结果
        for (User user : users) {
            System.out.println(user);
        }
        // 7. 释放资源
        sqlSession.close();
    }
}
