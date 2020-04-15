var removeButtons = document.getElementsByClassName("remove");
for (var i = 0; i < removeButtons.length; i++) {
    var button = removeButtons[i];
    button.addEventListener("click", function() {
        document.getElementById("table").deleteRow(i);
        removeFromTotal(i);
        i = removeButtons.length;
    });
}
document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("checkout").addEventListener("click", checkout);
});

function checkout(event) {
    alert("checkout");
}
function removeFromTotal(row) {

}