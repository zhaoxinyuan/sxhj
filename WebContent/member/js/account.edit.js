var accountEdit = {
		userInfo : new Object(),
		init : function(){
			$('.date').datepicker({format:"yyyy-mm-dd"});
			
			$("#user_sex_combox").select2({
				  data: [{id : 1, text : '男'},{id : 2, text : '女'}],
				  width : '100%'
			});
			
			$('.btn-save').click(function(e){
				accountEdit.updateUser(accountEdit.userInfo.userId);
				//toastr.success('Great that you decided to move a mouse.','You are back. ');
			});
			
			this.getUserInfo($.fn.getUrlParam('userid'));
		},
		getUserInfo : function(userid){
			$.ajax({
				url : server.basepath + 'accountAction/getUser',
				data : {
					userId : userid,
				},
				dataType : 'json',
				success : function(res){
					console.log(res);
					accountEdit.userInfo = res;
					$('#user_mobile_input').val(res.userMobile);
					$('#user_nickname_input').val(res.userNickname);
					$('#user_birthday_input').val(res.userBirthday);
						$("#user_sex_combox").select2().val(res.userSex).trigger("change");
				}
			});
		},
		updateUser : function(userid,dialog){
			$.ajax({
				url : server.basepath + 'accountAction/updateUser',
				data : {
					userId : userid,
					userMobile : $('#user_mobile_input').val().toString().replace(/-/g,''),
					userNickname : $('#user_nickname_input').val(),
					userSex : $("#user_sex_combox").select2().val(),
					userBirthday : $('#user_birthday_input').val(),
				},
				dataType : 'json',
				success : function(res){
					toastr.clear();
					toastr.options = {
							  "closeButton": false,
							  "debug": false,
							  "progressBar": false,
							  "preventDuplicates": false,
							  "positionClass": "toast-top-right",
							  "onclick": null,
							  "showDuration": "400",
							  "hideDuration": "1000",
							  "timeOut": "7000",
							  "extendedTimeOut": "1000",
							  "showEasing": "swing",
							  "hideEasing": "linear",
							  "showMethod": "fadeIn",
							  "hideMethod": "fadeOut"
							}
					toastr['success']("已成功修改会员信息", "成功");
				}
			});
		},
};

$(function () {
	accountEdit.init();
});