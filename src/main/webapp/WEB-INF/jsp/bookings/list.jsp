<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1 class="h3">Bookings & Payments</h1>
        <c:if test="${sessionScope.role == 'CUSTOMER'}"><a class="btn btn-primary" href="/vendors">Book Vendor</a></c:if>
    </div>
    <div class="card p-3">
        <div class="table-responsive">
            <table class="table align-middle">
                <thead><tr><th>Booking ID</th><th>Event</th><th>Vendor</th><th>Date</th><th>Status</th><th></th></tr></thead>
                <tbody>
                <c:forEach items="${bookings}" var="booking">
                    <tr>
                        <td>${booking.id}</td><td>${booking.eventId}</td><td>${booking.vendorId}</td><td>${booking.bookingDate}</td><td><span class="badge text-bg-light">${booking.status}</span></td>
                        <td class="table-actions text-end">
                            <a class="btn btn-sm btn-outline-secondary" href="/bookings/${booking.id}">View</a>
                            <c:if test="${sessionScope.role == 'CUSTOMER'}"><a class="btn btn-sm btn-primary" href="/payments/new?bookingId=${booking.id}">Pay</a></c:if>
                            <c:if test="${sessionScope.role == 'ADMIN' && booking.status != 'Confirmed'}">
                                <form method="post" action="/bookings/${booking.id}/status"><input type="hidden" name="status" value="Confirmed"><button class="btn btn-sm btn-outline-success">Confirm</button></form>
                            </c:if>
                            <form method="post" action="/bookings/${booking.id}/delete"><button class="btn btn-sm btn-outline-danger">Cancel</button></form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card p-3 mt-4">
        <h2 class="h5 mb-3">Payment Records</h2>
        <div class="table-responsive">
            <table class="table align-middle">
                <thead><tr><th>Invoice</th><th>Booking</th><th>Amount</th><th>Discount</th><th>Total</th><th>Status</th><th>Paid Date</th><th></th></tr></thead>
                <tbody>
                <c:forEach items="${payments}" var="payment">
                    <tr>
                        <td>${payment.id}</td>
                        <td>${payment.bookingId}</td>
                        <td>Rs. ${payment.amount}</td>
                        <td>${payment.discountPercent}%</td>
                        <td>Rs. ${payment.total}</td>
                        <td><span class="badge text-bg-light">${payment.status}</span></td>
                        <td>${payment.paidDate}</td>
                        <td class="table-actions text-end">
                            <a class="btn btn-sm btn-outline-secondary" href="/payments/${payment.id}">Invoice</a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty payments}">
                    <tr><td colspan="8" class="text-muted">No payments recorded yet.</td></tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
