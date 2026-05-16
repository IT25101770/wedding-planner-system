<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="row g-4">
        <div class="col-lg-8">
            <div class="card p-4">
                <h1 class="h4 mb-3">Profile</h1>
                <form method="post" action="/user/profile" class="row g-3">
                    <div class="col-md-6"><label class="form-label">Name</label><input class="form-control" name="name" value="${customer.name}" required></div>
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
                            <input class="form-control phone-local" type="tel" value="${customer.phone}" required>
                            <input type="hidden" name="phone" value="${customer.phone}">
                        </div>
                    </div>
                    <div class="col-md-6"><label class="form-label">Email</label><input class="form-control" name="email" value="${customer.email}" type="email" required></div>
                    <div class="col-md-6">
                        <label class="form-label">Password</label>
                        <div class="input-group password-field">
                            <input class="form-control" name="password" type="password" value="${customer.password}" required>
                            <button class="btn btn-outline-secondary password-toggle" type="button" aria-label="Show password"><i class="bi bi-eye"></i></button>
                        </div>
                    </div>
                    <div class="col-12"><label class="form-label">Address</label><input class="form-control" name="address" value="${customer.address}" required></div>
                    <div class="col-12"><button class="btn btn-primary">Save Profile</button></div>
                </form>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="card p-4 border-danger">
                <h2 class="h5">Delete Account</h2>
                <form method="post" action="/user/delete">
                    <button class="btn btn-outline-danger">Delete My Account</button>
                </form>
            </div>
        </div>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
