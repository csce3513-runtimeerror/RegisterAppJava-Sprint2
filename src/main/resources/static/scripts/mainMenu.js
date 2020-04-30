document.addEventListener("DOMContentLoaded", function(event) {
	getStartTransactionActionElement().addEventListener(
		"click",
		onStartTransactionClicked);

	getViewProductsActionElement().addEventListener(
		"click",
		() => { window.location.assign("/productListing"); });

	getCreateEmployeeActionElement().addEventListener(
		"click",
		() => { window.location.assign("/employeeDetail"); });

	getProductSalesReportActionElement().addEventListener(
		"click",
		() => { displayError("Functionality has not yet been implemented."); });

	getCashierSalesReportActionElement().addEventListener(
		"click",
		() => { displayError("Functionality has not yet been implemented."); });
});

function onStartTransactionClicked() {
	ajaxPost("/api/productSearch/", {}, (callbackResponse) => {
		if (isErrorResponse(callbackResponse)) {
			return;
		}

		window.location.assign(callbackResponse.data.redirectUrl);
	});
}

// Getters and setters
function getViewProductsActionElement() {
	return document.getElementById("viewProductsButton");
}

function getCreateEmployeeActionElement() {
	return document.getElementById("createEmployeeButton");
}

function getStartTransactionActionElement() {
	return document.getElementById("startTransactionButton");
}

function getProductSalesReportActionElement() {
	return document.getElementById("productSalesReportButton");
}

function getCashierSalesReportActionElement() {
	return document.getElementById("cashierSalesReportButton");
}
// End getters and setters