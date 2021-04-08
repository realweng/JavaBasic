// <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
$(function () {
    // 新增
    $("#addProduct").click(function () {
        // 获取form表单中的数据
        var formData = $("#saveFrm").serialize();
        console.log(formData);

        //  使用.post请求服务器完成添加
        $.post("productAjax.do", "type=saveProduct&" + formData, function (data) {
            alert(data);
            if (data == "添加成功") {
                // 隐藏模态框
                $("#myModal").modal('hide');
                // location.href = "productAjax?type=showProduct&nowPage=5";
            }
        });
    });

    // 修改
    $("[name=change]").click(function () {
        //获取当前的行
        var $obj = $(this).parent().siblings();
        var productId = $($obj[0]).text();//获取选中商品编号
        // alert(productId.trim());
        $.get("productAjax.do", "type=initUpdate&productId=" + productId.trim(), function (data) {
            // alert(data);
            data = jQuery.parseJSON(data);
            // alert(data);
            $("#productName1").val(data.productName);
            $("#typeId1").val(data.typeId);
            $("#productPrice1").val(data.productPrice);
            $("#productNum1").val(data.stockNumber);
            $("#discount1").val(data.discount);
            $("#updateProduct").click(function () {
                // 获取form表单中的数据
                var formData = $("#updateFrm").serialize();
                console.log(formData);
                //  使用.post请求服务器完成添加
                $.post("productAjax.do", "type=update&" + formData + "&productId=" + productId.trim(), function (data) {
                    alert(data);
                    if (data == "修改成功") {
                        // 隐藏模态框
                        $("#myModal1").modal('hide');
                        // location.href = "productAjax?type=showProduct&nowPage=5";
                    }
                });
            });
        });
    });

    //删除
    $("[name=delete]").click(function (){
        //获取当前的行
        var $obj = $(this).parent().siblings();
        var productId = $($obj[0]).text();//获取选中商品编号
        var flag = confirm("是否确认删除？");
        if(flag){
            $.get("productAjax.do", "type=delete&productId=" + productId.trim(), function (data) {
                alert(data);
            });
        }
    });


    // 输入校验
    $("#productName,#productName1").blur(function () {
        var productNameValue = $(this).val();
        if (productNameValue == "") {
            $(this).parent().next("div").html("用户名不能为空").css("color", "red");
        } else {
            $(this).parent().next("div").html("");
        }
    });

    $("#productPrice,#productPrice1").blur(function () {
        var reg = /^(\d+(\.\d+)?|\d+)$/;
        var productPriceValue = $(this).val();
        if (!reg.test(productPriceValue)) {
            $(this).parent().next("div").html("价格输入，请输入数字!").css("color", "red");
        } else {
            $(this).parent().next("div").html("");
        }
    });

    $("#productNum,#productNum1").blur(function () {
        var reg = /^\d+$/;
        var productNumsValue = $(this).val();
        if (!reg.test(productNumsValue)) {
            $(this).parent().next("div").html("数量输入，请输入数字!").css("color", "red");
        } else {
            $(this).parent().next("div").html("");
        }
    });

    $("#discount,#discount1").blur(function () {
        var reg = /^(0(\.\d+)?|1(\.[0]+)?)$/;
        var productDiscount = $(this).val();
        if (!reg.test(productDiscount)) {
            $(this).parent().next("div").html("折扣输入，请输入0-1的数字").css("color", "red");
        } else {
            $(this).parent().next("div").html("");
        }
    });

    $("#saveFrm,#updateFrm").submit(function () {
        var productNameValue = $(this).val();
        if (productNameValue == "") {
            $("#productName,#productName1").parent().next("div").html("商品名不能为空!").css("color", "red");
            return false;// 防止表单提交
        } else {
            $("#productName,#productName1").parent().next("div").html("");
        }

        var reg = /^(\d+(\.\d+)?|\d+)$/;
        var productPriceValue = $("#productPrice,#productPrice1").val();
        if (!reg.test(productPriceValue)) {
            $("#productPrice,#productPrice1").parent().next("div").html("价格输入有误，请输入数字!").css("color", "red");
            return false;// 防止表单提交
        } else {
            $("#productPrice,#productPrice1").parent().next("div").html("");
        }

        var reg = /^\d+$/;
        var stockNumberValue = $("#productNum,#productNum1").val();
        if (!reg.test(stockNumberValue)) {
            $("#productNum,#productNum1").parent().next("div").html("数量输入有误，请输入数字!").css("color", "red");
            return false;// 防止表单提交
        } else {
            $("#productNum,#productNum1").parent().next("div").html("");
        }

        var reg = /^(0(\.\d+)?|1(\.[0]+)?)$/;
        var productDiscount = $("#discount,#discount1").val();
        if (!reg.test(productDiscount)) {
            $("#discount,#discount1").parent().next("div").html("1折扣输入，请输入0-1的数字").css("color", "red");
            return false;// 防止表单提交
        } else {
            $("#discount,#discount1").parent().next("div").html("");
        }
        return true;//提交表单
    });
});
