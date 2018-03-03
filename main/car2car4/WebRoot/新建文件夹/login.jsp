<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    <link rel="stylesheet" href="web/assets/css/layout.css">
    <script src="web/assets/js/md5.js" type="text/javascript"></script>
	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="http://malsup.github.io/jquery.form.js" type="text/javascript"></script>
</head>
<body>
	<%
		String message="";
		String msg=(String)request.getAttribute("msg");
              if(msg==null){
    	           msg=message;
                 }
	 %>
		<div class="page-container">
            <h1>基于位置感知的车辆定位系统</h1>
        </div>
        <div class="page-heng">
            <form class="container"  method="post">
                <table class="intable-top">
                <tr>
                <td><label>用户名</label></td>
                <td><input type="text" name="username" class="username" placeholder="请输入您的用户名! "/></td>
                </tr>
                <tr>
                <td><label> 密    码 </label></td>
                <td><input type="password" name="password" class="password" placeholder="请输入您的密码！"/></td>
                </tr>
                </table>
                <table>  
                <tr>  
                <td><button type="submit" class="submit_button" name="send" id="login"> 登  录</button></td>
                <td><button type="submit" class="submit_button" name="manager" id="admister">管理员</button></td>
                </tr>
                </table>
           		<p style="color:red;font-weight:bold;"><%=msg %></p>
            </form>
        </div>
        <h2>北京邮电大学联合研发</h2>

	<script type="text/javascript">
	jQuery(document).ready(function() {
	$('#login').on('click',function(){

        $('form').on('submit',function(){
            //var username = hex_md5($('input[name=username]').val());
            //var password = hex_md5($('input[name=password]').val());
            
            var username = $('input[name=username]').val();
            var password = $('input[name=password]').val();
        	
        $(this).ajaxSubmit({
            type:'post',
            url:'DoLoginServlet',
            data:{
                'username':username,
                'password':password,
                //'flag':"user"
            },
            dataType:'json',
            success:function(res,status){
               var grade = res.grade;
               var devId = res.devId;
               window.location.href="wmap.jsp?grade="+grade+"&devId="+devId;
            },
            error:function(res,status){
                alert("请先登录！");
            }
        });
        $(this).resetForm(); // 重置表单
        return false; //阻止表单自动提交事件
    	});
      });
      
      $('#admister').on('click',function(){
            $('form').on('submit',function(){
            //var username = hex_md5($('input[name=username]').val());
            //var password = hex_md5($('input[name=password]').val());
            
            var username = $('input[name=username]').val();
            var password = $('input[name=password]').val();
        	
        $(this).ajaxSubmit({
            type:'post',
            url:'DoLoginServlet',
            data:{
                'username':username,
                'password':password
            },
            dataType:'json',
            success:function(res,status){
               var getVal = res.grade;
               if(getVal == "3"){
                window.location.href="mobile.jsp";
               }
            },
            error:function(res,status){
                //alert("请先登录！");
            }
        });
        $(this).resetForm(); // 重置表单
        return false; //阻止表单自动提交事件
    	});
      });
	});
    
	</script>
</body>
</html>