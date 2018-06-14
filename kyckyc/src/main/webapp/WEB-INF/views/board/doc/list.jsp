<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="pagetag" uri="/WEB-INF/tlds/pagetag.tld" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<c:import url="/WEB-INF/views/inc/head.jsp"/>
	
	<script>
	$(document).ready(function(){
		$("#searchType > option[value = '${search.searchType}']").attr("selected", true);
		
		$("#btnWrite").click(function(){
			document.location.href = "${_ctx}/board/doc/write.java6?mapId=${mapId}";
		});
		
		$("#searchWord").keydown(function(e){
			if(e.keyCode == 13) {
				$("#searchStart").click();
			}
		});
	});
	
	//페이지 이동
	function goPage(page){
		
		$("#page").val(page);
		
		$("#frmSearch").submit();
	}
	//조회 페이지 이동
	function goView(docId) {
		$("#frmView input[name='docId']").val(docId);
		$("#frmView").submit();
	}
	//클릭시 달력뜸	
	$( function() {
	    $( "#datepicker" ).datepicker({
	      showOn: "button",
	      buttonImage: "${_ctx}/res/images/dark.PNG",
	      buttonImageOnly: true,
	      buttonText: "Select date"
	    });
	    $('.ui-datepicker-trigger').css("width","20px");
	  } );
	
	
	

	</script>	
	
	
</head>

<body>
	<div id="wrap">
	
		<c:import url="/WEB-INF/views/inc/header.jsp"/>
		<c:import url="/WEB-INF/views/inc/left.jsp"/>
	    
	    <div id="rightWrap">
    
    	<div class="rightBlock">
            <div class="page_top">
                
                <h1 style = "background-color:#779988;">${boardMapDTO.mapName} cheer up~</h1>
                <p>Date: <input type="text" id="datepicker"/></p>
            </div>
            
            <!-- 검색 시작 -->
            <form id="frmSearch" name="frmSearch" action="${_ctx}/board/doc/list.java6" method="get"  class="search_area">
                <input type = "hidden" name = "mapId" value = "${boardMapDTO.mapId}" />
                <input type = "hidden" name = "page" id = "page" value = "${search.page}" />
                <dl>
                    <dd>
                    
                        <select id = "searchType" name="searchType" style = "height:50px;">
                            <option value="">검색조건</option>
                            <option value="T">제목</option>
                            <option value="C">내용</option>
                            <option value="TC">제목+내용</option>
                            <option value="U">작성자</option>
                        </select>
                    </dd>
                    <dd>
                        <input type="text" id = "searchWord" name = "searchText" placeholder = "검색어" style = "height:50px; width:200px;" value = "${search.searchText}" />
                    </dd>
                    <dd>
                      	<div class = "btnSet" >
                			<a href = "javascript:goPage('1');"  id = "searchStart" class = "disPB btnBase" style = "background-color:#ffccbb;">검색</a>
                		</div>
                    </dd>
                </dl>            
            </form>
            <!-- 검색 끝 -->
            
            <div class="boardWrap">
                
                <table class="base_tbl">
                    <thead>
                        <tr>
                            <th width="8%">번호</th>
                            <th width="20%">제목</th>
                            <th width="10%">작성자</th>
                            <th width="15%">등록일자</th>
                            <th width="10%">첨부파일</th>
                            <th width="10%">조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items = "${list}"  var="item">
	                        <tr>
	                            <td>${item.docId}</td>
	                            <td class="txtCut alignLeft">
<%-- 	                            	<a href="javascript:goView('${item.docId}');">${item.title}</a> --%>
	                            	<a href = "${_ctx}/board/doc/view.java6?docId=${item.docId}&${search.params}">
	                            	<%-- <c:out value="${item.title}" escapeXml="true">${item.title}</c:out> --%><!--제목 등록시 스타일 적용써도 안되게 함  --> 
	                            	${item.title}
	                            	</a>
	                            	<c:if test="${item.comments > 0}">[${item.comments}]</c:if></td>
	                            	
	                            	<td>${item.userName}</td>
	                            	
	                            	<td><fmt:formatDate value ="${item.regDt}" pattern = "yyyy-MM-dd"/></td>
	                            
	                            <td>
				                       	<c:forEach items="${item.fileList}" var="files">
				                        	<a href = "${_ctx}/file/downloadFile.java6?docId=${files.docId}&fileSno=${files.fileSno}">
				                        		<img src="${_ctx}/res/images/file.png" style="width: 40px" height="40px"/>
				                        	</a>
			                        	</c:forEach>    
	                            </td>
	                            
	                            <td><fmt:formatNumber value = "${item.cntRead}" /> </td>
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                
                <div class = "btnSet">
                	<a href = "${_ctx}/board/doc/write.java6?mapId=${search.mapId}" id = "btnWrite" class = "disPB btnBase">글쓰기</a>
                </div>
                
                	<pagetag:paging page="${search}" />
                
                
<!--                 <div id="paging"> -->
<!--                 <p> -->
<!--                 <span class="numPN"><a href="#">«</a></span> -->
<!--                 <span class="numPN over left"><a href="#">&lt;</a></span> -->
<!--                 <span class="Present"><a href="#">1</a></span> -->
<!--                 <span><a href="#">2</a></span> -->
<!--                 <span><a href="#">3</a></span> -->
<!--                 <span><a href="#">4</a></span> -->
<!--                 <span><a href="#">5</a></span> -->
<!--                 <span><a href="#">6</a></span> -->
<!--                 <span><a href="#">7</a></span> -->
<!--                 <span><a href="#">8</a></span> -->
<!--                 <span><a href="#">9</a></span> -->
<!--                 <span class="dubble"><a href="#">10</a></span> -->
<!--                 <span class="numPN  over right"><a href="#">&gt;</a></span> -->
<!--                 <span class="numPN"><a href="#">»</a></span> -->
<!--                 </p> -->
<!--                 </div> -->
    
                
            </div>
        </div>
    
    </div>
	</div>
	
	<form id = "frmView" name ="frmView" action = "${_ctx}/board/doc/view.java6" method="get">
		<input type = "hidden" name = "docId" />
		<input type = "hidden" name = "mapId"  value = "${boardMapDTO.mapId}" />
		<input type = "hidden" name = "page" value = "${search.page}"/>
		<input type = "hidden" name = "searchType" value = "${search.searchType}" />
		<input type = "hidden" name = "searchText" value = "${search.searchText}" />
	
	</form>


</body>
</html>
