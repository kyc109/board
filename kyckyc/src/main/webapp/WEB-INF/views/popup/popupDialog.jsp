<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	var doalog
	$(document).ready(function() {

		//팝업
		dialog = $(".dialog").dialog({
			autoOpen : false,
			height : 500,
			width : 500,
			modal : true,
			buttons : {

			},
			close : function() {
			}
		});

		dialog.dialog("open");

	});
</script>


<c:forEach items="${list}" var="popupDTO">
	<c:if test="${popupDTO.useYn == 'Y'}">
		<div class="dialog" title="${popupDTO.title}">
			<c:forEach items="${popupDTO.fileList}" var="file">
				<img src="${_ctx}/${file.filePath}/${file.newFileName}" id="img" style="width: 200px;" />
				<br />
			</c:forEach>
		</div>
	</c:if>
</c:forEach>
