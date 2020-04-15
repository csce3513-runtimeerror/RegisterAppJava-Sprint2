var removeButtons = document.getElementsByClassName("remove");
for (var i = 0; i < removeButtons.length; i++) {
    var button = removeButtons[i];
    button.addEventListener("click", function() {
        document.getElementById("table").deleteRow(i);
        i = removeButtons.length;
    });
}
document.addEventListener("DOMContentLoaded", function(event) {
	document.getElementById("addItem").addEventListener(
		"click",
       () => { window.location.assign("/productSearch"); });
    document.getElementById("checkout").addEventListener("click", checkout);
});


function checkout(event) {
    alert("checkout");
}
