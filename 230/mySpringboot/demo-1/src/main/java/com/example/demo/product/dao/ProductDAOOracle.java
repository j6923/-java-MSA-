package com.example.demo.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.exception.AddException;
import com.example.demo.exception.FindException;
import com.example.demo.exception.ModifyException;
import com.example.demo.exception.RemoveException;
import com.example.demo.product.vo.Product;
@Repository("pDAO")
public class ProductDAOOracle implements ProductDAOInterface {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
//	@Autowired
//	private DataSource ds;
	//private Logger log = Logger.getLogger(ProductDAOOracle.class.getName());
	private Logger log = LoggerFactory.getLogger(getClass());
	public ProductDAOOracle() {
		log.info("ProductDAOOracle 생성자 호출됨");
	}
	@Override
	public List<Product> findAll() throws FindException {
			
		SqlSession session = null;
		try {
		session = sqlSessionFactory.openSession();
		List<Product> list = session.selectList("com.my.product.ProductMapper.findAll");
		return list;
		}catch(Exception e) {
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	
//		Connection con = null; //DB연결
//		PreparedStatement pstmt = null; //SQL송신
//		ResultSet rs = null; //결과 수신
//		String selectAllSQL = "SELECT * FROM product ORDER BY prod_name ASC";
//		List<Product> list = new ArrayList<>();
//		try {
//			 //con = MyConnection.getConnection(); 
//			con=ds.getConnection();
//			pstmt = con.prepareStatement(selectAllSQL);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				String prodNo = rs.getString("prod_no");
//				String prodName = rs.getString("prod_name");
//				int prodPrice = rs.getInt("prod_price");
//				Product p = new Product(prodNo, prodName, prodPrice);
//				list.add(p);
//			}
//			if(list.size() == 0) {
//				throw new FindException("상품이 없습니다");
//			}
//			return list;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new FindException(e.getMessage());
//		}finally {
//			MyConnection.close(rs, pstmt, con);
//		}
	}

	@Override
	public Product findByNo(String prodNo) throws FindException {
		log.debug("디버그 레벨");
		log.info("ProductDAOOralce의 findByNo");
		log.warn("워닝 레벨");
		log.error("에러레벨");
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			log.error("session="+session);
			Product p = session.selectOne("com.my.product.ProductMapper.findByNo", prodNo);
			if(p == null) {
				throw new FindException("상품이 없습니다.");
			}
			return p;
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
			
		}finally {
			if(session != null) {
				session.close();
			}
		}
//		Connection con = null; //DB연결
//		PreparedStatement pstmt = null; //SQL송신
//		ResultSet rs = null; //결과 수신
//		String selectByNoSQL = "SELECT * FROM product WHERE prod_no=?";
//		try {
//			//con = MyConnection.getConnection();
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(selectByNoSQL);
//			pstmt.setString(1, prodNo);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				String prodName = rs.getString("prod_name");
//				int prodPrice = rs.getInt("prod_price");
//				return new Product(prodNo, prodName, prodPrice);
//			}
//			throw new FindException("상품이 없습니다");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new FindException(e.getMessage());
//		}finally {
//			MyConnection.close(rs, pstmt, con);
//		}
	}

	@Override
	public List<Product> findByNoOrName(String word) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Product product) throws AddException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(Product product) throws ModifyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String prodNo) throws RemoveException {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) throws FindException {
		ProductDAOOracle dao = new ProductDAOOracle();
		String prodNo = "C0001";
		Product p = dao.findByNo(prodNo);
		System.out.println(p);
	}

}
