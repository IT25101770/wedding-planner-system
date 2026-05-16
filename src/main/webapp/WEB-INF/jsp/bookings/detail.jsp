<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="card p-4">
        <h1 class="h4">Booking ${booking.id}</h1>
        <dl class="row">
            <dt class="col-sm-3">Customer</dt><dd class="col-sm-9">${booking.customerId}</dd>
            <dt class="col-sm-3">Event</dt><dd class="col-sm-9">${booking.eventId}</dd>
            <dt class="col-sm-3">Vendor</dt><dd class="col-sm-9">${booking.vendorId}</dd>
            <dt class="col-sm-3">Booking Date</dt><dd class="col-sm-9">${booking.bookingDate}</dd>
            <dt class="col-sm-3">Status</dt><dd class="col-sm-9">${booking.status}</dd>
        </dl>
        <a class="btn btn-outline-secondary" href="/bookings">Back</a>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
