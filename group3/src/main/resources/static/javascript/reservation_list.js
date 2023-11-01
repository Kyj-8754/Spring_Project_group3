function cancelReservation(index) {
	var row = document.getElementById('reservation-' + index);
	if (row) {
		row.remove();
	}
}

function cancel(id) {
	let form = document.createElement("form");
	form.setAttribute("method", "post");
	form.setAttribute("action", "/reservation_list/" + id + "/cancel");
	document.body.appendChild(form);
	form.submit();
}	
