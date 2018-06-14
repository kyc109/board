<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<c:import url="/WEB-INF/views/inc/head.jsp"/>
	
	<title>회원가입[]</title>

	<script>
		$(document).ready(function(){
			
			   $("input").focusin(function(){
			        $(this).css("background-color", "#ccff44");
			    }).focusout(function(){
			        $(this).css("background-color", "#ffffff");
			    });
			   $("#loginId").focus();
			   		
			//핸드폰입력시 000-0000-0000타입으로 설정
			$("#phone").setMask();
			
			//캡차 이미지 클릭시 새로운 이미지 보여주기
			$("#imgCaptcha").click(function() {
				$(this).attr("src", "${_ctx}/captcha/index");
			});
			//아이디 중복체크
			$("#btnCheckId").click(function(){
				var loginId = $("#loginId").val();
				console.log("loginId =======>"+loginId);
				
				if(loginId == "") {
					alert("로그인 ID를 먼저 작성해 주세요.");
				}else {
					//아이디 중복검사 실시
					var url = "${_ctx}/check/id.java6?loginId="+loginId; //js변수  var = loginId
					$.get(url, function(data){
					
						if(data.code > 0) {
							alert(data.msg);
							
							//아이디 중복 체크를 했음
							$("#checkedId").val("Y");
							
						}else { 
							alert(data.msg);
							$("#checkedId").val("N");
						}
						
					});
				}
			});
			//핸드폰 중복 체크
			$("#btnCheckPhone").click(function(){
				var phone = $("#phone").val();
				console.log("phone======>" +phone);
				
				if(phone == "") {
					alert ("휴대폰을 먼저 입력해 하시오.")
				}else {
					//휴대폰 중복검사 실시
					
					var url = "${_ctx}/check/phone.java6?phone="+phone;
					$.get(url, function(data){
					//$.post(url, {phone : phone}, function(){});	
						
						if (data.code > 0) {
							alert(data.msg);
							
							$("#checkedPhone").val("Y");
						}else {
							alert(data.msg);
							$("#checkedPhone").val("N");
						}
					});
				}
				
			});
			
			//이메일 중복 체크
			$("#btnCheckEmail").click(function(){
				var email = $("#email").val();
				console.log("email====>"+email);
				
				if(email == "") {
					alert("이메일을 먼저 입력하시오.")
				//이메일 중복체크실시
				}else{
					
					var url = "${_ctx}/check/email.java6?email="+email;
					$.get(url, function(data){
						
						if (data.code > 0) {
							alert(data.msg);
							$("#checkedEmail").val("Y");
						}else {
							alert(data.msg);
							$("#checkedEmail").val("N");
						}
					});
				}
			});
			
			//저장 버튼 클릭했을 때
			$("#btnSave").click(function(){
				//javascript로 form 전송
				//frmJoin.submit();
				
				//1. 아이디 중복 검사여부 체크
				var checkedId = $("#checkedId").val();
				if (checkedId == "N") {
					alert("아이디 중복체크를 해주세요.");
					return;
				}
				//2. 핸드폰 중복 검사여부 체크
				var checkedPhone = $("#checkedPhone").val();
				if (checkedPhone == "N") {
					alert("핸드폰 중복체크를 해주세요.")
					return;
				}
				//3. 이메일 중복 검사여부 체크
				var checkedEmail = $("#checkedEmail").val();
				if(checkedEmail == "N") {
					alert("이메일 중복체크를 해주세요.")
					return;
				}
				
				
				//검증에 통과하면
				if ($("#frmJoin").valid()){
					//서버에 데이터 전송
				
					$.get("${_ctx}/captcha/isRight", {captcha : $("#captcha").val()},function(data){
						
						//캡차 성공시	
						if (data==1) {
						
							var url = "${_ctx}/join.java6";
							$.post(url, $("#frmJoin").serialize(), function(data){
								
								if (data == "S") {
									alert ("회원가입 성공!!");
									document.location.href = "${_ctx}/login.java6";
									//document.location.href = "${_ctx}/join/success.java6"; 새로운 페이지로 이동, 컨트롤로에서 만들어야 함
								}else {
									alert ( "회원가입 실패ㅠㅠ");
									document.location.reload();
									//document.location.href = "${_ctx}/join/fail.java6"; 새로운 페이지로 이동, 컨트롤로에서 만들어야 함
								}
							});
							
						}else {
							alert("캡차문자가 다릅니다.")
						}
										
					});
				}
			});
		});
	</script>
	
</head>

<body>

<div id="loginWrap">

    <div id="join">
    	<h1>회원가입</h1>
        <form id="frmJoin" name="frmJoin">
        	<input type = "hidden" id = "checkedId" value = "N"/>  <!-- N이면 체크 안함 -->
        	<input type = "hidden" id = "checkedPhone" value = "N"/>  <!-- N이면 체크 안함 -->
        	<input type = "hidden" id = "checkedEmail" value = "N"/>  <!-- N이면 체크 안함 -->
        	
        	<dl>
                <dd><input type="text" 		 id = "loginId" 		name="loginId" 	 placeholder="아이디" 	maxlength="15" 			minlength = "6"  style = "width:68%;" required />
                	<a href = "javascript:;" id = "btnCheckId" class = "checkId" >ID체크</a></dd>
                <dd><input type="password" 	 id = "loginPw"	name="loginPw" 	 placeholder="비밀번호" 	minlength = "6" 		maxlength="15"  required/></dd>
                <dd><input type="password" 					name="reLoginPw" placeholder="비밀번호 확인" equalTo = "#loginPw" 	minlength = "6" maxlength="15" required/></dd>
                <dd><input type="text" 						name="name" 	 placeholder="이름" 		maxlength = "20" 		required/></dd>
                <dd><input type="text"  	 id = "phone" 	name="phone" 	 placeholder="핸드폰" 	alt = "mobile" 			maxlength = "15" style = "width:68%;" required/>
                	<a href = "javascript:;" id = "btnCheckPhone" class = "checkPhone" >핸드폰체크</a></dd>
               <dd><input  type="email" 	 id = "email"		name="email" 	 placeholder="이메일" 	maxlength = "20" style = "width:68%;"	required/>
                	<a href = "javascript:;" id = "btnCheckEmail" class = "checkEmail" >이메일체크</a></dd>
                
                <dd> <img src = "${_ctx}/captcha/index" id = "imgCaptcha" style = "cursor:pointer;" />
                <input type="text" 	name="captcha" id="captcha" placeholder="이미지 문자 작성" title = "이미지 문자를 입력하세요" style = "width:236px" required/></dd>
                
            </dl>
            
            <a href="javascript:;" class="loginBtn" id ="btnSave">저장</a>
            <a href="${_ctx}/login.java6" class="joinBtn">취소</a>
        
        </form>
        
    </div>

</div>

</body>
</html>


