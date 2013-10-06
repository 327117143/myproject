function check(){
		var uid=document.getElementById("txtUid");
  		var pwd=document.getElementById("txtPwd");
  		if(uid.value==""){
			alert("账号不能为空");
			//uid.select();
			uid.focus();
			return false;
	  	}
	  	if(pwd.value==""){
			alert("密码不能为空");
			pwd.focus();
			return false;
		}
		return true;
}
