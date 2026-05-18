<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="card p-4">
        <h1 class="h4">${event.venue}</h1>
        <p class="text-muted">${event.displayText}</p>
        <dl class="row">
            <dt class="col-sm-3">Event ID</dt><dd class="col-sm-9">${event.id}</dd>
            <dt class="col-sm-3">Customer ID</dt><dd class="col-sm-9">${event.customerId}</dd>
            <dt class="col-sm-3">Theme</dt><dd class="col-sm-9">${event.theme}</dd>
        </dl>
        <a class="btn btn-primary" href="/events/${event.id}/edit">Edit</a>
        <a class="btn btn-outline-secondary" href="/events">Back</a>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
