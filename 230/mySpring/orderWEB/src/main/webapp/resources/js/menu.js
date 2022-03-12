/**
 * 메뉴가 클릭되었을때
 */
function menuClick(){
    let $menuObj = $('header>nav>ul>li>a');
    $menuObj.click(function(){
        let menuHref = $(this).attr('href');//href속성값얻기
        console.log("메뉴 href=" + menuHref);

        let ajaxUrl = ""; //요청URL
        let ajaxMethod = ""; //요청방식
        switch(menuHref){
            case './html/login.html':
                //AJAX요청,응답
                ajaxUrl = menuHref;
                ajaxMethod = "GET";
                $('section>div.articles').empty();
                //( String responseText, String textStatus, jqXHR jqXHR )
                $('section>div.articles').load(ajaxUrl,function(responseText, textStatus, jqXHR){
                    if(jqXHR.status != 200){
                        alert('응답실패:' + jqXHR.status);
                    }
                });

                return false; //기본이벤트핸들러금지, 이벤트전파중지
                // break;
            case './html/signup.html':
                ajaxUrl = menuHref;
                $('section>div.articles').load(ajaxUrl,function(responseText, textStatus, jqXHR){
                    if(jqXHR.status != 200){
                        alert('응답실패:' + jqXHR.status);
                    }
                });
                return false;
                //break;
            case 'productlist':
                ajaxUrl = menuHref;
                $('section>div.articles').load(ajaxUrl,function(responseText, textStatus, jqXHR){
                    if(jqXHR.status != 200){
                        alert('응답실패:' + jqXHR.status);
                    }
                });
                return false;
                //break;
            case 'cartlist':
                alert("장바구니메뉴클릭됨");
                ajaxUrl = menuHref;
                $('section>div.articles').load(ajaxUrl,function(responseText, textStatus, jqXHR){
                    if(jqXHR.status != 200){
                        alert('응답실패:' + jqXHR.status);
                    }
                });
                return false;
            case 'logout':
                ajaxUrl = menuHref;
                $.ajax({
                    url: ajaxUrl,
                    success:function(){
                        location.href="./";
                    },
                    error:function(xhr){
                        alert('응답실패:' + xhr.status);
                    }
                });
                return false;
            case 'orderlist':
                ajaxUrl = menuHref;
                $('section>div.articles').load(ajaxUrl,function(responseText, textStatus, jqXHR){
                    if(jqXHR.status != 200){
                        alert('응답실패:' + jqXHR.status);
                    }
                });
                return false;
        }
    });

}