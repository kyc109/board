<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<c:import url="/WEB-INF/views/inc/head.jsp"/>
	 	
	 <style>
	 /*팝업  */
  body {
   font-family: Arial, Helvetica, sans-serif;
  }
  
  table {
   font-size: 1em;
  }
  
  .ui-draggable, .ui-droppable {
   background-position: top;
  }
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
  </style>
	
		
	<script>
	
		//팝업
		var dialog
	
		$(function() {
			// 좋아요
			if("${view.likeYn}" == "Y"){
				$("#btnLike").attr("src", "${_ctx}/res/images/like/like.PNG");
				
			// 싫어요
			}else if("${view.likeYn}" == "N"){
				$("#btnLike").attr("src", "${_ctx}/res/images/like/dislike.PNG");
				
			// 무관심
			}else if("${view.likeYn}" == ""){
				$("#btnLike").attr("src", "${_ctx}/res/images/like/ignore.PNG");
			}
			
			//좋아요(Y),싫어요(N),무관심
			$("#btnLike").click(function() {
				var likeYn = $(this).attr("data-like-yn");
				var likeId = $(this).attr("data-like-id"); 
				var url = "${_ctx}/board/like/like.java6";
				var param = {"docId":"${view.docId}", "likeId":likeId,  "likeYn" : ""};
				//현재 좋아요==>싫어요				
				if(likeYn=="Y"){
					param.likeYn = "N";
				//현재 싫어요==> 무관심	
				}else if(likeYn=="N"){
					param.likeYn = "";
				//현재 무관심==>좋아요
				}else if(likeYn==""){
					param.likeYn = "Y";
					
				}
				$.post(url,param,function(data){
					console.log(data);
					
					if(data.code==9){
						location.reload();
					}	
				});
			});
			
			
			//팝업
			dialog = $( "#dialog-form" ).dialog({
			       autoOpen: false,
			       height: 400,
			       width: 350,
			       modal: true,
			       buttons: {
			         "닫기": function() {
			           dialog.dialog( "close" );
			         }
			       },
			       close: function() {
			       }
			     });

			   $("#viewUser").on( "click", function() {
				    dialog.dialog( "open" );
			   });
			
			
			
			//댓글등록 클릭시
			$("#commentWrap").on("click", "#btnComment", function(){
				var comment = $("#comments").val();
				
				var url = "${_ctx}/board/comment/write.java6";
				var params = {
						docId:"${view.docId}"
					   , comments:comment
					};
				
				$.post(url, params, function(data){
					console.log(data);
					   listComment();
				});
				
			});
			//댓글 input에 엔터치면 댓글 등록
			$("#commentWrap").on("keydown", "#comments", function(e){
				console.log(e.keyCode);
				
				if(e.keyCode == 13) {
					$("#btnComment").click();
				}
			});
			
			listComment();
		});
		
		//댓글 목록 가져오기
		function listComment() {
			var url = "${_ctx}/board/comment/list.java6?docId=${view.docId}";
			$.get(url, function(data){
				$("#commentWrap").html(data);
			});
				
		};
		//댓글 삭제
		function deleteComment(commentKey){
			
			var url = "${_ctx}/board/comment/remove.java6?"
			$.post(url, {commentId : commentKey }, function(data) {
				if (data == "S") {
					listComment();
					alert('댓글삭제합니다');
				}
			});	
		}
		//파일삭제
		function deleteFile(docKey) {
			var url = "${_ctx}/board/doc/remove.java6?"
					$.post(url, {docId : docKey}, function(data) {
						if(data=="S"){
							location.href="${_ctx}/board/doc/list.java6?mapId=${view.mapId}";
							alert('삭제됩니다');
						}
			});
		}
		
	
	</script>


</head>

<body>

	<div id="dialog-form" title="View User">
   <p class="validateTips">사용자 조회</p>
  
   <form>
     <fieldset>
       <label for="name">Name</label>
       <input type="text" name="name" id="name" value="${view.userName}" class="text ui-widget-content ui-corner-all"/>
       <label for="email">Email</label>
       <input type="text" name="email" id="email" value="${_user.email}" class="text ui-widget-content ui-corner-all"/>
       <label for="phone">Phone</label>
       <input type="text" name="phone" id="phone" value="${_user.phone}" class="text ui-widget-content ui-corner-all"/>
  
       <!-- Allow form submission with keyboard without duplicating the dialog button -->
       <input type="submit" tabindex="-1" style="position:absolute; top:-1000px"/>
     </fieldset>
   </form>
 </div>
	

	<div id="wrap">
	
		<c:import url="/WEB-INF/views/inc/header.jsp"/>
		<c:import url="/WEB-INF/views/inc/left.jsp"/>

	    <div id="rightWrap">
    
    	<div class="rightBlock">
            <div class="page_top">
                <h1 style = "background-color:#779988;">${boardMapDTO.mapName} cheer up~</h1>
                
            </div>
            
            <div class="boardWrap">
                
                <table class="base_tbl">
                    <thead>
                        <tr>
                            <th colspan="6" class="t_color" style = "font-size:50px; ">${view.title}</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td width="10%">작성자</td>
                            <td width="20%" class="t_color"  id="viewUser" style="cursor: pointer;">${view.userName}</td>
                            <td width="10%">작성일</td>
                            <td width="20%" class="t_color"><fmt:formatDate value ="${view.regDt}" pattern = "yyyy-MM-dd"/></td>
                            <td width="10%">조회수</td>
                            <td width="20%" class="t_color">${view.cntRead}</td>
                        </tr>
                        <tr>
                            <td width="8%">첨부파일</td>
		                    <c:forEach items = "${view.fileList}"  var="file">
                            <td class="txtCut alignLeft"><a href = "${_ctx}/file/downloadFile.java6?docId=${file.docId}&fileSno=${file.fileSno}">${file.orgFileName}</a></td>
        	               <br/> </c:forEach>
                        </tr>
                        
                        <tr>
                            <td colspan="6" class="alignLeft" style = "font-size:40px; ">${view.boardContents}</td>
                        </tr>
                    </tbody>
                </table>
                
                <div class="btnSet">
                    <a href="${_ctx}/board/doc/list.java6?${search.params}" class="disPB btnBase">목록</a>
                    <a href="${_ctx}/board/doc/edit.java6?${search.params}&docId=${view.docId}" class="disPB btnBase">수정</a>
                    <a href="#" class="disPB btnBase" onclick="deleteFile(${view.docId})">삭제</a>
                    <img src="${_ctx}/res/images/like/ignore.PNG" 
                    style="width: 40px; cursor:pointer;" 
                    id="btnLike"
                    data-like-yn="${view.likeYn}"
										data-like-id="${view.likeId}"/>
                </div>
                
                <div class="replyWrap" id = "commentWrap">
                	
                    
                </div>
                
               
            </div>
        </div>
    
    </div>
    
	   	
    	 
    </div>
	


</body>
</html>
