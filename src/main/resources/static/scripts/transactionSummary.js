var removeButtons = document.getElementsByClassName("remove");
for (var i = 0; i < removeButtons.length; i++) {
    var button = removeButtons[i];
    button.addEventListener("click", function() {
        document.getElementById("table2").deleteRow(i);
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

//delete transaction
function cancelTransaction(event) {
    //alert("cancel");
    const deleteActionElement = event.target;
    const deleteActionUrl = ("/api/transaction/" + getTransaction_Num());

    deleteActionElement.disabled = true;

    ajaxDelete(deleteActionUrl, (callbackResponse) => {
        deleteActionElement.disabled = false;

        if(isSuccessResponse(callbackResponse)) {
            window.location.replace("/");
        }
    });
};
//end delete

//Getters and setters
function getDeleteActionElement(){
    return document.getElementById("cancel");
}
function getTransactionId(){
    return getTransactionIdElement().value;
}
function setTransactionId(transactionId){
    getTransactionIdElement().value = transactionId;
}
function getTransactionIdElement() {
    return document.getElementById("transactionId");
}
