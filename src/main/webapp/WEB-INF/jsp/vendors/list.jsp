<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="page-heading">
        <div>
            <p class="text-uppercase fw-bold small">Vendor Catalog</p>
            <h1 class="h3 mb-1">Explore Wedding Vendors</h1>
            <p>Search packages, availability, locations and categories.</p>
        </div>
        <c:if test="${sessionScope.role == 'ADMIN'}"><a class="btn btn-primary" href="/vendors/new">Add Vendor</a></c:if>
    </div>
    <form class="card p-3 mb-4" method="get" action="/vendors">
        <div class="row g-2">
            <div class="col-md-4">
                <select class="form-select" name="category">
                    <option value="">All Categories</option>
                    <option ${category == 'Photographer' ? 'selected' : ''}>Photographer</option>
                    <option ${category == 'Catering' ? 'selected' : ''}>Catering</option>
                    <option ${category == 'Decoration' ? 'selected' : ''}>Decoration</option>
                    <option ${category == 'MusicBand' ? 'selected' : ''}>MusicBand</option>
                </select>
            </div>
            <div class="col-md-6"><input class="form-control" name="keyword" value="${keyword}" placeholder="Search name or location"></div>
            <div class="col-md-2"><button class="btn btn-primary w-100">Search</button></div>
        </div>
    </form>
    <div class="row g-3">
        <c:forEach items="${vendors}" var="vendor">
            <div class="col-md-6 col-xl-4">
                <div class="card vendor-poster h-100 p-4">
                    <div class="d-flex justify-content-between"><h2 class="h5">${vendor.name}</h2><span class="badge text-bg-light">${vendor.category}</span></div>
                    <p class="text-muted">${vendor.packageDescription}</p>
                    <p class="mb-1">Rs. ${vendor.packagePrice}</p>
                    <p class="mb-3">${vendor.location} | ${vendor.available ? 'Available' : 'Unavailable'}</p>
                    <div class="table-actions">
                        <a class="btn btn-sm btn-outline-secondary" href="/vendors/${vendor.id}">View</a>
                        <c:if test="${sessionScope.role == 'CUSTOMER'}">
                            <a class="btn btn-sm btn-primary" href="/bookings/new?vendorId=${vendor.id}">Book Package</a>
                        </c:if>
                        <c:if test="${sessionScope.role == 'ADMIN'}">
                            <a class="btn btn-sm btn-outline-secondary" href="/vendors/${vendor.id}/edit">Edit</a>
                            <form method="post" action="/vendors/${vendor.id}/delete"><button class="btn btn-sm btn-outline-danger">Delete</button></form>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
