package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component  //어노테이션 중에서 spring에서 상속받은 controller어노테이션, spring bean으로 관리하다. 
//쓴 목적은 spring bean으로 객체를 관리하라 
// 스프링 빈으로 관리하도록 하기 위해 component를 붙인 것 
public class MyAdvice {// PointCut(핵심관심사항)에 언제 공통관심사항을 끼워넣기(Weaving)할지를 결정 
	private Logger logger = LoggerFactory.getLogger(getClass());  //로깅처리 
		
	//@Before("execution(* list()) ||  execution(* detail(**))" ) //매개변수 없는 리스트 메서드가 포인트 컷으로 쓰일 것이고 리턴타입은 뭐가 되든 상관없다. 
	//
	public void beforeLog(){  //
		logger.error("Before");//공통사항용 
		//언제 weaing할 것이냐는 @before같이 어노테이션 사용하면 된다. 
		//pointcut의 실행되기 전의 공통관심사항이 위빙이 될 것이다. 
		//pointcut은 핵심관심사항인데 
		
		//리스트와 detail메서드가 호출되기 전에 공통사항용 로직이 처리가 된다. 
		//핵심사항 안 쪽에 
	}
	
	@Around("execution(* list(..))")  
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{ 
		//
		String pMethodName; 
		pMethodName = pjp.getSignature().getName();//포인트컷메서드이름얻기
		Object []args = pjp.getArgs();
		for(Object arg: args) {
			logger.error("포인트컷메서드 매개변수:" + arg + " 암호화~");
		}
		logger.error("Around 포인트컷메서드("+pMethodName +")호출전"); 
		
		Object obj = pjp.proceed(); //포인트컷메서드 호출
		logger.error("Around 포인트컷메서드("+pMethodName +")호출후");
		return obj;
	}
}