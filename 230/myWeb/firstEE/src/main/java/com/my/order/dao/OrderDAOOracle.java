package com.my.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.my.customer.vo.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.order.vo.OrderInfo;
import com.my.order.vo.OrderLine;
import com.my.product.vo.Product;
import com.my.sql.MyConnection;

public class OrderDAOOracle implements OrderDAOInterface {

	@Override
	public void add(OrderInfo info) throws AddException {
		String insertInfoSQL =
				"INSERT INTO order_info(order_no, order_id, order_dt) VALUES (order_seq.NEXTVAL, ?, SYSDATE)";
						String insertLineSQL = 
				"INSERT INTO order_line(order_no, order_prod_no, order_quantity) VALUES (order_seq.CURRVAL,?, ?)";
						
						
						Connection con = null;
						PreparedStatement pstmt = null;
						try {
							con = MyConnection.getConnection();//DB와 연결
							con.setAutoCommit(false); //자동커밋해제 
							
							
							//---주문기본추가 시작----
							pstmt = con.prepareStatement(insertInfoSQL);//SQL구문송신
							
							String orderId = info.getOrderCustomer().getId();
							pstmt.setString(1, orderId);
							pstmt.executeUpdate(); //SQL실행
							//---주문기본추가 끝----
							
							
							//--주문상세추가 시작-- 
							pstmt = con.prepareStatement(insertLineSQL);//SQL구문송신			
							List<OrderLine> lines = info.getLines();
							for(OrderLine line: lines) {
								String orderProdNo = line.getOrderProduct().getProdNo();
								int orderQuantity = line.getOrderQuantity();
								pstmt.setString(1, orderProdNo);
								pstmt.setInt(2, orderQuantity);
								pstmt.executeUpdate(); //SQL실행
							}
							
							//-- 주문상세추가 끝--
							con.commit();
							System.out.println("OrderDAOOracle add 성공");
							
						}catch(Exception e) {
							e.printStackTrace();
							if(con != null) {
								try {
									con.rollback();
								} catch (SQLException e1) {
									
									e1.printStackTrace();
								}
							}
							throw new AddException(e.getMessage());
							
						}finally {
							MyConnection.close(pstmt,con);
							
						}
						
						
						
						
					}
	@Override
	public List<OrderInfo> findById(String orderId) throws FindException {
		String selectBySQL = "SELECT info.order_no,\r\n"
				+ "         info.order_dt,\r\n"
				+ "         line.order_prod_no,\r\n"
				+ "         p.prod_name,\r\n"
				+ "        p.prod_price,\r\n"
				+ "         line.order_quantity\r\n"
				+ " FROM order_info info\r\n"
				+ "JOIN order_line line ON info.order_no=line.order_no\r\n"
				+ "JOIN product p ON line.order_prod_no = p.prod_no  "
				+ "WHERE info.order_id=?\r\n"
				+ "ORDER BY info.order_no DESC, p.prod_name";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();
			//송신
			pstmt = con.prepareStatement(selectBySQL);
			pstmt.setString(1, orderId);
			rs = pstmt.executeQuery();
			List<OrderInfo> infos = new ArrayList<>();
			OrderInfo info = null; 
			List<OrderLine> lines = null;
			int old_order_no = 0; //주문번호는 최소 1부터 시작 // 실제 주문번호는 아니다 
			
			while(rs.next()) {
				int order_no = rs.getInt("order_no");
				java.sql.Date order_dt= rs.getDate("order_dt");
				String prodNo = rs.getString("order_prod_no");
				String prodName = rs.getString("prod_name");
				int prodPrice =rs.getInt("prod_price");
				int orderQuantity = rs.getInt("order_quantity");
				if(old_order_no != order_no) { //if로 비교하고 
					info = new OrderInfo();//info 타입의 객체 새로 만든다. 
					info.setOrderNo(order_no);//리
					info.setOrderDt(order_dt);
					lines = new ArrayList<>();
					info.setLines(lines);
					infos.add(info);//리스트에 추가하라. 
					//주문번호가 달라지면 
					//첫번째 행과 두번째 행이 주문번호 달라져서 info를 infos에 저장 
					old_order_no = order_no;  //28이였다가 27로 바뀜 
				}
				OrderLine line = new OrderLine(); //
				line.setOrderNo(order_no);
				Product p = new Product();
				p.setProdNo(prodNo); p.setProdName(prodName); p.setProdPrice(prodPrice);
				line.setOrderProduct(p);
				line.setOrderQuantity(orderQuantity);
				lines.add(line); //첫 행의 자료 셋팅이 됨. 
				//lines 추가 
				//2번째와 3번쨰 행은 주문번호가 다른 경우 새로운 라인을 if절에서 만들었는데 같으니까 수행 안하고 기존 라인 계속 사용 
				// 같은 라인s에 라인을 추가하게 됨 
				
				
			}
			if(infos.size()==0) {
				throw new FindException("주문이 없습니다.");
			}
			
			return infos;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(rs, pstmt, con);
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
		line2.setOrderProduct(p2);
		line2.setOrderQuantity(2);
		
		lines.add(line2);
		
		info.setLines(lines);
		
		try {
			dao.add(info);
		} catch (AddException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
