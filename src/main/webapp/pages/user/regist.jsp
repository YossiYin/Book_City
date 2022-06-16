<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<!--	<base href="http://localhost:8080/Book_City/">-->
<!--	<link type="text/css" rel="stylesheet" href="static/css/style.css" >-->
	<link type="text/css" rel="stylesheet" href="http://localhost:8080/Book_City/static/css/style.css" >
	<script src="../../static/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		//此处写功能、事件
		//页面加载完成
		$(function (){
			//设置注册按钮点击事件
			$("#sub_btn").click(function (){

				//1. 验证用户名,必须由字母，数字下划线组成，并且长度为 5 到 12 位
				var nameVal = $("#username").val();//获得用户名

				var namePatt=/^\w{5,12}$/;

				//使用test方法验证
				if(!namePatt.test(nameVal)){
					$(".errorMsg").text("用户名输入错误");
					return false;
				}


				//2.验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
				var passwordVal = $("#password").val();//获得密码

				var passwordPatt=/^\w{5,12}$/;

				//使用test方法验证
				if(!passwordPatt.test(passwordVal)){
					$(".errorMsg").text("密码不合法");
					return false;
				}

				//3.验证确认密码：和密码相同
				var confirmpasswordVal = $("#repwd").val();//获得输入的确认密码

				//验证
				if(passwordVal != confirmpasswordVal){
					$(".errorMsg").text("两次密码输入不一样");
					return false;
				}

				//4.邮箱验证： xxxxx@xxx.com
				var emailVal = $("#email").val();//获得邮箱

				var emailPatt= /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;

				//使用test方法验证
				if(!emailPatt.test(emailVal)){
					$(".errorMsg").text("邮箱输入错误");
					return false;
				}

				//5.验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成

				var codeVal = $("#code").val();
					//去除前后空格
				codeVal = $.trim(codeVal);
				if(codeVal ==null  ||  codeVal == ""){
					$(".errorMsg").text("请输入验证码");

					return false;
				}


				//如果成功将清除所有信息
				$(".errorMsg").text("");
			})


		})


	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg"></span>
							</div>
							<div class="form">
								<form action="http://localhost:8080/Book_City/userServlet" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
									<img alt="" src="../../static/img/code.bmp" style="float: right; margin-right: 40px">									
									<br />
									<br />
									<%--设置隐藏域判断表单类型--%>
									<input type="hidden" name="action" value="register">
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>