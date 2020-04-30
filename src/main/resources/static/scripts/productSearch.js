document.addEventListener("DOMContentLoaded", () => {
	const productListElements = document.getElementById("productsListing").children;

	for (let i = 0; i < productListElements.length; i++) {
		productListElements[i].addEventListener("click", productClick);
	}

	document.getElementById("productSearch").addEventListener("keypress", onProductSearchKeyPress);
});

function findClickedListItemElement(clickedTarget) {
	if (clickedTarget.tagName.toLowerCase() === "li") {
		return clickedTarget;
	} else {
		let ancestorIsListItem = false;
		let ancestorElement = clickedTarget.parentElement;

		while (!ancestorIsListItem && (ancestorElement != null)) {
			ancestorIsListItem = (ancestorElement.tagName.toLowerCase() === "li");

			if (!ancestorIsListItem) {
				ancestorElement = ancestorElement.parentElement;
			}
		}

		return (ancestorIsListItem ? ancestorElement : null);
	}
}

function onProductSearchKeyPress(event) {
	if (event.which !== 13) { // ENTER/RETURN
		return;
	}

	const productListElements = document.getElementById("productsListing").children;

	for (let i = 0; i < productListElements.length; i++) {
		const lookupCode = productListElements[i]
			.querySelector("span.productLookupCodeDisplay")
			.innerHTML;

		if (lookupCode.toLowerCase().indexOf(event.target.value.toLowerCase()) >= 0) {
			if (productListElements[i].classList.contains("hidden")) {
				productListElements[i].classList.remove("hidden");
			}
		} else {
			if (!productListElements[i].classList.contains("hidden")) {
				productListElements[i].classList.add("hidden");
			}
		}
	}
}

function productClick(event) {
	const listItem = findClickedListItemElement(event.target);

	
	ajaxPost(
		"/api/transaction/entry/",
		{
			transactionId: document.getElementById("transactionId").value,
			productId: listItem.querySelector("input[name='productId'][type='hidden']").value
		},
		(callbackResponse) => {
			if (isErrorResponse(callbackResponse)) {
				return;
			}

			window.location.replace(callbackResponse.data.redirectUrl);
		});
}
