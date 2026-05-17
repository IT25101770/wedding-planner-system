<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="card p-4">
        <h1 class="h4">${vendor.name}</h1>
        <p class="text-muted">${vendor.packageDescription}</p>
        <dl class="row">
            <dt class="col-sm-3">Category</dt><dd class="col-sm-9">${vendor.category}</dd>
            <dt class="col-sm-3">Phone</dt><dd class="col-sm-9">${vendor.phone}</dd>
            <dt class="col-sm-3">Location</dt><dd class="col-sm-9">${vendor.location}</dd>
            <dt class="col-sm-3">Price</dt><dd class="col-sm-9">Rs. ${vendor.packagePrice}</dd>
            <dt class="col-sm-3">Availability</dt><dd class="col-sm-9">${vendor.available ? 'Available' : 'Unavailable'}</dd>
        </dl>
        <a class="btn btn-outline-secondary" href="/vendors">Back</a>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
