<%@ include file="../partials/header.jspf" %>
<main class="container page-shell auth-shell">
    <div class="auth-panel">
        <div class="auth-story auth-story-member">
            <p class="section-label">Member Studio</p>
            <h1>Plan Every Wedding Detail</h1>
            <p>Access your events, vendor bookings, invoices, package discounts, and feedback in one organized place.</p>
            <img src="https://images.pexels.com/photos/169196/pexels-photo-169196.jpeg?auto=compress&cs=tinysrgb&w=900" alt="Elegant wedding reception table">
            <div class="auth-highlights">
                <span><i class="bi bi-calendar2-heart"></i> Events</span>
                <span><i class="bi bi-shop-window"></i> Vendors</span>
                <span><i class="bi bi-receipt"></i> Payments</span>
            </div>
        </div>
        <div class="auth-form-wrap">
            <div class="card p-4 auth-card">
                <h2 class="h4 mb-2">Member Login</h2>
                <p class="text-muted mb-4">Continue planning your wedding with your saved details.</p>
                <c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>
                <form method="post" action="/user/login">
                    <div class="mb-3"><label class="form-label">Email</label><input class="form-control" name="email" type="email" required></div>
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <div class="input-group password-field">
                            <input class="form-control" name="password" type="password" required>
                            <button class="btn btn-outline-secondary password-toggle" type="button" aria-label="Show password"><i class="bi bi-eye"></i></button>
                        </div>
                    </div>
                    <button class="btn btn-primary w-100">Login</button>
                </form>
                <a class="d-block mt-3" href="/register">New customer? Register</a>
            </div>
        </div>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
