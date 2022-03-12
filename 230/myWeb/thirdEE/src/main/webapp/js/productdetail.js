/**
 * 장바구니 넣기 버튼 클릭 
 */


      function putCartClick(){
        	/*---장바구니넣기 버튼클릭되었을 때 START--*/
        	let $formObj = $('div.productdetail>div.productdetail_info>form');
        	$formObj.submit(function(){
        		let ajaxUrl = "./putcart";
        		let method = "get";
        		let data = $(this).serialize(); //prodNo=XXX&quantity=YYY
        		$.ajax({
        			url: ajaxUrl,
        			method: method,
        			data: data,
        			success:function(){
        				$('div.productdetail>div.productdetail_info>div.modal').show();
        			},
        			error:function(xhr){
        				alert('응답실패:' + xhr.status);
        			}
        		});
        		return false;
        	});
        }
        	/*---장바구니넣기 버튼클릭되었을 때 END--*/
        function cartListClick(){
        	/*--모달 div의 장바구니보기버튼 클릭되었을 때 START--*/
        	$('div.productdetail>div.productdetail_info>div.modal>button.cartlist').click(function(){
        		//메뉴중 장바구니객체를 DOM트리에서 찾기 
        		let $menuCartlistObj = $('header>nav>ul>li>a[href=cartlist]');
        		//alert($menuCartlistObj.attr("href")); 테스트용 
        		$menuCartlistObj.trigger('click');//jquery용 메서드 
        		return false; //부모에게 전파 방지 
        	});
        }
        	/*--모달 div의 장바구니보기버튼 클릭되었을 때 END--*/
        function productListClick(){	
        	$('div.productdetail>div.productdetail_info>div.modal>button.productlist').click(function(){
        		let $menuProductlistObj = $('header>nav>ul>li>a[href=productlist]');
        		$menuProductlistObj.trigger('click');
        		return false;
        	});
        }
        	
        