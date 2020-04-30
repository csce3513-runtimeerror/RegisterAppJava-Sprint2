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
       () => { window.location.assign("/productSearch/?transactionId=" + document.getElementById("transactionId").value); });
    document.getElementById("checkout").addEventListener("click", checkout);
    document.getElementById("cancel").addEventListener("click", cancelTransaction);
});


function checkout(event) {
    alert("checkout");
}

function cancelTransaction(event) {
    alert("cancel");
}
