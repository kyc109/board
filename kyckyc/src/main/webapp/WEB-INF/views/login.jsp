<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<c:import url="/WEB-INF/views/inc/head.jsp"/>
	
	<link href="${_ctx}/res/js/lightbox/magnific-popup.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript"  src="${_ctx}/res/js/lightbox/jquery.magnific-popup.min.js"></script>

	<title>통합게시판[]</title>
 
 <script>
//팝업2
$(document).ready(function() {

});
 
 
 //팝업
	var dialog
	
	$(document).ready(function(){
		//이미지 사이즈 일괄처리
		$('.parent-container > a > img').css("width","200px");
			
		
		//로그인아이디창에 커서 자동가기	
		$("input").focusin(function(){
			$(this).css("background-color", "#00ff00");
		}).focusout(function(){
			$(this).css("background-color", "#ffffff");
		});
		$("#loginId").focus();
		
		//로그인 버튼 클릭시
		$("#loginBtn").click(function(){
			
			if ($("#frmLogin").valid()) {
				$("#frmLogin").submit();
			}
		});
		//엔터치면 로그인 되게		
		$("#loginPw").keydown(function(e){
			if(e.keyCode == 13) {
				$("#loginBtn").click();
			}
		});
		//팝업 갤러리 이미지
		$('.parent-container').magnificPopup({
			delegate: 'a',
			type: 'image',
			gallery : {
				enabled: true,
				navigateByImgClick: true,
				preload: [0,1]
			}
		});
		
//  		//팝업
// 		dialog = $( "#dialog-form" ).dialog({
// 		       autoOpen: false,
// 		       height: 400,
// 		       width: 350,
// 		       modal: true,
// 		       buttons: {
// 		         "닫기": function() {
// 		           dialog.dialog( "close" );
// 		         }
// 		       },
// 		       close: function() {
// 		       }
// 		     });

// 			    dialog.dialog( "open" ); 
			    
				var url = "${_ctx}/popup/popupDialog.java6";
				$.get(url,function(html){
					$("#popupdialog").html(html);
				});
			    
		
	}) ;

</script>

</head>

<body>

<div id="loginWrap">

	
    <div id="login">
    
	    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	    	<font color="red">
	      		Your login attempt was not successful due to <br/><br/>
		      	<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
		    </font>
		    <c:remove var = "SPRING_SECURITY_LAST_EXCEPTION" scope = "session" />
		    <script>
		     // query string 제거
		     history.replaceState({}, null, location.pathname);
		    </script>
	   </c:if>
    
    	<h1>로그인 페이지</h1>
        <form id="frmLogin" name="frmLogin" action="${_ctx}/security/login" method="post" style="top:300%;">
        
        	<dl>
            	<dt>id</dt>
                <dd><input type="text" name="loginId"  id = "loginId" placeholder="아이디"  minlength = "6" maxlength="15" data-msg-minlength = "야 자리수 {0}이여"   required/></dd>
                <dt>pw</dt>
                <dd><input type="password" name="loginPw" id = "loginPw" placeholder="비밀번호" minlength = "6" maxlength="15"   required/></dd>
            </dl>
            
            <a href="javascript:;" id = "loginBtn" class="loginBtn">로그인</a>
            <a href="${_ctx}/join.java6" class="joinBtn">회원가입</a>
        
        	<%-- <a href = "${_ctx}/findId.java6" class = "findIdBtn">아이디찾기</a>
        	<a href = "${_ctx}/findPw.java6" class = "findPwBtn">비밀번호찾기</a> --%>
        
        </form>
        
    </div>

</div>

<div class="parent-container">
  <a href="${_ctx}/res/images/lightbox/Chrysanthemum.jpg"><img src="${_ctx}/res/images/lightbox/Chrysanthemum.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Desert.jpg"><img src="${_ctx}/res/images/lightbox/Desert.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Hydrangeas.jpg"><img src="${_ctx}/res/images/lightbox/Hydrangeas.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Jellyfish.jpg"><img src="${_ctx}/res/images/lightbox/Jellyfish.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Koala.jpg"><img src="${_ctx}/res/images/lightbox/Koala.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Lighthouse.jpg"><img src="${_ctx}/res/images/lightbox/Lighthouse.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Penguins.jpg"><img src="${_ctx}/res/images/lightbox/Penguins.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Tulips.jpg"><img src="${_ctx}/res/images/lightbox/Tulips.jpg"/></a>
</div>
	<div id="popupdialog"></div>

</body>
</html>

