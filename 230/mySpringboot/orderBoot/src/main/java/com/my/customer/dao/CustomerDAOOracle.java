package com.my.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.customer.vo.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.sql.MyConnection;
@Repository
public class CustomerDAOOracle implements CustomerDAOInterface {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Autowired
	private DataSource ds;
	@Override
	public void add(Customer customer) throws AddException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			session.insert(
					"com.my.customer.CustomerMapper.add", 
					customer);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		String insertSQL = "INSERT INTO customer(id,pwd,name,address) VALUES (?,?,?,?)";
//		//1.JDBC드라이버(*주의:ojdb8.jar파일을 buildpath에 추가), 2.DB연결
//		try {
//			con = ds.getConnection(); //Connection : DB연결
//			pstmt = con.prepareStatement(insertSQL); //PrepatedStatement : SQL송신
//			pstmt.setString(1, customer.getId());
//			pstmt.setString(2, customer.getPwd());
//			pstmt.setString(3, customer.getName());
//			pstmt.setString(4, customer.getAddress());
//			pstmt.executeUpdate(); //바인드변수 setting 후 DB로 송신
//		} catch (SQLException e) {
//			//ID가 중복된 경우(PK위배)에는 오라클오류번호1번이 발생한다
//			int errorCode = e.getErrorCode();
//			if(errorCode == 1) {
//				throw new AddException("이미 존재하는 아이디입니다");
//			}else {
//				e.printStackTrace();
//				throw new AddException(e.getMessage());
//			}
//		}finally {
//			MyConnection.close(pstmt, con);
//		}
	}

	@Override
	public List<Customer> findAll() throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			String selectAllSQL = "SELECT * FROM customer ORDER BY id DESC";
			pstmt = con.prepareStatement(selectAllSQL);
			rs = pstmt.executeQuery();
			List<Customer> list = new ArrayList<>();
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String address = rs.getString("address");
				Customer c = new Customer(id,pwd,name,address);
				list.add(c);
			}
			if(list.size() == 0) {
				throw new FindException("고객이 없습니다");
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
	}
	private Logger logger = 
			LoggerFactory.getLogger(getClass());
	@Override
	public Customer findById(String id) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			Customer c = session.selectOne(
					"com.my.customer.CustomerMapper.findById", id);
			logger.error("c=" + c);
			if(c == null) {
				throw new FindException("아이디에 해당하는 고객이 없습니다");
			}
			return c;
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			con = ds.getConnection();
//			String selectAllSQL = "SELECT * FROM customer WHERE id=?";
//			pstmt = con.prepareStatement(selectAllSQL);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {				
//				String pwd = rs.getString("pwd");
//				String name = rs.getString("name");
//				String address = rs.getString("address");
//				Customer c = new Customer(id,pwd,name,address);
//				return c;
//			}else {
//				throw new FindException("아이디에 해당하는 고객이 없습니다");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new FindException(e.getMessage());
//		}finally {
//			MyConnection.close(rs, pstmt, con);
//		}
	}

	@Override
	public List<Customer> findByName(String word) throws FindException {
		SqlSession session =null;
		try {
			session = sqlSessionFactory.openSession();
			List<Customer> list = 
					session.selectList(
							"com.my.customer.CustomerMapper.findByName",
//							"%" + word + "%"
							word
					);
			if(list.size() == 0) {
				throw new FindException("단어에 해당하는 이름을 갖는 고객이 없습니다");
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
		/*Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			String selectAllSQL = "SELECT * FROM customer WHERE name LIKE ?";
			pstmt = con.prepareStatement(selectAllSQL);
			pstmt.setString(1, "%" + word + "%");
			rs = pstmt.executeQuery();
			List<Customer> list = new ArrayList<>();			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String address = rs.getString("address");
				Customer c = new Customer(id,pwd,name,address);
				list.add(c);
			}
			if(list.size() == 0) {
				throw new FindException("단어에 해당하는 이름을 갖는 고객이 없습니다");
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
		*/
	}

	//UPDATE customer SET pwd='1'    WHERE id='id1'
	//UPDATE customer SET name='1'   WHERE id='id1'
	//UPDATE customer SET pwd='1', name='1' WHERE id='id1'
	@Override
	public void modify(Customer c) throws ModifyException {
		SqlSession session = null; 
		try {
			session = sqlSessionFactory.openSession();
			session.update("com.my.customer.CustomerMapper.modify", c);
			session.commit(); //스프링을 사용하지않는 마이바티스는 autocommit이 아님
			                  //스프링을 사용하는 마이바티스(mybatis-spring)는 autocommit임
		}catch(Exception e) {
			e.printStackTrace();
			throw new ModifyException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public void remove(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String deleteSQL = "DELETE FROM customer WHERE id=?";
			pstmt = con.prepareStatement(deleteSQL);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyConnection.close(pstmt, con);
		}
	}

	@Override
	public void printInfo() {
		

	}

}
