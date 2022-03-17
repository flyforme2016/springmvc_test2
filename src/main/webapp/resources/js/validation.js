/*checkNull = function(){
	if($("#shIfcgName").val() == "" || $("#shIfcgName").val() == null){
		alert("null 이다.");
		$("#shIfcgName").focus();
		return false;
	}
}*/

checkNull = function(obj, value, message){
	if(value == "" || value == null){
		alert(message);
		$(obj).focus();
		return false;
	}
}