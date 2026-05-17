<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="card p-4">
        <h1 class="h4 mb-3">Payment</h1>
        <form method="post" action="/payments" class="row g-3">
            <input type="hidden" name="id" value="${payment.id}">
            <div class="col-md-6">
                <label class="form-label">Booking</label>
                <select class="form-select" id="bookingId" name="bookingId" required>
                    <option value="">Choose a booking</option>
                    <c:forEach items="${bookings}" var="booking">
                        <c:set var="packageAmount" value="0" />
                        <c:set var="vendorLabel" value="${booking.vendorId}" />
                        <c:forEach items="${vendors}" var="vendor">
                            <c:if test="${vendor.id == booking.vendorId}">
                                <c:set var="packageAmount" value="${vendor.packagePrice}" />
                                <c:set var="vendorLabel" value="${vendor.name} - ${vendor.category}" />
                            </c:if>
                        </c:forEach>
                        <option value="${booking.id}" data-amount="${bookingTotals[booking.id]}" ${payment.bookingId == booking.id || selectedBookingId == booking.id ? 'selected' : ''}>${booking.id} - ${vendorLabel} - Rs. ${bookingTotals[booking.id]}</option>
                    </c:forEach>
                </select>
                <c:if test="${empty bookings}">
                    <div class="form-text mt-2">No bookings yet. Choose a vendor package first.</div>
                </c:if>
            </div>
            <div class="col-md-6"><label class="form-label">Package Amount</label><input class="form-control" id="amount" name="amount" type="number" step="0.01" value="${payment.amount}" readonly required></div>
            <div class="col-md-4">
                <label class="form-label">Discount Package</label>
                <select class="form-select" id="discountPackage" name="discountPercent">
                    <option value="0">No package</option>
                    <option value="15">Half Package - 15%</option>
                    <option value="20">Full Package - 20%</option>
                    <option value="10">Day Package - 10%</option>
                </select>
            </div>
            <div class="col-md-4"><label class="form-label">Discount %</label><input class="form-control" id="discountPercentDisplay" type="number" step="0.01" value="${payment.discountPercent}" readonly></div>
            <div class="col-md-4"><label class="form-label">Invoice Total</label><input class="form-control" id="invoiceTotal" type="text" readonly></div>
            <div class="col-md-6"><label class="form-label">Status</label><input class="form-control" value="Pending until payment is saved" readonly></div>
            <div class="col-md-6"><label class="form-label">Paid Date</label><input class="form-control" type="date" value="${payment.paidDate}" readonly></div>
            <div class="col-12"><button class="btn btn-primary">Save Payment</button><a class="btn btn-outline-secondary" href="/bookings">Cancel</a></div>
        </form>
    </div>
</main>
<script>
    const params = new URLSearchParams(window.location.search);
    const packageMap = { half: "15", full: "20", day: "10" };
    const packageSelect = document.getElementById("discountPackage");
    const discountInput = document.getElementById("discountPercentDisplay");
    const amountInput = document.getElementById("amount");
    const totalInput = document.getElementById("invoiceTotal");
    const bookingSelect = document.getElementById("bookingId");

    function updateTotal() {
        const amount = parseFloat(amountInput.value || "0");
        const discount = parseFloat(packageSelect.value || "0");
        const total = amount - (amount * discount / 100);
        discountInput.value = discount;
        totalInput.value = "Rs. " + total.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 });
    }

    function updateAmountFromBooking() {
        const selected = bookingSelect.options[bookingSelect.selectedIndex];
        if (selected && selected.dataset.amount) {
            amountInput.value = selected.dataset.amount;
        }
        updateTotal();
    }

    packageSelect.addEventListener("change", function () {
        discountInput.value = this.value;
        updateTotal();
    });
    bookingSelect.addEventListener("change", updateAmountFromBooking);

    const selectedPackage = packageMap[params.get("package")];
    if (selectedPackage) {
        packageSelect.value = selectedPackage;
        discountInput.value = selectedPackage;
    } else {
        const savedDiscount = parseFloat("${payment.discountPercent}" || "0");
        if (savedDiscount > 0) {
            packageSelect.value = String(savedDiscount);
        }
    }
    if (!amountInput.value || amountInput.value === "0.0" || amountInput.value === "0") {
        updateAmountFromBooking();
    }
    updateTotal();
</script>
<%@ include file="../partials/footer.jspf" %>
