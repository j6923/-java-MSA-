/**
 * 
 */
$(function () {  //$(document).ready(function(){}) ; 와 같음 
					// DOM트리가 완성되고 화면에 랜더링할 준비가 끝나면 
					//document에서 ready이벤트가 발생한다. 
					//그 이벤트가 발생했을 때 처리할 콜백함수 
					//--이미지첨부파일 변경될때  미리보기 시작--
				$('section>div.write>form>div.data>input[name=imageFile]').change(function(){
					// 값이 바뀔 때마다 input 태그 중에서도 특수하게 type이 파일인 객체들을 
					let file = this.files[0]; //무조건 첫번째 파일을 찾아서 
					$("div.image>img.preview").attr('src',URL.createObjectURL(file));//URL.createObjectURL(file) URL객체의 파일 내용을 가져올 수 있다. 
					//선택한 이미지 첨부한 파일을 
					
					
					//--글쓰기 버튼 클릭 시작--
	let $btObj = $('div.write form input[type=button]');	
	$btObj.click(function () {
		let $writeFormObj = $("section>div.write form"); //document.querySelectorAll과 동일한 효과이어서 배열 형태로 반환이 된다고 함. 
		let formData = new FormData($writeFormObj[0]);//formData가 밑에 ajax data:formDat로 전달이 되어야 한다. 
		//그래서 0번 으로 써야 함. 
		formData.forEach(function (value, key) {
			//jquery에서는 each 
			//자바스크립트 용도의 객체여서 foreach함수를 사용함. 
			// value와 key를 확
			console.log(key + ":" + value);
		});
		$.ajax({
			url: backContextPath + "/board/write",
			method: "post",
			processData: false, //파일업로드용 설정
			contentType: false, //파일업로드용 설정
			data: formData, //파일업로드용 설정
			
			cache:false, //이미지 다운로드용 설정
	        xhrFields:{  //이미지 다운로드용 설정
	            responseType: 'blob'
	        }, 
			success: function (responseData) {
				let $img = $('div.image>img.downloadview');
				let url = URL.createObjectURL(responseData);
				$img.attr('src', url); 
			},
			error: function (jqXHR, textStatus) {//응답실패
				alert("에러:" + jqXHR.status);
			}
		});
		return false;
	});
	//--글쓰기 버튼 클릭 끝--
 
				});
				//--이미지첨부파일 변경될때  미리보기 끝--

	
});
