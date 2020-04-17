<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@include file="/include/base.jsp" %>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
<script type="text/javascript">
	$(function(){
		$("#codeImg").click(function(){
			//改变src，要让浏览器知道这不是同一个请求, 浏览器有时会从缓存中加载
			var url = "code.jpg?t="+Math.random();
			$(this).prop("src", url);
		});
		
		$(".itxt[name='username']").blur(function(){
			var regUserName = /^[a-z0-9_-]{5,18}$/;
			var username = $(".itxt[name='username']").val();
			if( regUserName.test(username) ){
				$.ajax({
					type : "POST",
					url : "UserServlet?method=checkUser&username="+username,
					success : function(data){
						if ( data.length > 5 ){
							$(".errorMsg").text(data);
						} else {
							$(".errorMsg").css("color", "green");
							$(".errorMsg").text(data);
						}
					}
				});
			} else {
				$(".errorMsg").text("用户名格式错误!");
			}
			
		});
		
		$("#sub_btn").click(function(){
			var username = $(".itxt[name='username']").val();
			var password = $(".itxt[name='password']").val();
			var repwd = $(".itxt[name='repwd']").val();
			var email = $(".itxt[name='email']").val();
			var code = $(".itxt[name='code']").val();
			
			//用户名规则：长度>6  <18  不能写非法字符   合法（字母  数字，_）;
			//密码规则：长度>6 <18 不能写非法字符    合法（字母，数字，_）;
			//确认密码规则：和密码相同
			//email:  xxx@qq.com
			//验证码保证用户输入值即可
			
			var regUserName = /^[a-z0-9_-]{5,18}$/;
			var regPwd = /^[a-zA-Z0-9]{5,18}$/;
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			
			if(!regUserName.test(username)){
				$(".errorMsg").text("用户名格式错误!");
				return false;
			}
			if(!regPwd.test(password)){
				$(".errorMsg").text("密码格式错误!");
				return false;
			}
			if(repwd != password){
				$(".errorMsg").text("两次密码不一致!");
				return false;
			}
			if(!regEmail.test(email)){
				$(".errorMsg").text("邮箱格式错误!");
				return false;
			}
			if(code == ""){
				$(".errorMsg").text("请输入验证码!");
				return false;
			}
			
		});
	});
</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
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
								<span class="errorMsg">
									${empty msg?"":msg }
								</span>
							</div>
							<%
								String uuid = UUID.randomUUID().toString().replace("-", "");
								System.out.println("uuid-->"+uuid);
								session.setAttribute("token", uuid);
							%>
							<div class="form">
								<form action="UserServlet" method="post">
								<input name="token" value="${token }" type="hidden" />
								<input name="method" value="regist" type="hidden" />
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" value="${param.username }"/>
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
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" value="${param.email }"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code"/>
									<img alt="" src="code.jpg" style="float: right; margin-right: 40px; width: 90px; height: 40px;" id="codeImg">									
									<br />
									<br />
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