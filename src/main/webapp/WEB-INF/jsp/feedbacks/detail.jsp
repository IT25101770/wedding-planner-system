<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="card p-4">
        <div class="d-flex justify-content-between align-items-start gap-3 mb-3">
            <div>
                <h1 class="h4 mb-1">${feedback.name}</h1>
                <p class="text-muted mb-0">${feedback.displayText}</p>
            </div>
            <span class="badge text-bg-light">${feedback.status}</span>
        </div>
        <dl class="row">
            <dt class="col-sm-3">Feedback ID</dt><dd class="col-sm-9">${feedback.id}</dd>
            <dt class="col-sm-3">Customer ID</dt><dd class="col-sm-9">${feedback.customerId}</dd>
            <dt class="col-sm-3">Email</dt><dd class="col-sm-9">${feedback.email}</dd>
            <dt class="col-sm-3">Rating</dt><dd class="col-sm-9">${feedback.rating} Stars</dd>
            <dt class="col-sm-3">Submitted</dt><dd class="col-sm-9">${feedback.submittedDate}</dd>
            <dt class="col-sm-3">Message</dt><dd class="col-sm-9">${feedback.message}</dd>
        </dl>
        <a class="btn btn-primary" href="/feedbacks/${feedback.id}/edit">Edit</a>
        <a class="btn btn-outline-secondary" href="/feedbacks">Back</a>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
