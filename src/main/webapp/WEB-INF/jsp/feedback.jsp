<%@ include file="partials/header.jspf" %>
<section class="page-hero feedback-hero">
    <div class="page-hero-copy animate-rise">
        <p class="hero-kicker">Feedback</p>
        <h1 class="hero-title">Happy clients, beautiful memories.</h1>
        <p class="hero-desc">Read what couples love about the planning experience, then send your own message to the team.</p>
    </div>
</section>

<section class="feedback-page">
    <div class="section-header">
        <p class="section-label">Recent Feedback</p>
        <h2 class="section-title">What couples shared.</h2>
    </div>
    <div class="testimonials-grid mb-4">
        <c:forEach items="${feedbacks}" var="feedback">
            <article class="testimonial-card">
                <div class="testimonial-quote">"</div>
                <p class="testimonial-text">${feedback.message}</p>
                <div class="testimonial-author">
                    <div class="testimonial-avatar">${feedback.rating}</div>
                    <div>
                        <div class="testimonial-name">${feedback.name}</div>
                        <div class="testimonial-date">${feedback.submittedDate}</div>
                    </div>
                </div>
            </article>
        </c:forEach>
        <c:if test="${empty feedbacks}">
            <p class="text-muted text-center">No feedback yet.</p>
        </c:if>
    </div>
    <div class="feedback-form-wrap">
        <form class="feedback-form" action="/feedbacks" method="post">
            <p class="section-label">Share Your Experience</p>
            <h2 class="section-title text-start">Tell us what you loved.</h2>
            <div class="row g-3">
                <div class="col-md-6"><input class="form-control" name="name" placeholder="Your name"></div>
                <div class="col-md-6"><input class="form-control" name="email" placeholder="Email address"></div>
                <div class="col-12"><select class="form-select" name="rating"><option value="5">5 Stars - Excellent</option><option value="4">4 Stars - Very good</option><option value="3">3 Stars - Good</option></select></div>
                <div class="col-12"><textarea class="form-control" name="message" rows="5" placeholder="Write your feedback"></textarea></div>
                <div class="col-12"><button class="btn btn-primary btn-lg" type="submit">Send Feedback</button></div>
            </div>
        </form>
    </div>
</section>
<%@ include file="partials/footer.jspf" %>
