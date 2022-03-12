package com.my.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.product.vo.Product;
import com.my.sql.MyConnection;

public class ProductDAOOracle implements ProductDAOInterface {

	@Override
	public List<Product> findAll() throws FindException {
		Connection con = null; //DB연결
		PreparedStatement pstmt = null; //SQL송신
		ResultSet rs = null; //결과 수신
		String selectAllSQL = "SELECT * FROM product ORDER BY prod_name ASC";
		List<Product> list = new ArrayList<>();
		try {
			con = MyConnection.getConnection();
			//DB와의 연결을 한다 
			pstmt = con.prepareStatement(selectAllSQL);
			 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String prodNo = rs.getString("prod_no");//prod_no라는 컬럼명을 String형태로 가져온다. 
				String prodName = rs.getString("prod_name"); //prod_name이라는 컬럼명을 String형태로 가져온다.
				int prodPrice = rs.getInt("prod_price"); //prod_price라는 컬럼명을 String형태로 가져온다.
				Product p = new Product(prodNo, prodName, prodPrice);
				//정보를 가져와서 Product타입의 객체로 생성해준다.
				list.add(p);//List에 Product객체를 추가한다. 
			}
			if(list.size() == 0) {
				//상품 정보가 없어서 반복을 안 돌았다는 뜻이 된다. 
				throw new FindException("상품이 없습니다");
				//- FindExcetpion을 강제 발생 시킨다, 
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
	}

	@Override
	public Product findByNo(String prodNo) throws FindException {
		Connection con = null; //DB연결
		PreparedStatement pstmt = null; //SQL송신
		ResultSet rs = null; //결과 수신
		String selectByNoSQL = "SELECT * FROM product WHERE prod_no=?";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectByNoSQL);
			pstmt.setString(1, prodNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String prodName = rs.getString("prod_name");
				int prodPrice = rs.getInt("prod_price");
				return new Product(prodNo, prodName, prodPrice);
			}
			throw new FindException("상품이 없습니다");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
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
