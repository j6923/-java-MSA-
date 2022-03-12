package com.my.control;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.my.exception.FindException;

@Controller
public class MybatisTestController {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@GetMapping("test_max_add")
	public void testMaxAdd() {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			session.insert("com.my.test.TestMapper.add");
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}	
	}
}
