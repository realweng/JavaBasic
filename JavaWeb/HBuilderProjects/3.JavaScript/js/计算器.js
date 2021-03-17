// 计算2个数组的和
			var numberStr = prompt("请输入第一个数字", 0);
			var number2Str = prompt("请输入第二个数字", 0);
			var numx = prompt("请输入运算符", "+");
			console.log(typeof(numberStr) + typeof(number2Str));
			// 将number、number2转为number
			// parseInt()：将string诸位整数
			var number = parseInt(numberStr);
			var number2 = parseInt(number2Str);
			// 在js中，如果string第一个字符是数字，同样可以将是数字的部分转为number
			// 如果第一个字符就不是数字，那么NAN==>非数字
			console.log(number + "" + number2);
			// parseFloat()：将string转为小数
			number = parseFloat(numberStr);
			number2 = parseFloat(number2Str);
			console.log(number + "" + number2);
			switch (numx) {
				case "+":
					var num = number + number2;
					break;
				case "-":
					var num = number - number2;
					break;
				case "*":
					var num = number * number2;
					break;
				case "/":
					var num = number / number2;
					break;
				default:
					break;
			}
			document.write(number + numx + number2 + "=" + num)