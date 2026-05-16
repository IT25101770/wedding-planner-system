<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="row justify-content-center">
        <div class="col-md-7">
            <div class="card p-4">
                <h2 class="h4 mb-3">Customer Registration</h2>
                <form method="post" action="/register" class="row g-3">
                    <div class="col-md-6"><label class="form-label">Name</label><input class="form-control" name="name" required></div>
                    <div class="col-md-6">
                        <label class="form-label">Phone</label>
                        <div class="input-group phone-field">
                            <select class="form-select phone-code" aria-label="Country code">
                                <option value="+94" selected>+94</option>
                                <option value="+91">+91</option>
                                <option value="+1">+1</option>
                                <option value="+44">+44</option>
                                <option value="+61">+61</option>
                                <option value="+971">+971</option>
                            </select>
                            <input class="form-control phone-local" type="tel" placeholder="71 234 5678" required>
                            <input type="hidden" name="phone">
                        </div>
                    </div>
                    <div class="col-md-6"><label class="form-label">Email</label><input class="form-control" name="email" type="email" required></div>
                    <div class="col-md-6">
                        <label class="form-label">Password</label>
                        <div class="input-group password-field">
                            <input class="form-control" name="password" type="password" required>
                            <button class="btn btn-outline-secondary password-toggle" type="button" aria-label="Show password"><i class="bi bi-eye"></i></button>
                        </div>
                    </div>
                    <div class="col-12"><label class="form-label">Address</label><input class="form-control" name="address" required></div>
                    <div class="col-12"><button class="btn btn-primary">Register</button></div>
                </form>
            </div>
        </div>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
