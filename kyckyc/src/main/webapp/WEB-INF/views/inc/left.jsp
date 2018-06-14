<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type = "text/javascript">
	$(function(){
		loadTreeMap();
	});
	//통합맵 가져오기
	function loadTreeMap(){
		d = new dTree('d');
		d.config.ctx = "${_ctx}";
		
		var url = "${_ctx}/board/map/list.java6";
		$.get(url, function(json){
			console.log(json);
			if($.isArray(json)) {
				$(json).each(function(index){
					console.log(this);
					
					if (this.parMapId == null) {
						d.add(this.mapId, -1, this.mapName);
					}else{
						d.add(this.mapId, this.parMapId, this.mapName, "${_ctx}/board/doc/list.java6?mapId="+this.mapId);
					}
				});
				d.add(100000, 1 , "팝업관리" , "${_ctx}/popup/list.java6");
				$("#dtree").html(d.toString());
			}
		});
	}
// 		function listInLeft(mapId) {
// 		console.log(mapId);
// 		document.location.href = "${_ctx}/board/doc/list.java6?mapId="+mapId;
// 		}
	
</script>

<div id="leftWrap">
    
    	<div id="infoWrap">
        
        	<div class="info_txt">
                <p class="info_name">${_user.name}</p>
                <p class="info_date">${_user.email}
                [${_user.phone}]</p>
                <p class="info_pic">
                	<img src="${_ctx}/res/images/dark.PNG" alt="thum"></p>
            </div>
            
            <span>
            <a href="${_ctx}/edit.java6" style="width: 45%; display: inline-block;">정보수정</a>
            <a href="${_ctx}/logout.java6" style="width: 45%; display: inline-block;">Logout</a>
            </span>
        
        </div>
        
        <div id="category">
        
        	<!-- dtree 시작 -->
            <div class="dtree" id ="dtree">
            </div>
            <!-- dtree 끝 -->
        
        </div>
    
    </div>