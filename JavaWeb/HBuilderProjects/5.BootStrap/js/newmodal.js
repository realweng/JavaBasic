$(function(){
	$("body").on("click", "#saveHero", function() {
		//获取模态框中输入的值
		var $name = $("#name").val();
		var $life = $("#life").val();
		var $power = $("#power").val();
		
		//新建一行
		var $tr = $("<tr></tr>");
		//新建列
		var $td1 = $("<td>"+$name+"</td>");
		var $td2 = $("<td>"+$life+"</td>");
		var $td3 = $("<td>"+$power+"</td>");
		var $td4 = $('<td><button class="btn btn-primary" data-toggle="modal" data-target="#myModal2">修改</button>' +
			'<button class="btn btn-danger">删除</button></td>');
			
		//将列添加到一行中
		$tr.append($td1).append($td2).append($td3).append($td4);
		//将行添加到table中
		$("#hero").append($tr);
	
		//关闭模态框
		$("#myModal").modal('hide');
	});
});