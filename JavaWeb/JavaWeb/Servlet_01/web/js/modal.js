$(function() {

	$("#saveHero").click(function() {

		// 获取输入框的值
		var name = $("#name").val();
		var life = $("#life").val();
		var power = $("#power").val();

		// 创建tr
		var $tr = $("<tr></tr>")

		// 创建td   输入框的值
		var $td1 = $("<td>" + name + "</td>");
		var $td2 = $("<td>" + life + "</td>");
		var $td3 = $("<td>" + power + "</td>");
		var $td4 = $('<td><button class="btn btn-primary">修改</button>' +
			'<button class="btn btn-danger">删除</button></td>');


		// 将td加到tr
		$tr.append($td1).append($td2).append($td3).append($td4);

		// 将tr加到table
		$("#hero").append($tr);
		
		// 将数据传递到servlet完成数据添加（数据库）。。。。(ajax)

		// 关闭模态框
		$("#myModal").modal('hide');



	});

})
