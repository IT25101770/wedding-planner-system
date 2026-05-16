<%@ include file="../partials/header.jspf" %>
<main class="container page-shell auth-shell">
    <div class="auth-panel">
        <div class="auth-story auth-story-admin">
            <p class="section-label">Admin Studio</p>
            <h1>Wedding Management Portal</h1>
            <p>Manage vendors, events, bookings, payments, and customer feedback with a focused admin workspace.</p>
            <img src="https://images.pexels.com/photos/1444442/pexels-photo-1444442.jpeg?auto=compress&cs=tinysrgb&w=900" alt="Wedding flowers and ceremony decor">
            <div class="auth-highlights">
                <span><i class="bi bi-speedometer2"></i> Dashboard</span>
                <span><i class="bi bi-journal-check"></i> Bookings</span>
                <span><i class="bi bi-chat-heart"></i> Feedback</span>
            </div>
        </div>
        <div class="auth-form-wrap">
            <div class="card p-4 auth-card">
                <h2 class="h4 mb-3">Admin Login</h2>
                <div class="admin-login-logo mb-3">
                    <span>The</span>
                    <strong>Group 107</strong>
                    <small>Admin Studio</small>
                </div>
                <c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>
                <form method="post" action="/admin/login">
                    <div class="mb-3"><label class="form-label">Email</label><input class="form-control" name="email" type="email" required></div>
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <div class="input-group password-field">
                            <input class="form-control" name="password" type="password" required>
                            <button class="btn btn-outline-secondary password-toggle" type="button" aria-label="Show password"><i class="bi bi-eye"></i></button>
                        </div>
                    </div>
                    <button class="btn btn-primary w-100">Enter Admin Panel</button>
                </form>
                <p class="text-muted small mt-3 mb-0">Admin access is limited to the approved admin account.</p>
            </div>
        </div>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
