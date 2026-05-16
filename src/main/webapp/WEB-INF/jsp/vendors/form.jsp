<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="card p-4">
        <h1 class="h4 mb-3">Vendor</h1>
        <form method="post" action="/vendors" class="row g-3">
            <input type="hidden" name="id" value="${vendor.id}">
            <div class="col-md-6"><label class="form-label">Name</label><input class="form-control" name="name" value="${vendor.name}" required></div>
            <div class="col-md-6"><label class="form-label">Category</label><select class="form-select" name="category"><option ${vendor.category == 'Photographer' ? 'selected' : ''}>Photographer</option><option ${vendor.category == 'Catering' ? 'selected' : ''}>Catering</option><option ${vendor.category == 'Decoration' ? 'selected' : ''}>Decoration</option><option ${vendor.category == 'MusicBand' ? 'selected' : ''}>MusicBand</option></select></div>
            <div class="col-md-4"><label class="form-label">Phone</label><input class="form-control" name="phone" value="${vendor.phone}" required></div>
            <div class="col-md-4"><label class="form-label">Location</label><input class="form-control" name="location" value="${vendor.location}" required></div>
            <div class="col-md-4"><label class="form-label">Package Price</label><input class="form-control" name="packagePrice" type="number" step="0.01" value="${vendor.packagePrice}" required></div>
            <div class="col-12 form-check ms-2"><input class="form-check-input" type="checkbox" name="available" value="true" ${vendor.available ? 'checked' : ''}><label class="form-check-label">Available</label></div>
            <div class="col-12"><button class="btn btn-primary">Save Vendor</button><a class="btn btn-outline-secondary" href="/vendors">Cancel</a></div>
        </form>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
