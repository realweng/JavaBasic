$(function() {
	//新增
	$("body").on("click", "#saveHero", function() {
		//获取模态框中输入的值
		var $name = $("#name").val();
		var $life = $("#life").val();
		var $power = $("#power").val();

		//新建一行
		var $tr = $("<tr></tr>");
		//新建列
		var $td1 = $("<td>" + $name + "</td>");
		var $td2 = $("<td>" + $life + "</td>");
		var $td3 = $("<td>" + $power + "</td>");
		var $td4 = $(
			'<td><button name="change" class="btn btn-primary" data-toggle="modal" data-target="#myModal2">修改</button> ' +
			'<button name = "delete" class="btn btn-danger">删除</button></td>');

		//将列添加到一行中
		$tr.append($td1).append($td2).append($td3).append($td4);
		//将行添加到table中
		$("#hero").append($tr);

		//关闭模态框
		$("#myModal").modal('hide');
	});

	//修改--有bug
	$("table").on("click","[name=change]",function(){
		//获取当前的行
		var $obj = $(this).parent().siblings();
		$("div").on("click", "#changeHero", function() {
			//获取模态框中的值
			
			var name = $("#name1").val();
			var life = $("#life1").val();
			var power = $("#power1").val();
			
			//将各项值填充到要修改的那一行
			console.log($obj);
			$obj[0].innerText = name;
			$obj[1].innerText = life;
			$obj[2].innerText = power;
			//关闭修改模态框
			$("#myModal2").modal('hide');
		});
	});
	
	//删除
	$("table").on("click","[name=delete]",function(){
		$(this).parent().parent().remove();
	});
});
