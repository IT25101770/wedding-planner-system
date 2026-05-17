<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../partials/header.jspf" %>
<main class="container page-shell admin-dashboard">
    <div class="page-heading">
        <div>
            <p class="text-uppercase fw-bold small">Admin Control Center</p>
            <h1 class="h3 mb-1">Operations Dashboard</h1>
            <p>Monitor platform activity, revenue, customers, vendors, bookings and payments.</p>
        </div>
        <a class="btn btn-primary" href="/vendors/new"><i class="bi bi-plus-circle"></i> Add Vendor</a>
    </div>
    <div class="row g-3 mb-4">
        <div class="col-md-3"><div class="card metric admin-metric p-4"><span class="metric-icon"><i class="bi bi-journal-check"></i></span><div class="metric-label">Bookings</div><div class="metric-value">${bookings.size()}</div></div></div>
        <div class="col-md-3"><div class="card metric admin-metric p-4"><span class="metric-icon"><i class="bi bi-cash-stack"></i></span><div class="metric-label">Revenue</div><div class="metric-value metric-money"><span>Rs.</span><fmt:formatNumber value="${totalRevenue}" type="number" maxFractionDigits="0"/></div></div></div>
        <div class="col-md-3"><div class="card metric admin-metric p-4"><span class="metric-icon"><i class="bi bi-award"></i></span><div class="metric-label">Top Vendor</div><div class="metric-value metric-small">${mostBookedVendorId}</div></div></div>
        <div class="col-md-3"><div class="card metric admin-metric p-4"><span class="metric-icon"><i class="bi bi-people"></i></span><div class="metric-label">Customers</div><div class="metric-value">${users.size()}</div></div></div>
    </div>
    <div class="card action-panel p-4">
        <div class="row align-items-center g-4">
            <div class="col-lg-4">
                <h2 class="h4 mb-2">Management shortcuts</h2>
                <p class="mb-0">Jump directly into the records that matter during daily operations.</p>
            </div>
            <div class="col-lg-8">
                <div class="row g-2">
                    <div class="col-md-4"><a class="quick-action" href="/vendors"><i class="bi bi-shop-window"></i> Vendors</a></div>
                    <div class="col-md-4"><a class="quick-action" href="/events"><i class="bi bi-calendar2-heart"></i> Events</a></div>
                    <div class="col-md-4"><a class="quick-action" href="/bookings"><i class="bi bi-journal-check"></i> Bookings</a></div>
                    <div class="col-md-4"><a class="quick-action" href="/payments"><i class="bi bi-receipt"></i> Payments</a></div>
                    <div class="col-md-4"><a class="quick-action" href="/feedbacks"><i class="bi bi-chat-heart"></i> Feedbacks</a></div>
                    <div class="col-md-4"><a class="quick-action" href="/vendors/new"><i class="bi bi-plus-circle"></i> Add Vendor</a></div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
