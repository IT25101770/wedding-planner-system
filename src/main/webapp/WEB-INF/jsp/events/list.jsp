<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1 class="h3">Wedding Events</h1>
        <a class="btn btn-primary" href="/events/new">New Event</a>
    </div>
    <div class="card p-3">
        <div class="table-responsive">
            <table class="table align-middle">
                <thead><tr><th>Date</th><th>Venue</th><th>Guests</th><th>Theme</th><th>Customer</th><th></th></tr></thead>
                <tbody>
                <c:forEach items="${events}" var="event">
                    <tr>
                        <td>${event.date}</td><td>${event.venue}</td><td>${event.guestCount}</td><td>${event.theme}</td><td>${event.customerId}</td>
                        <td class="table-actions text-end">
                            <a class="btn btn-sm btn-outline-secondary" href="/events/${event.id}">View</a>
                            <a class="btn btn-sm btn-outline-secondary" href="/events/${event.id}/edit">Edit</a>
                            <form method="post" action="/events/${event.id}/delete"><button class="btn btn-sm btn-outline-danger">Delete</button></form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
