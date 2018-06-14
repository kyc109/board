<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
           	
     <dl>
         <dd>
         	<input type="text" id="comments" placeholder="Name" title="replyName" style="width:85%;">
         	<a href="#" id="btnComment" class="disPB btnBase"> 댓글등록</a>
         </dd>
     </dl>   
   
     
     <table class="replyList">
     	<tbody>
     		<c:forEach items = "${list}" var = "item">
     	<tr>
     	
         	<th class="name">${item.name}</th>
             <td class="cont">${item.comments}
             	<a href="#" class="disPB btnS" onclick="deleteComment(${item.commentId})">삭제</a>
             </td>
             <td class="date"><fmt:formatDate value="${item.regDt}" pattern="yyyy-MM-dd" /></td>
         </tr>
         	</c:forEach>
         
     </tbody>
     </table>
         
