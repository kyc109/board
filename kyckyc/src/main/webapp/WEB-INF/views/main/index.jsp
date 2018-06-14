<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<c:import url="/WEB-INF/views/inc/head.jsp"/>
	
	<script type="text/javascript">
	function realtimeClock() {
		  document.rtcForm.rtcInput.value = getTimeStamp();
		  setTimeout("realtimeClock()", 1000);
		}
		function getTimeStamp() { // 24시간제
		  var d = new Date();

		  var s =
		    leadingZeros(d.getFullYear(), 4) + '-' +
		    leadingZeros(d.getMonth() + 1, 2) + '-' +
		    leadingZeros(d.getDate(), 2) + ' ' +

		    leadingZeros(d.getHours(), 2) + ':' +
		    leadingZeros(d.getMinutes(), 2) + ':' +
		    leadingZeros(d.getSeconds(), 2);

		  return s;
		}


		function leadingZeros(n, digits) {
		  var zero = '';
		  n = n.toString();

		  if (n.length < digits) {
		    for (i = 0; i < digits - n.length; i++)
		      zero += '0';
		  }
		  return zero + n;
		}
		
		$(document).ready(function(){
			$("#close").click(function(){
			      $("#frmsearch").toggle();
			  });
			    	$('.slider').bxSlider();
		});
	</script>
	<style>
	.page_top{
	text-align: center;
	}
	
	input{
	text-align: center;
	font-family: 궁서체;
	font-size: 1205%;
	color: #f4429b;
	}
	</style>

</head>
		<c:import url="/WEB-INF/views/inc/header.jsp"/>
		<c:import url="/WEB-INF/views/inc/left.jsp"/>

<body onload="realtimeClock()">
	<div id="wrap">
	
	    
	    <div id="rightWrap">
	    	<div class="rightBlock">
	            <div class="page_top">
	                <h1>현재 시간</h1>
	                	<div style="text-align: right;">
			               	<a href="javascript:;"  id="close" style="color: black;">◈시간접기◈</a>
										</div>
		                
		                <form id="frmsearch" name="rtcForm">
											<input type="text" name="rtcInput" size="20" readonly="readonly" />
										</form>
	            </div>  
	        </div>    
	    </div>    
	</div>
</body>

</html>
