
/**
 * 
 */
 function idFocus($idObj, $submitBtObj){
    //let $submitBtObj = $('div.signup>form>:submit');
     /*--아이디입력란에 포커스를 받으면 가입버튼이 사라진다 START--*/
    //let $idObj = $('div.signup>form>input[name=id]');
    $idObj.focus(function(){
     $submitBtObj.css('visibility','hidden'); //'visible';
     /*--아이디입력란에 포커스를 받으면 가입버튼이 사라진다 END--*/
 });
     
 }
 
function iddupchk($idObj, $iddupchkBtObj,$submitBtObj){
    /*--아이디중복확인버튼 클릭되었을때 START--*/
    //let $idObj = $('div.signup>form>input[name=id]');
    //let $iddupchkBtObj = $('div.signup>form>button.iddupchk');
    $iddupchkBtObj.click(function(){
     //아이디 입력값 유효성 검사
     if($idObj.val().trim() == ''){
         alert('아이디를 입력하세요');
         $idObj.focus();
         return false;
     }
    /* 
     let formObj = document.querySelector('div.signup>form');//form객체찾기
     formObj.action = 'http://localhost:8888/iddupchk';//전송URL
     formObj.method = 'get'; //전송방식
     formObj.submit(); //전송
    */
     //ajax기술로 전송
     let ajaxUrl = "./iddupchk";
     let ajaxMethod = 'get';
     let idValue = $idObj.val().trim();
     let $submitBtObj = $('div.signup>form>:submit');
     $.ajax({
         url: ajaxUrl,
         method: ajaxMethod,
         data:{id:idValue},
         success:function(responseObj){
             //alert(responseData);
              //응답상태가 '이미 사용중인 아이디'인 경우 경고창보여주기
             //응답상태가 '사용가능한 아이디'인 경우 가입버튼보여주기
            //  let resultNum = parseInt(responseData.trim());
             if(responseObj.status== 0){
                 alert('이미 사용중인 아이디입니다');
             }else{
                 $submitBtObj.css('visibility','visible');
             }
         }
     });

    /*--아이디중복확인버튼 클릭되었을때 END--*/
    
 });

}
 
 

function formSubmit($formObj){
    /*--폼 전송되었을때 START--*/
    //let $formObj = $('div.signup>form');//form객체찾기
//alert("1");
     $formObj.submit(function(){
     //비밀번호값 유효성검사
     let $passwordObjArr = $('div.signup>form>:password');
     let $pwd1 = $($passwordObjArr[0]);
     let $pwd2 = $($passwordObjArr[1]);
     console.log($pwd1.val());
     console.log($pwd2.val());
//alert("2");
     if($pwd1.val() != $pwd2.val()){
         alert('비밀번호가 일치하지 않습니다');
         $pwd1.focus();
         return false;
     }
//alert("3");
     let ajaxUrl=$(this).attr('action');
     let ajaxMethod=$(this).attr('method');
     let sendData = $(this).serialize();
     alert("전송데이터:" + sendData);

     $.ajax({
         url:ajaxUrl,
         method:ajaxMethod,
         data:sendData,
         success:function(responseObj){
            //  let resultNum = parseInt(responseData.trim());
            //  alert(responseData);
             if(responseObj.status==1){ //가입성공
                location.href='./';
             }
            //  }else{
            //      alert(responseObj.msg);
                 
            //  }
             
             
         }, error:function(xhr){
             alert("응답실패:" + xhr.status);
         }
     });
     return false;

 });
 /*--폼 전송되었을때 END--*/
    

}

function serchZip(){
    /*--우편번호찾기 클릭되었을때 START--*/
 $('div.signup>form>button.searchzip').click(function(){
    let url = 'searchzip.html';
    let target = 'searchzip';
    let features = 'width=300px, height=300px';
    window.open(url, target, features);
});
/*--우편번호찾기 클릭되었을때 END--*/

}

 
 
 