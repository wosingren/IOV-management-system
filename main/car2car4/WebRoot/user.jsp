<%@ page language="java"  import="java.util.*,java.sql.*"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="web/css/index.css">
    <%request.setCharacterEncoding("utf-8"); %>

   
  </head>
  <body class="mian_bj" >
  
<div class="mian_top_01">
<!-- <div class="mian_top_r"></div>
<div class="mian_top_l"></div> -->
<div class="mian_top_c">
<!--<ul>
<li><a><p>用户信息列表</p></a></li>
</ul>  -->
</div>
<div class="mian_b">
<div class="mian_b0">
<table>
<tr><td>
<!-- <a id="delBtn" href="#" title="删除" class="mian_b0_a1"></a> -->
<button id="delBtn" type="button" class="mian_b0_a1">delete</button> 
</td><td><span class="mian_b0_span">批 量 删  除</span></td></tr></table>

<!-- <label>删除</label> -->
</div>
<div class="mian_b1">

<form action="" method="post">
<!-- <p class="mian_b1_sousuo"><label>序 号</label><input name="xuhao" type="text" id="keyid">

</p> -->
<table>
<tr>
<td>
<label>等 级</label></td><td><!-- <input name="xuhao" type="text" id="keyid" class="mian_b1_sousuo"> -->
                               <select id="keygrade"  class="mian_b1_select">
                                    <option value="1" selected="">system manager</option>
                                    <option value="2">ordinary user</option>
                                    <option value="3">temporary user</option>
                                 
</td>

<td>
<label>用 户</label></td><td><input name="yonghu" type="text" id="keyname" class="mian_b1_sousuo"></td>
<td><a href="#" title="搜索" class="mian_b1_a3" id="search" type="button"></a></td>
</tr>
</table>
</div>
<div class="mian_b11">

</form>
<!--  
<a href="#" title="搜索" class="mian_b1_a3"></a>
<a href="#" title="最后" class="mian_b1_a4"></a>
<a href="#" title="下一页" class="mian_b1_a5"></a>
<p class="mian_b1_list">1 2 3 4……</p>
<a href="#" title="上一页" class="mian_b1_a6"></a>
<a href="#" title="最前" class="mian_b1_a7"></a>
-->

<!-- 下面的form表单是文件上传模块 -->
<form enctype="multipart/form-data"  method="post" action="${pageContext.request.contextPath }/UploadFileServlet" class="form_upload">

<%-- 类型enctype用multipart/form-data，这样可以把文件中的数据作为流式数据上传，不管是什么文件类型，均可上传。--%>
<label>
<span>上传文件</span>
<input type="file" name="upfile" size="20" class="g-file">
<input type="submit" value="提交" class="button" id="gfile">
</label>
</form>
</div>

<table id="usertable" width="100%" border="0" cellpadding="0" cellspacing="0" class="mian_b_bg" style="text-align:center">
<tr>
<td width="12%" class="mian_b_bg_lm" id="staffxuhao"><span></span>序 号</td>
<td width="12%" class="mian_b_bg_lm" id="staffshenfen"><span></span>用 户 名</td>
<td width="12%" class="mian_b_bg_lm" id="staffxingming"><span></span>密 码</td>
<td width="12%" class="mian_b_bg_lm" id="staffmima"><span></span>等 级</td>
<td width="12%" class="mian_b_bg_lm" id="staffcheliang"><span></span>对 应 车 辆</td>
<!-- <td width="8%" class="mian_b_bg_lm"><span></span>紧急程度</td>-->
<!-- <td class="mian_b_bg_lm"><span></span>操作</td>  -->
</tr>
<!-- 此处原来为从本地数据库读取数据显示行代码 -->


<!-- <td width="5%" class="mian_b_icon_02"><a href="TaskDetail.html">查看</a></td> -->


</table>
</div>
</div>
    <script type="text/javascript" src="web/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="web/js/mtable.js"></script>
    <script type="text/javascript" src="web/js/json2.js"></script>
</body>
 
</html>