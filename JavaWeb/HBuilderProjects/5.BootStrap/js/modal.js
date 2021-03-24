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

	var $updateTrObject; //全局对象

	//点击修改按钮获取这一行的对象
	$("table").on("click", "[name=change]", function() {
		//获取当前的行
		var $obj = $(this).parent().siblings();

		$updateTrObject = $obj;

		//获取这一行中的默认值
		var name = $($obj[0]).text();
		var life = $($obj[1]).text();
		var power = $($obj[2]).text();

		$("#name1").val(name);
		$("#life1").val(life);
		$("#power1").val(power);
	});


	$("#changeHero").click(function() {
		//获取模态框中的值
		var name = $("#name1").val();
		var life = $("#life1").val();
		var power = $("#power1").val();

		//将各项值填充到要修改的那一行
		console.log($updateTrObject);
		$updateTrObject[0].innerText = name;
		$updateTrObject[1].innerText = life;
		$updateTrObject[2].innerText = power;
		//关闭修改模态框
		$("#myModal2").modal('hide');
	});

	//删除
	$("table").on("click", "[name=delete]", function() {
		$(this).parent().parent().remove();
	});


	//添加姓名非空验证
	$("#name").blur(function() {
		if ($(this).val() == "") {
			$("#nameInfo").text("姓名不能为空").css("color", "red");
		} else {
			$("#nameInfo").text("");
		}
	})

	//添加验证
	$("#life").blur(function() {
		var reg = /^\d{1,}$/;
		if (!reg.test($(this).val())) {
			$("#lifeInfo").text("请输入数字").css("color", "red");
		} else {
			$("#lifeInfo").text("");
		}
	})

	//添加验证
	$("#power").blur(function() {
		var reg = /^\d{1,}$/;
		if (!reg.test($(this).val())) {
			$("#powerInfo").text("请输入数字").css("color", "red");
		} else {
			$("#powerInfo").text("");
		}
	})

	//修改验证
	$("#name1").blur(function() {
		if ($(this).val() == "") {
			$("#nameInfo1").text("姓名不能为空").css("color", "red");
		} else {
			$("#nameInfo1").text("");
		}
	})

	//修改验证
	$("#life1").blur(function() {
		var reg = /^\d{1,}$/;
		if (!reg.test($(this).val())) {
			$("#lifeInfo1").text("请输入数字").css("color", "red");
		} else {
			$("#lifeInfo1").text("");
		}
	})

	//修改验证
	$("#power1").blur(function() {
		var reg = /^\d{1,}$/;
		if (!reg.test($(this).val())) {
			$("#powerInfo1").text("请输入数字").css("color", "red");
		} else {
			$("#powerInfo1").text("");
		}
	})

});
