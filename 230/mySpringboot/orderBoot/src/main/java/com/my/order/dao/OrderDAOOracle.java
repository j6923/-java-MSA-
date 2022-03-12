package com.my.order.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.my.customer.vo.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.order.vo.OrderInfo;
import com.my.order.vo.OrderLine;
import com.my.product.vo.Product;
@Repository("oDAO")
public class OrderDAOOracle implements OrderDAOInterface {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	@Transactional(rollbackFor = AddException.class)//addException이 발생하면 그 즉시 rollback하겠다. 
	//어노테이션도 결국은 클래스이다. 
	//기본 add메서드 내부에서 nullpoint나 aroundbound excetpion이 발생하면 롤백이 되는 것은 기본 + addException이 되도 rollback되도록 함. 
	public void add(OrderInfo info) throws AddException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			session.insert("com.my.order.OrderMapper.orderInfo", info);//order info테이블에 자료 추가 
					
			List<OrderLine> lines = info.getLines();
			for(OrderLine line: lines) {
				session.insert("com.my.order.OrderMapper.orderLine", line);//order line에 테이블에 자료 추가
				//여러 행 추가 
				//mybatis는 auto commit이 아니여서 commit해줘야 하지만 mybatis spring을 쓸 때는 자동 commit이다. 
				//중간에 문제가 발생해도 info테이블 자동 추가 한 것은 auto커밋이 되고 코드를 rollback해놓아도 rollback되지 않는다. 
				//프로그램 프로세스 일의 진행을 개발자 코딩하는데에도 집중도 필요한데 db관련된 tran젝션까지 하면 지저분하고 개발자에게 부담스럽다. 
				//선언적 트랜젝션이라는 것을 할 수 있다. 
				//메서드 별로 전파 작업을 관리할 수 있는데 이를 선언적 크랜젝션이라고 한다. 
			}
			//session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		
//		String insertInfoSQL =
//				"INSERT INTO order_info(order_no, order_id, order_dt) VALUES (order_seq.NEXTVAL, ?, SYSDATE)";
//		String insertLineSQL = 
//				"INSERT INTO order_line(order_no, order_prod_no, order_quantity) VALUES (order_seq.CURRVAL,?, ?)";
//
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = ds.getConnection();//DB와 연결
//			con.setAutoCommit(false); //자동커밋해제
//
//			//---주문기본추가 시작----
//			pstmt = con.prepareStatement(insertInfoSQL);//SQL구문송신
//
//			String orderId = info.getOrderCustomer().getId();
//			pstmt.setString(1, orderId);
//			pstmt.executeUpdate(); //SQL실행
//			//---주문기본추가 끝----
//
//			//--주문상세추가 시작--
//			pstmt = con.prepareStatement(insertLineSQL);//SQL구문송신			
//			List<OrderLine> lines = info.getLines();
//			for(OrderLine line: lines) {
//				String orderProdNo = line.getOrderProduct().getProdNo();
//				int orderQuantity = line.getOrderQuantity();
//				pstmt.setString(1, orderProdNo);
//				pstmt.setInt(2, orderQuantity);
//				pstmt.executeUpdate(); //SQL실행				
//			}			
//			//--주문상세추가 끝--
//			con.commit();
//		}catch(Exception e) {
//			if(con != null) {
//				try {
//					con.rollback();
//				} catch (SQLException e1) {
//				}
//			}
//			throw new AddException(e.getMessage());
//		}finally {
//			MyConnection.close(pstmt, con);
//		}
	}

	@Override
	public List<OrderInfo> findById(String orderId) throws FindException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			List<OrderInfo> list = session.selectList("com.my.order.OrderMapper.findById", orderId);
			logger.warn("list.size=" + list.size());
			if(list.size() > 0) {
				for(OrderInfo info: list) {
					logger.warn(""+info.getOrderNo());
					logger.warn(""+info.getOrderDt());
					logger.warn("info.getLines().size()=" 
					+ info.getLines().size());
					logger.warn("-------------");
				}
			}else if(list.size() == 0) {
				throw new  FindException("주문목록이 없습니다");
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
	}

	@Override
	public List<OrderInfo> findByDate(Date dt) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderInfo> findByDate(Date startDt, Date endDate) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		OrderDAOOracle dao = new OrderDAOOracle();
		OrderInfo info = new OrderInfo();
		String orderId = "id1";
		Customer c = new Customer(); c.setId(orderId);
		info.setOrderCustomer(c);

		List<OrderLine> lines = new ArrayList<>();
		OrderLine line = new OrderLine(); 
		Product p = new Product(); p.setProdNo("C0001");
		line.setOrderProduct(p);
		line.setOrderQuantity(1);
		lines.add(line);

		OrderLine line2 = new OrderLine(); 
		Product p2 = new Product(); p2.setProdNo("C0002");
		line2.setOrderProduct(p);
		line2.setOrderQuantity(1);
		lines.add(line2);

		info.setLines(lines);

		try {
			dao.add(info);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}
}
