<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<c:import url="/WEB-INF/views/inc/head.jsp"/>
	
	<meta charset="UTF-8"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="${_ctx}/res/sockjs.min.js"></script>
</head>
<body>

	 <div id="wrap">
	
		<c:import url="/WEB-INF/views/inc/header.jsp"/>
		<c:import url="/WEB-INF/views/inc/left.jsp"/>
	    
	    <div id="rightWrap">
    
    	<div class="rightBlock">
            <div class="page_top">
                
                <h1 style = "background-color:#779988;">수다방</h1>
                
            </div>
            
            <div class="boardWrap">
                
                <table class="base_tbl">
                    <thead>
                        <tr>
                            <th width="8%">채팅</th>
                        </tr>
                    </thead>
                </table>
                	<h5>이야기방</h5>
									 <form id="chatForm">
										<input type="text" id="message"/>
										<button>send</button>
									</form>
									<div id="chat"></div>
            </div>
        </div>
    
    </div>
	</div>
	 
	<script>
		$(document).ready(function(){
			$("#chatForm").submit(function(event){
				event.preventDefault();
				sock.send($("#message").val());
				$("#message").val('').focus();
			});
		});
		
		var sock = new SockJS("/king/echo");
		sock.onmessage = function(e){
			$("#chat").append(e.data + "<br/>");
		}
		
		sock.onclose = function(){
			$("#chat").append("연결 종료");
		}
		
	</script>
	 
	 
	 
	 
	 
	 
	 
	 
</body>
</html>