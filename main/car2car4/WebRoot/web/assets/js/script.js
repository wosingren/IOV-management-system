	$(function(){

	
		var $opt = $('#tae');
		var $all = $('#all');
		
		function change(){
        	var panelHeigt = $(window).height()+"px";
            //alert(panelHeigt);
            $(".m-panel").css({"height":panelHeigt});

            var mapWidth = $(window).width() - $("#j-panel").outerWidth(true);
            var mapHeight = $("#j-panel").outerHeight(true);
            //alert(mapWidth);
            //alert(mapHeight);
            $(".m-container").css({
                "width":  mapWidth + "px",
                 "height": mapHeight + "px",
                 "float":  "left",
                 "position": "relative"
            });   
        }     
        change();
        window.onresize = change;
        
 		function load() {

        if(sessionStorage.userGrade)
           
           	if(sessionStorage.userGrade == "2"){
           		// 临时用户
           		tempSelect();
           		$("#num").val(sessionStorage.devId + "");
           		showLocation();
           	}else{
           		$("#num").attr("disabled",false);
           		listSelect();
           		showLocation();
           	}
      	else{
           	alert("请先登录！")
            window.location.href = '../login.html';
        }    
		}
		load();
	
		// 筛选车辆
		function listSelect(){
			$('#vehicel').change(function(){
				if($('#vehicel option:selected').val() == "all"){
					$('#j-number').css("visibility","hidden");
					$opt.remove();
					$('#j-rank').show();
					$('#j-time').hide();
				}else if($('#vehicel option:selected').val() == "one"){
					$('#j-number').css("visibility","visible");
					$('#show').append($opt.remove());
					$('#show').get(0).selectedIndex = 0;
					$('#j-rank').show();
					$('#j-time').hide();
				}
			});
		}
		
		// 加载临时用户
		function tempSelect(){
			$all.remove();
		}

		function showLocation(){
			$('#show').change(function(){
					if($('#show option:selected').val()=="loc"){
						$('#j-rank').show();
						$('#j-time').hide();
					}
					if($('#show option:selected').val()=="trace"){
						$('#j-rank').hide();
						$('#j-time').show();
					}
					
			});

		}
		
	});


	

