var editmodal = document.getElementById("modal2");
var editbtn = document.getElementById("edit");
var editclose = document.getElementsByClassName("close")[1];
var cancel_b_edit = document.getElementsByClassName("inform_txt_button")[1];

editbtn.onclick = function() {
	editmodal.style.display = "block";
}
editclose.onclick = function() {
	editmodal.style.display = "none";
}
cancel_b_edit.onclick = function() {
	editmodal.style.display = "none";
}
window.onclick = function(event) {
	if (event.target == editmodal) {
		editmodal.style.display = "none";
	}
}