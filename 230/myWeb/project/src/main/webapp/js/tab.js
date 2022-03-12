/**
 * before.html의 탭부분
 */

 function add_js(){
    let $loginFormObj = $('section>div.wrap>ul.menu>li.menu_item');
    $loginFormObj.click(function () {
        let url = './login.html';
        let target = 'login';
        let features = 'width=300px, height=300px';
        windowId= window.open(url, target, features);  
        
    });

}
