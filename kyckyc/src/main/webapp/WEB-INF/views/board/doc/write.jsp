<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<c:import url="/WEB-INF/views/inc/head.jsp"/>
	<!-- 글쓰기 에디터 -->
	<script type="text/javascript" src="${_ctx}/res/editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
	
	
	<script>
		// 저장
		$(document).ready(function() {
			$("#btnDocSave").click(function() {
				if($("#frmWrite").valid()) {
					 
					// 에디터의 내용이 textarea에 적용된다.
				    oEditors.getById["boardContents"].exec("UPDATE_CONTENTS_FIELD", []);
					
					 $("#frmWrite").submit();
				}
			
			});
			//글쓰기 에디터(정렬,글자크기,복사붙이기 등)
			var oEditors = [];

			nhn.husky.EZCreator.createInIFrame({
	
	    oAppRef: oEditors,
	
	    elPlaceHolder: "boardContents",
	
	    sSkinURI: "${_ctx}/res/editor/SmartEditor2Skin.html",
	
	    fCreator: "createSEditor2"

	});
		});
		
		// 첨부파일 추가
		function addFile() {
			var appendingFileHtml = "<input type='file' name='files' style='width:90%'/> <img src='${_ctx}/res/images/del.png' style='width:2%' cursor:'pointer;' onclick='delFile(this);'/> " ;
			
			var fileLength = $("#tdFile>input[type='file']").length;
// 			var fileLength = $("td#tdFile > input[type=file]").length 
			
			
			if (fileLength < 5) {
				$("#tdFile").append(appendingFileHtml).append($("#del"));
				
			} else {
				alert('그만 올려');
			}
			
		}
		
		// 첨부파일 input 삭제
		function delFile(obj) {
			$(obj).prev().remove(); // input remove
			$(obj).remove();
		}
		
		
// 		$("#frmWrite").ajaxSubmit({
// 			type: 'POST'
// 			, url : '${_ctx}/board/doc/write'
// 			, dataType : 'JSON'
// 			, beforeSubmit : function(){
// 			}
// 			, success : function(data){
// 				if(data.code == -1){
// 					alert(data.msg);
// 				} else {
// 					goView(data.pk);
// 				}
// 			}
// 		});
		
	</script>
</head>

<body>
	<div id="wrap">
	
		<c:import url="/WEB-INF/views/inc/header.jsp"/>
		<c:import url="/WEB-INF/views/inc/left.jsp"/>

	   <div id="rightWrap">
    
	    	<div class="rightBlock">
	            <div class="page_top">
	                <h1>${boardMapDTO.mapName}</h1>
	            </div>
	            
	            <div class="boardWrap">
	            
	            	<form id = "frmWrite"  name = "frmWrite" 
	            		action = "${_ctx}/board/doc/write.java6" method = "post" enctype="multipart/form-data"> 
	                
		                <input type = "hidden" name = "mapId" value="${search.mapId}"/>
		                <input type = "hidden" name = "mapId" value="${boardMapDTO.mapId}"/>
		                <input type = "hidden" name = "page" value="${search.page}"/>
		                <input type = "hidden" name = "searchType" value="${search.searchType}"/>
		                <input type = "hidden" name = "searchText" value="${search.searchText}"/>
		                
		                
		                
		                
		                <table class="base_tbl tbl_write">
		                	<tr>
		                        <th width="20%" class="t_color">제목입력</th>
		                        <td><input type="text" name="title" required/></td>
		                    </tr>
		                    <tr>
		                        <th class="t_color">내용입력</th>
		                        <td><textarea name = "boardContents" id="boardContents" required></textarea></td>
		                    </tr>
		                    <tr>
		                        <th class="t_color" style="padding: 30px 30px">첨부파일 <br/><br/>
		                         <a href="javascript:addFile();" class="addFileButton" style="padding: 10px 20px">추가</a>
		                        </th>
		                        <td id="tdFile" style="width:90%">
		                       </td>
		                    </tr>
		                </table>
		                
		                <div class="btnSet alignCenter">
		                    <a href="#" id="btnDocSave" class="disPB btnBase">저장</a>
		                    <a href="${_ctx}/board/doc/list.java6?mapId=${mapId}" class="disPB btnBase">취소</a>
		                </div>
	               
	               </form>
	            
	            </div>
	            
	        </div>
    	 
    </div>
	</div>

</body>
</html>
