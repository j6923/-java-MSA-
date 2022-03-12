package com.my.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.my.customer.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {
	/**
	 * 이름에 해당하는 고객들을 반환한다 
	 * 1. 쿼리메서드만 사용한 경우 
	 * Hibernate: select customer0_.id as id1_0_, customer0_.c_name as c_name2_0_, customer0_.pwd as pwd3_0_ from jpacustomer customer0_ where customer0_.c_name=?
	 *
	 * 2. JPQL도 사용한 경우 
	 * select customer0_.id as id1_0_, customer0_.c_name as c_name2_0_, customer0_.pwd as pwd3_0_ from jpacustomer customer0_ where customer0_.c_name=?
	 * from jpacustomer customer0_ where customer0_.c_name='이름'  
	 * 
	 * 
	 * 
	 * 3. nativeQuery도 사용한 경우 
	 * Hibernate: SELECT * FROM jpacustomer WHERE c_name = ?
	 * 
	 * @param name 이름 
	 * @return
	 */
	
	@Query(value = "SELECT * FROM jpacustomer WHERE c_name = ?1"
			, nativeQuery = true)
	//@Query("SELECT c  FROM customer c  WHERE c.name = ?1")  //c전체 다 검색 //JPQL
	List<Customer> findByName(String name);  //여러개여서 List   //find~By~()// 쿼리메서드 
	
	/**
	 * 이름에 단어를 포함한 고객들을 반환한다
	 *  Hibernate: select customer0_.id as id1_0_, 
	 *  			customer0_.c_name as c_name2_0_, customer0_.pwd as pwd3_0_ 
	 *  from jpacustomer customer0_ 
	 *  where customer0_.c_name like '%이름$' escape '\' 
	 *  
	 * @param word 단어 ex) "%이름%"
	 * @return
	 */
	List<Customer> findByNameLike(String word); 
	
	
	
	


}

	
