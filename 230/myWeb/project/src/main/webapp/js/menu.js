
// MAIN화면에서 회원가입을 누르면 회원가입으로 가는 것입니다. 
function signup_js(){
    let $signupFormObj = $('header>session>div.login_item>ul.login>li.log_li>a#login');
    $signupFormObj.click(function () {
        let url = './signup.html';
        let target = 'signup';
        let features = 'width=300px, height=300px';
        windowId= window.open(url, target, features);  
        
    });

}

// 로그인 버튼 클릭시 로그인 이벤트 적용 
function login_js(){
    let $loginFormObj = $('header>session>div.login_item>ul.login>li.log_li>a#signup');
    $loginFormObj.click(function () {
        let url = './login.html';
        let target = 'login';
        let features = 'width=300px, height=300px';
        windowId= window.open(url, target, features);  
        
    });

}

/**
 * 메뉴가 클릭되었을때
 */
 function menuClick(){
    let $menuObj = $('header>session>div.login_item>ul.login>li.log_li>a#log_link_community');
    $menuObj.click(function(){
        let menuHref = $(this).attr('class'); //href속성값 얻기(여기서 this는 클릭된 메뉴 객체를 의미)
        console.log("메뉴 href=" + menuHref);


        let ajaxUrl = ""; //요청할URL
        let ajaxMethod = ""; //요청방식
        switch(menuHref){

            //menu에서 커뮤니티가 클릭되었을때
            case 'ntclist':
                ajaxUrl = menuHref;
                $('section>div.articles').load(ajaxUrl, function(responseText, textStatus, jqXHR){
                    if(jqXHR.status != 200){
                        alert('응답실패:' + jqXHR.status);            
                    }    
                }); 
                return false;

            //menu에서 마이페이지가 클릭되었을때

          }
    });
 }


function communityClick(){
 $('button.addorder').click(function(){
    let ajaxUrl = "./addorder";
    $.ajax({
        url: ajaxUrl,
        success:function(responseObj){
            if(responseObj.status==0){
                //주문실패
                alert(responseObj.msg);
            }else{ //주문성공
                //location.href="./selector.jsp";  //메인화면요청 
                //$('header>nav>ul>li>a{href=productlist}').trigger('click');  //상품목룍다시 가기   //상풍목록보기 
                //주문목록 직접 가기 
            }
            
        }
    });
    return false;
});
/*--주문하기 버튼클릭 END--*/
}

