function myfn(){
	var name = document.getElementById("username").value;
	var action = document.getElementById("myform").action;
	var res = action+"/"+name;
	document.getElementById("myform").action = res;
	//alert(res);
}