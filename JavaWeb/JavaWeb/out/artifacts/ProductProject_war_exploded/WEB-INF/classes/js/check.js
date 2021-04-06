// <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
$(function () {
    $("#addProduct").click(function () {
        // 获取form表单中的数据
        var formData = $("#saveFrm").serialize();
        console.log(formData);

        //  使用.post请求服务器完成添加
        $.post("productAjax", "type=saveProduct&" + formData, function (data) {
            alert(data);
            if (data == "添加成功") {
                // 隐藏模态框
                $("#myModal").modal('hide');
                location.href = "productAjax?type=showProduct&nowPage=5";
            }
        });
    });

    $("#productName").blur(function () {
    var productNameValue = $(this).val();
    if (productNameValue == "") {
    $(this).parent().next("div").html("用户名不能为空").css("color", "red");
} else {
    $(this).parent().next("div").html("");
}
});

    $("#productPrice").blur(function () {
    var reg = /^(\d+(\.\d+)?|\d+)$/;
    var productPriceValue = $(this).val();
    if (!reg.test(productPriceValue)) {
    $(this).parent().next("div").html("价格输入，请输入数字!").css("color", "red");
} else {
    $(this).parent().next("div").html("");
}
});

    $("#productNum").blur(function () {
    var reg = /^\d+$/;
    var productNumsValue = $(this).val();
    if (!reg.test(productNumsValue)) {
    $(this).parent().next("div").html("数量输入，请输入数字!").css("color", "red");
} else {
    $(this).parent().next("div").html("");
}
});

    $("#discount").blur(function () {
    var reg = /^(0(\.\d+)?|1(\.[0]+)?)$/;
    var productDiscount = $(this).val();
    if (!reg.test(productDiscount)) {
    $(this).parent().next("div").html("折扣输入，请输入0-1的数字").css("color", "red");
} else {
    $(this).parent().next("div").html("");
}
});

    $("#saveFrm").submit(function () {
    var productNameValue = $(this).val();
    if(productNameValue==""){
    $("#productName").parent().next("div").html("商品名不能为空!").css("color", "red");
    return false;// 防止表单提交
}else {
    $("#productName").parent().next("div").html("");
}

    var reg = /^(\d+(\.\d+)?|\d+)$/;
    var productPriceValue = $("#productPrice").val();
    if (!reg.test(productPriceValue)) {
    $("#productPrice").parent().next("div").html("价格输入有误，请输入数字!").css("color", "red");
    return false;// 防止表单提交
} else {
    $("#productPrice").parent().next("div").html("");
}

    var reg = /^\d+$/;
    var stockNumberValue = $("#productNum").val();
    if (!reg.test(stockNumberValue)) {
    $("#productNum").parent().next("div").html("数量输入有误，请输入数字!").css("color", "red");
    return false;// 防止表单提交
} else {
    $("#productNum").parent().next("div").html("");
}

    var reg = /^(0(\.\d+)?|1(\.[0]+)?)$/;
    var productDiscount = $("#discount").val();
    if (!reg.test(productDiscount)) {
    $("#discount").parent().next("div").html("1折扣输入，请输入0-1的数字").css("color", "red");
    return false;// 防止表单提交
} else {
    $("#discount").parent().next("div").html("");
}
    return true;//提交表单
});
});
