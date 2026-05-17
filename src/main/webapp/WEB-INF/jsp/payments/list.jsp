<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1 class="h3">Payments & Budget</h1>
    </div>
    <div class="card p-3">
        <div class="table-responsive">
            <table class="table align-middle">
                <thead><tr><th>Invoice</th><th>Booking</th><th>Amount</th><th>Discount</th><th>Total</th><th>Status</th><th></th></tr></thead>
                <tbody>
                <c:forEach items="${payments}" var="payment">
                    <tr>
                        <td>${payment.id}</td><td>${payment.bookingId}</td><td>Rs. ${payment.amount}</td><td>${payment.discountPercent}%</td><td>Rs. ${payment.total}</td><td>${payment.status}</td>
                        <td class="table-actions text-end">
                            <a class="btn btn-sm btn-outline-secondary" href="/payments/${payment.id}">Invoice</a>
                            <c:if test="${sessionScope.role == 'CUSTOMER'}"><a class="btn btn-sm btn-outline-secondary" href="/payments/${payment.id}/edit">Edit</a></c:if>
                            <form method="post" action="/payments/${payment.id}/delete"><button class="btn btn-sm btn-outline-danger">Delete</button></form>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty payments}">
                    <tr><td colspan="7" class="text-muted">No payment records yet. Choose a vendor package, create a booking, then save the payment.</td></tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
