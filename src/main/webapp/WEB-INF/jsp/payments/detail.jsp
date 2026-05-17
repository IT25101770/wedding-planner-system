<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="card p-4">
        <p class="text-uppercase text-muted small">Invoice</p>
        <h1 class="h4">${payment.id}</h1>
        <hr>
        <dl class="row">
            <dt class="col-sm-3">Booking</dt><dd class="col-sm-9">${payment.bookingId}</dd>
            <dt class="col-sm-3">Base Amount</dt><dd class="col-sm-9">Rs. ${payment.amount}</dd>
            <dt class="col-sm-3">Discount</dt><dd class="col-sm-9">${payment.discountPercent}%</dd>
            <dt class="col-sm-3">Total Payable</dt><dd class="col-sm-9 fw-bold">Rs. ${payment.total}</dd>
            <dt class="col-sm-3">Status</dt><dd class="col-sm-9">${payment.status}</dd>
            <dt class="col-sm-3">Date</dt><dd class="col-sm-9">${payment.paidDate}</dd>
        </dl>
        <button class="btn btn-primary" onclick="window.print()">Print Invoice</button>
        <a class="btn btn-outline-secondary" href="/bookings">Back</a>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
