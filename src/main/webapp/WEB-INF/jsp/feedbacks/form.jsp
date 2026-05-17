<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="card p-4">
        <h1 class="h4 mb-3">Feedback Record</h1>
        <form method="post" action="/feedbacks" class="row g-3">
            <input type="hidden" name="id" value="${feedback.id}">
            <input type="hidden" name="customerId" value="${feedback.customerId}">
            <input type="hidden" name="submittedDate" value="${feedback.submittedDate}">
            <input type="hidden" name="status" value="${empty feedback.status ? 'New' : feedback.status}">
            <div class="col-md-6"><label class="form-label">Name</label><input class="form-control" name="name" value="${feedback.name}" required></div>
            <div class="col-md-6"><label class="form-label">Email</label><input class="form-control" name="email" type="email" value="${feedback.email}" required></div>
            <div class="col-md-6">
                <label class="form-label">Rating</label>
                <select class="form-select" name="rating">
                    <option value="5" ${feedback.rating == 5 ? 'selected' : ''}>5 Stars - Excellent</option>
                    <option value="4" ${feedback.rating == 4 ? 'selected' : ''}>4 Stars - Very good</option>
                    <option value="3" ${feedback.rating == 3 ? 'selected' : ''}>3 Stars - Good</option>
                    <option value="2" ${feedback.rating == 2 ? 'selected' : ''}>2 Stars - Fair</option>
                    <option value="1" ${feedback.rating == 1 ? 'selected' : ''}>1 Star - Needs work</option>
                </select>
            </div>
            <div class="col-12"><label class="form-label">Message</label><textarea class="form-control" name="message" rows="5" required>${feedback.message}</textarea></div>
            <div class="col-12"><button class="btn btn-primary">Save Feedback</button><a class="btn btn-outline-secondary" href="/feedbacks">Cancel</a></div>
        </form>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
