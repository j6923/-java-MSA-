package com.my.product.control;

import org.apache.log4j.Logger;

//import jakarta.servlet.http.HttpServletRequest;



//@Controller("productdetail")
public class ControllerTest {
	private Logger logger = Logger.getLogger(getClass());
//	request쓸 수 있고 매개변수로 prodNo와 같이 사용할 수 있다. 
	// requestParam으로 동일하지 않을 경우 써줘야함. 
//	@Autowired
//	private ProductService service;
	
	
	//-----------------------------컨트롤러메서드의 매개변수(request, response, session, 요청전달데이터이름, 커맨드 클래스(JavaBean클래스))-------------------------------------------------//
	
//	@GetMapping("productdetail")
//	public ModelAndView detail(HttpServletRequest request) {
//		try {
//		String prodNo = request.getParameter("prodNo");
//		Product p = service.findByNo(prodNo);
//		ModelAndView mnv = new ModelAndView();
//		mnv.addObject("greeting", "hello"); //request.setAttribute()과 같은 효과 
//		mnv.addObject("p", p);
//		mnv.setViewName("productdetailresult.jsp"); //FORWARD할 view이름 
//		return mnv;
////		s가 붙어있는 것은 Spring container에 의해서 관리될 객체이다. 
//	}catch(FindException e) {
//		return null;
//	}
//	}
	
//	@GetMapping("productdetail")
//	public ModelAndView detail(String prodNo) {
//		try {
//		//String prodNo = request.getParameter("prodNo");
//		Product p = service.findByNo(prodNo);
//		ModelAndView mnv = new ModelAndView();
//		mnv.addObject("greeting", "hello"); //request.setAttribute()과 같은 효과 
//		mnv.addObject("p", p);
//		mnv.setViewName("productdetailresult.jsp"); //FORWARD할 view이름 
//		return mnv;
////		s가 붙어있는 것은 Spring container에 의해서 관리될 객체이다. 
//	}catch(FindException e) {
//		return null;
//	}
//	}
	
//	@GetMapping("productadd")
//	public ModelAndView add(String prodNo, String prodName, int prodPrice) {
////		System.out.println(prodNo+":" + prodName + ":" + prodPrice);
//		logger.warn(prodNo+":" + prodName + ":" + prodPrice);
//		Product p = new Product(prodNo, prodName, prodPrice);
//		//service.add(p);
//		return null;
//	}
	
//	http://localhost:8888/orderWEB/productadd?prodNo=1&prodName=2&prodPrice=1500
//	http://localhost:8888/orderWEB/productadd?prodNo=1&prodPrice=1500
//	--> WARN : com.my.product.control.ProductDetail - 1:null:1500
//	http://localhost:8888/orderWEB/productadd?prodNo=1 는 prodPrice에 required로 줘도 int로 변환이 되지 않아 오류가 난다. 
//	defaultValue = "0"으로 하면 값 입력되지 않으면 기본값 0으로 되고 숫자형 0으로 변환이 가능핟. 
	
	
//	@GetMapping("productadd")
//	public ModelAndView add(@RequestParam(name= "prodNo") String no,
//							@RequestParam(name= "prodName", required = false)String name, 
//							//required = false는 반드시 전달되지 않아도 된다, 라는 뜻이다.
//							@RequestParam(name= "prodPrice", required = false, defaultValue = "0") int price) {
//
//		logger.warn(no+":" + name + ":" + price);
//		Product p = new Product(no, name, price);
//		
//		return null;
//	}
	
	
//	http://localhost:8888/orderWEB/productadd?prodNo=1&prodName=2&prodPrice=1500
	//-->WARN : com.my.product.control.ProductDetail - Product [prodNo=1, prodName=2, prodPrice=1500]
	//http://localhost:8888/orderWEB/productadd?prodNo=1&prodPrice=1500
	//-->WARN : com.my.product.control.ProductDetail - Product [prodNo=1, prodName=상품이름, prodPrice=1500]
	
	
//	@GetMapping("productadd")
//	public ModelAndView add(Product p) {
//		logger.warn(p);
//		return null;
//	}
	
	//http://localhost:8888/orderWEB/productChk?c=coffee&c=tea&c=juice
	//http://localhost:8888/orderWEB/productChk로 했을 경우 향상된 for문 하면 nullPointExcption발생 --> if로 예외처리해줌 
//	@GetMapping("productChk")
////	productChk로 전달될 경우 
//	public ModelAndView chk(@RequestParam(name="c", required = false) String[] cArr) {
//		if(cArr != null) {
//			
//	
//			for(String c:cArr) {
//				logger.warn(c); 
//				
//			}
//		}
//		return null;
//	}
	
	//----------------------컨트롤러 메서드의 반환형 (ModelAndView, String, void)-------------//
	
	
//	http://localhost:8888/orderWEB/productdetail?prodNo=C0001
//	@GetMapping("productdetail")
//	public String detail(String prodNo, Model model) {
//		try {
//		//String prodNo = request.getParameter("prodNo");
//		Product p = service.findByNo(prodNo);
//		
//		model.addAttribute("p", p);
//		String viewName = "productdetailresult.jsp"; //FORWARD할 VIEW이름 
//		return viewName;
//		
//		
//
//	}catch(FindException e) {
//		return null;
//	}
//	}
	
	
//	@GetMapping("productdetail")
//	public String detail(String prodNo, Model model) {
//		try {
//		//String prodNo = request.getParameter("prodNo");
//		Product p = service.findByNo(prodNo);
//		
//		model.addAttribute("p", p);
////		String viewName = "productdetailresult"; //FORWARD할 VIEW이름 
//		String viewName = "productdetail"; //FORWARD할 VIEW이름 
//		return viewName;
//		
//		
//
//	}catch(FindException e) {
//		return null;
//	}
//	}
	
//	@GetMapping("productdetail")
//	//void로 하면 자동 view resolver의 도움을 받아서 해당 prefix영역을 찾아가서 매핑되는 url용 viewer를 찾아낸다. 
//	// web
//	public void detail(String prodNo, Model model) {
//		try {
//		
//		Product p = service.findByNo(prodNo);
//		
//		model.addAttribute("p", p);
//
//
//		
//
//	}catch(FindException e) {
//
//	}
//	}
	
	
	
}
