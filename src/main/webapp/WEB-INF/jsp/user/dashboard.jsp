<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="page-heading">
        <div>
            <p class="text-uppercase fw-bold small">Customer Portal</p>
            <h1 class="h3 mb-1">Welcome, ${sessionScope.userName}</h1>
            <p>Plan your event, reserve vendors, and keep every payment organized.</p>
        </div>
        <a class="btn btn-primary" href="/events/new"><i class="bi bi-calendar-plus"></i> New Event</a>
    </div>
    <div class="row g-3 mb-4">
        <div class="col-md-3"><div class="card metric p-3 d-flex justify-content-between"><span class="metric-icon"><i class="bi bi-calendar2-heart"></i></span><div><div class="metric-label">Events</div><div class="metric-value">${events.size()}</div></div></div></div>
        <div class="col-md-3"><div class="card metric p-3 d-flex justify-content-between"><span class="metric-icon"><i class="bi bi-shop-window"></i></span><div><div class="metric-label">Vendors</div><div class="metric-value">${vendors.size()}</div></div></div></div>
        <div class="col-md-3"><div class="card metric p-3 d-flex justify-content-between"><span class="metric-icon"><i class="bi bi-journal-check"></i></span><div><div class="metric-label">Bookings</div><div class="metric-value">${bookings.size()}</div></div></div></div>
        <div class="col-md-3"><div class="card metric p-3 d-flex justify-content-between"><span class="metric-icon"><i class="bi bi-receipt"></i></span><div><div class="metric-label">Payments</div><div class="metric-value">${payments.size()}</div></div></div></div>
    </div>
    <div class="card action-panel p-4">
        <div class="row align-items-center g-4">
            <div class="col-lg-5">
                <h2 class="h4 mb-2">Next planning actions</h2>
                <p class="mb-0">Move from event setup to vendor booking and invoice tracking in a few clicks.</p>
            </div>
            <div class="col-lg-7">
                <div class="row g-2">
                    <div class="col-md-6"><a class="quick-action" href="/events/new"><i class="bi bi-calendar-plus"></i> Create Event</a></div>
                    <div class="col-md-6"><a class="quick-action" href="/bookings/new"><i class="bi bi-bag-heart"></i> Book Vendor</a></div>
                    <div class="col-md-6"><a class="quick-action" href="/feedbacks/new"><i class="bi bi-chat-heart"></i> Share Feedback</a></div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>