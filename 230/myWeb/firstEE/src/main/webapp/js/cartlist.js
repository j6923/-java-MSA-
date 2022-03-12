/**
 * 
 */
function addOrderClick(){
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