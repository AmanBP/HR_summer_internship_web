var delmodal = document.getElementById("delmodal");
var delbtn = document.getElementById("delete");
var delclose = document.getElementsByClassName("close")[2];
var cancel_b_edit= document.getElementById("cancel");

delbtn.onclick = function() {
	delmodal.style.display = "block";
}
delclose.onclick = function() {
	delmodal.style.display = "none";
}
cancel_b_edit.onclick = function() {
	delmodal.style.display = "none";
}
window.onclick = function(event) {
	if (event.target == delmodal) {
		delmodal.style.display = "none";
	}
}