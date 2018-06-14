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
		
		
		
	
	</script>


</head>

<body>


   <p class="validateTips">사용자 조회</p>
	
	<div id="wrap">
	
		<c:import url="/WEB-INF/views/inc/header.jsp"/>
		<c:import url="/WEB-INF/views/inc/left.jsp"/>

	    <div id="rightWrap">
    
    	<div class="rightBlock">
            <div class="page_top">
                <h1 style = "background-color:#779988;">팝업관리 cheer up~</h1>
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
                            <td width="10%">작성일</td>
                            <td width="20%" class="t_color"><fmt:formatDate value ="${view.regDate}" pattern = "yyyy-MM-dd"/></td>
                            <td width="10%">활성화</td>
                            <td width="20%" class="t_color">${view.useYn}</td>
                        </tr>
                        <tr>
		              
                        </tr>
                        
                        <tr>
                            <td colspan="6" class="alignLeft" style = "font-size:40px; ">
                                  <c:forEach items = "${view.fileList}"  var="file">
                            <%-- <a href = "${_ctx}/file/downloadFile.java6?popupId=${file.popupId}&popupFileId=${file.popupFileId}">${file.orgFileName}</a> --%>
                            <img src="${_ctx}/${file.filePath}/${file.newFileName}" style="width: 200px; "/>
                            
        	               <br/> </c:forEach>
                            </td>
                        </tr>
                    </tbody>
                </table>
                
                <div class="btnSet">
                    <a href="${_ctx}/popup/list.java6" class="disPB btnBase">목록</a>
                    <a href="${_ctx}/popup/remove.java6?popupId=${view.popupId}" class="disPB btnBase" >삭제</a>
                </div>
               
            </div>
        </div>
    
    </div>
    
	   	
    	 
    </div>
	


</body>
</html>
