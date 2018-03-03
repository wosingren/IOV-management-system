$(function(){

	var g_table=$("table.mian_b_bg");
	var init_data_url="ManageUserServlet";
	
	$.get(init_data_url,{item:1},function(data){
		//[{"id":xxx,"xingming":""},{},{}]
		var row_items=$.parseJSON(data);
		for(var i=0,j=row_items.length;i<j;i++){
			var data_dom=createRow(row_items[i],i);
			g_table.append(data_dom);
		}
	});
    
	//机械重复的创建列表的每一行	
	function createRow(rowObj,i){
		rowObj = rowObj;
		//console.log(rowObj);
		var rowId;
		rowDom = $("<tr></tr>");
		//以下是每行加入复选框的代码，参考http://www.jb51.net/article/35363.htm
		//程序产生了一个checkBox和一个文本节点，并将它们放到一个li对象中，再将li对象添加到rowDom对象中
        var checkBox=document.createElement("input");
        checkBox.setAttribute("type","checkbox");
        checkBox.setAttribute("id",i+1);
        checkBox.setAttribute("name", "cb");

        var li;
		li = $("<td></td>");
        li.append(checkBox);        
        li.append(document.createTextNode(i+1));
		rowDom.append(li); 
		
		for(m in rowObj){
			rowId = rowObj.username;
			rowDom.append($("<td>" + rowObj[m] +"</td>"));		
		}	
        //给每一个复选框指定id
        $(checkBox).data("currentId",rowId);
		return rowDom;
	}
	//删除用户
	$("#delBtn").click(function(){
		var init_data_url="ManageUserServlet";
		//获取被选中的checkbox的id数组
		//var nodes = document.getElementsByName('cb');
		//复选框本身也是多个组件的名字相同
		//所以在定义复选框的同事依然要使用document.all()取得全部的内容。
		
		var nodesdom =document.all('cb');
		var nodes=$(nodesdom);
		//var nodes = $(nodes1);
		var s = 0,cid=[]; 
		for(var i=0,j=0;i<nodes.length;i++)
		{ 
			//if(nodes[i].type=="checkbox" && nodes[i].checked) 
			if(nodes[i].checked){
				//cid[j]=parseInt($(checkBox).data("currentId")); 
				cid[j++]=$(nodes[i]).data("currentId");
				$(nodes[i]).parent().parent().remove();
				/*alert("i="+i+";j="+j);*/
				
				
			}			
		}
		for(var m=0;i<cid.length;i++)
			alert(cid[m]);
		
		$.get(init_data_url,{delId:cid,item:3});
	});


	//搜索用户
	$("#search").click(function(){
		var init_data_url="ManageUserServlet";
		var sgrade=document.getElementById("keygrade").value;
		/*  value="1" system manager管理员
            value="2" ordinary user 普通用户
            value="3" temporary user临时用户*/
		var sname=document.getElementById("keyname").value;
		if((sgrade!='')||(sname!='')){
			//首先清空列表内容
			var nodesdom =document.all('cb');
			var nodes=$(nodesdom);
			for(var i=0,j=0;i<nodes.length;i++)
			{ 
				$(nodes[i]).parent().parent().remove();	
			}
			
		$.get(init_data_url,{grade:sgrade,username:sname,item:2},function(data){
			var row_items=$.parseJSON(data);
			for(var i=0,j=row_items.length;i<j;i++){
				var data_dom=createRow(row_items[i],i);
				g_table.append(data_dom);
			}
		})
		};
	});

});
