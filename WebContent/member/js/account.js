var account = {
		init : function(){
			$("#search_sex").select2({
				  placeholder: "性别",
				  data: [{id : 0, text : '全部'},{id : 1, text : '男'},{id : 2, text : '女'}],
				  width : '100%'
			}).val(0).trigger("change");
			
			$("#search_wechat").select2({
				  placeholder: "绑定微信",
				  data: [{id : 0, text : '全部'},{id : 1, text : 'Y'},{id : -1, text : 'N'}],
				  width : '100%'
			}).val(0).trigger("change");
			
			$('.date').datepicker({format:"yyyy-mm-dd"});
			
			$("#account_grid").bootgrid({
				title : '123',
				ajax : true,
			    url: server.basepath + 'accountAction/userList',
			    getSearchVal : account.getSearchVal,
			    multiSort: true,
			    rowCount: [10, 20, 50],
			    labels: {
			    	search : '搜索',
			    	infos : '第 {{ctx.start}}条 到 第{{ctx.end}}条 共 {{ctx.total}} 条',
			    	refresh : '刷新'
			    },
			    formatters: {
			    	rowNumber : function(column, row){
			    		var rowIndex = 0;
			    		 $.each($("#account_grid").bootgrid("getCurrentRows"),function(idx,itm){
			    			 if(this.userId == row.userId){
			    				 rowIndex = idx + 1;
			    				 return false;
			    			 }
			    		 });
			    		 return rowIndex;
			    	},
			    	sex : function(column, row){
			    		return row.userSex == 1 ? '男' : '女';
			    	},
			    	boundWechat : function(column, row){
			    		return row.userWechatid ? '<i class="fa fa-check text-navy"></i>' : '<i class="fa fa-remove text-danger"></i>';
			    	},
			    	commands : function(column, row){
			    		return '<button class="btn btn-warning btn-xs user-edit" title="编辑" data-userid="'+row.userId+'"><i class="fa fa-pencil fa-fw"></i></button>&nbsp;&nbsp;&nbsp;&nbsp;' + '<button class="btn btn-primary btn-xs '+(row.userWechatid ? '' : 'disabled')+' user-wechat" title="解除绑定" data-userid="'+row.userId+'"><i class="fa fa-wechat fa-fw"></i></button>';  
			    	}
			    }
			}).on('loaded.rs.jquery.bootgrid',function(){
				$(this).find(".user-edit").on("click", function(e){
					var userid = $(this).data('userid');
					forward('member/accountedit.html?userid=' + userid);
				});
				$(this).find(".user-wechat").on("click", function(e){
					var userid = $(this).data('userid');
					if($(this).hasClass('disabled')) return;
					 swal({
					        title: '确认操作',
					        text: "解除该用户当前绑定微信账号",
					        type: "warning",
					        showCancelButton: true,
					        confirmButtonColor: "#DD6B55",
					        confirmButtonText: "解除绑定",
					        cancelButtonText : '取消',
					        closeOnConfirm: false
					    }, function () {
					    	account.unbindWechat(userid);
					 });
				});
			});
		},
		unbindWechat : function(userid){
			$.ajax({
				url : server.basepath + 'accountAction/updateUser',
				data : {
					userId : userid,
					userWechatid : ''
				},
				dataType : 'json',
				success : function(res){
					swal("成功!", "该用户已解除微信绑定", "success");
					$("#account_grid").bootgrid('reload');
				}
			});
		},
		getSearchVal : function(){
			return {
				userWechatid : $("#search_wechat").select2().val(),
				userMobile : $('#search_mobile').val().toString().replace(/-/g,''),
				userNickname : $('#search_nickname').val(),
				userSex : $("#search_sex").select2().val(),
				userBirthday : $('#search_birthday').val()
			};
		}
};

$(function () {
	account.init();
});