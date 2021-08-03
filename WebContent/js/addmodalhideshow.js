var addmodal = document.getElementById("modal1");
var addbtn = document.getElementById("add");
var addclose = document.getElementsByClassName("close")[0];
var cancel_b_add = document.getElementsByClassName("inform_txt_button")[0];

addbtn.onclick = function() {
	addmodal.style.display = "block";
}
addclose.onclick = function() {
	addmodal.style.display = "none";
}
cancel_b_add.onclick = function() {
	addmodal.style.display = "none";
}
window.onclick = function(event) {
	if (event.target == addmodal) {
		addmodal.style.display = "none";
	}
}