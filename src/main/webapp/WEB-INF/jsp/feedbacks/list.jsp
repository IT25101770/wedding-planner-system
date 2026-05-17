<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <div>
            <h1 class="h3">Feedback</h1>
            <p class="text-muted mb-0">Create, view, update, and delete client feedback records.</p>
        </div>
        <a class="btn btn-primary" href="/feedbacks/new">New Feedback</a>
    </div>
    <div class="card p-3">
        <div class="table-responsive">
            <table class="table align-middle">
                <thead><tr><th>Name</th><th>Email</th><th>Rating</th><th>Date</th><th></th></tr></thead>
                <tbody>
                <c:forEach items="${feedbacks}" var="feedback">
                    <tr>
                        <td>${feedback.name}</td>
                        <td>${feedback.email}</td>
                        <td>${feedback.rating} Stars</td>
                        <td>${feedback.submittedDate}</td>
                        <td class="table-actions text-end">
                            <a class="btn btn-sm btn-outline-secondary" href="/feedbacks/${feedback.id}">View</a>
                            <a class="btn btn-sm btn-outline-secondary" href="/feedbacks/${feedback.id}/edit">Edit</a>
                            <form method="post" action="/feedbacks/${feedback.id}/delete"><button class="btn btn-sm btn-outline-danger">Delete</button></form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
