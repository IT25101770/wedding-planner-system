<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="card p-4">
        <h1 class="h4 mb-3">Book a Vendor</h1>
        <form method="post" action="/bookings" class="row g-3">
            <div class="col-md-6">
                <label class="form-label">Wedding Event</label>
                <select class="form-select" name="eventId" required>
                    <option value="">Choose your wedding event</option>
                    <c:forEach items="${events}" var="event"><option value="${event.id}">${event.date} - ${event.venue} (${event.theme})</option></c:forEach>
                </select>
                <c:if test="${empty events}">
                    <div class="form-text mt-2">No wedding events yet. <a href="/events/new">Create an event first</a>, then return to book a vendor.</div>
                </c:if>
            </div>
            <div class="col-12">
                <label class="form-label">Vendor Packages</label>
                <div class="package-check-grid">
                    <c:forEach items="${vendors}" var="vendor">
                        <label class="package-check">
                            <input type="checkbox" name="vendorIds" value="${vendor.id}" ${selectedVendorId == vendor.id ? 'checked' : ''}>
                            <span class="package-check-box"><i class="bi bi-check-lg"></i></span>
                            <span class="package-check-copy">
                                <strong>${vendor.name}</strong>
                                <small>${vendor.category} | ${vendor.location}</small>
                                <em>Rs. ${vendor.packagePrice}</em>
                            </span>
                        </label>
                    </c:forEach>
                </div>
                <div class="form-text">Tick one or more vendor packages for this booking.</div>
            </div>
            <div class="col-md-6"><label class="form-label">Status</label><select class="form-select" name="status"><option>Pending</option><option>Confirmed</option></select></div>
            <div class="col-12"><button class="btn btn-primary">Save Booking</button><a class="btn btn-outline-secondary" href="/bookings">Cancel</a></div>
        </form>
    </div>
</main>
<script>
    (function () {
        var form = document.querySelector("form[action='/bookings']");
        var checks = Array.from(document.querySelectorAll("input[name='vendorIds']"));
        if (!form || checks.length === 0) {
            return;
        }
        function validatePackages() {
            var selected = checks.some(function (check) { return check.checked; });
            checks[0].setCustomValidity(selected ? "" : "Select at least one vendor package.");
        }
        checks.forEach(function (check) {
            check.addEventListener("change", validatePackages);
        });
        form.addEventListener("submit", validatePackages);
        validatePackages();
    })();
</script>
<%@ include file="../partials/footer.jspf" %>
