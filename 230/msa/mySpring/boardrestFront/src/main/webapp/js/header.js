//--메뉴 클릭 시작--
$("header").on("click", "ul>li>a", function (event) {
	/*$("header>ul>li>a").cick(function)과 같은 효과*/
	/*Dom Tree에 객체가 없어도 미리 이벤트핸들러 등록이 가능하다.*/
	/*ul>li>a의 객체가 있는데 */
	/*domtree에 정확히 객체가 있다면 click이고 domtree에 갹체가 없어도 이벤트 핸들러 등록하려면 on
	즉 돔 트리에 있건 없건 이벤트 핸들러 함. */
	/*돔 트리가 동적으로 할 수도 있어서 on함수 쓴 것 */
   $('header>ul>li>a').css("background-color", 'white');
/*balck으로 바꾸면 클릭했을 대 다른 메뉴 black*/
	
/*배경색 흰색으로 바꿈 */
   $(this).css("background-color", "blanchedalmond");
/*지금 객체 현재 객체의 배경색 바꿈 */
   var menu = $(event.target).attr("class");
	console.log($(this));
	console.log("------");
	console.log($(event.target));
    //alert("메뉴:" + $(event.target).attr("class"));
   var $sectionObj = $("section");
   switch (menu) {
      case 'list'://게시판
         $sectionObj.load(frontContextPath + "/boardlist.html");
/*특정영역에 보여줄 수 있는 것 */
         break;
      case 'write'://글쓰기
         $sectionObj.load(frontContextPath + "/write.html");
/*session영역에 load가 되게 하라*/
         break;
   }
   return false;
});
//--메뉴 클릭 끝--
