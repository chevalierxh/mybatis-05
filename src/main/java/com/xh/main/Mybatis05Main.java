package com.xh.main;

import com.xh.mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import com.xh.pojo.Role;
import com.xh.utils.SqlSessionFactoryUtils;

public class Mybatis05Main {

    private static Logger logger = Logger.getLogger(Mybatis05Main.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            if(role != null){
                logger.info(role.getRoleName()+","+role.getNote());
            }
        }finally {
            sqlSession.close();
        }
    }

}
