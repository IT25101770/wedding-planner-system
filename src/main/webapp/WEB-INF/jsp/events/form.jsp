<%@ include file="../partials/header.jspf" %>
<main class="container page-shell">
    <div class="card p-4">
        <h1 class="h4 mb-3">Wedding Event</h1>
        <form method="post" action="/events" class="row g-3">
            <input type="hidden" name="id" value="${event.id}">
            <input type="hidden" name="customerId" value="${event.customerId}">
            <div class="col-md-4"><label class="form-label">Date</label><input class="form-control" name="date" type="date" value="${event.date}" required></div>
            <div class="col-md-4">
                <label class="form-label">Venue</label>
                <select class="form-select" name="venue" required>
                    <option value="">Choose a location</option>
                    <option value="Lotus Grand Ballroom" ${event.venue == 'Lotus Grand Ballroom' ? 'selected' : ''}>Lotus Grand Ballroom</option>
                    <option value="Colombo Garden Resort" ${event.venue == 'Colombo Garden Resort' ? 'selected' : ''}>Colombo Garden Resort</option>
                    <option value="Mount Lavinia Beach Hall" ${event.venue == 'Mount Lavinia Beach Hall' ? 'selected' : ''}>Mount Lavinia Beach Hall</option>
                    <option value="Kandy Lake View Hotel" ${event.venue == 'Kandy Lake View Hotel' ? 'selected' : ''}>Kandy Lake View Hotel</option>
                </select>
            </div>
            <div class="col-md-4">
                <label class="form-label">Guest Count</label>
                <select class="form-select" name="guestCount" required>
                    <option value="">Choose guest count</option>
                    <option value="50" ${event.guestCount == 50 ? 'selected' : ''}>Up to 50 guests</option>
                    <option value="100" ${event.guestCount == 100 ? 'selected' : ''}>Up to 100 guests</option>
                    <option value="150" ${event.guestCount == 150 ? 'selected' : ''}>Up to 150 guests</option>
                    <option value="250" ${event.guestCount == 250 ? 'selected' : ''}>Up to 250 guests</option>
                    <option value="400" ${event.guestCount == 400 ? 'selected' : ''}>Up to 400 guests</option>
                </select>
            </div>
            <div class="col-md-12">
                <label class="form-label">Theme</label>
                <select class="form-select" name="theme" required>
                    <option value="">Choose a theme</option>
                    <option value="Elegant White" ${event.theme == 'Elegant White' ? 'selected' : ''}>Elegant White</option>
                    <option value="Royal Gold" ${event.theme == 'Royal Gold' ? 'selected' : ''}>Royal Gold</option>
                    <option value="Garden Romance" ${event.theme == 'Garden Romance' ? 'selected' : ''}>Garden Romance</option>
                    <option value="Beach Sunset" ${event.theme == 'Beach Sunset' ? 'selected' : ''}>Beach Sunset</option>
                    <option value="Traditional Sri Lankan" ${event.theme == 'Traditional Sri Lankan' ? 'selected' : ''}>Traditional Sri Lankan</option>
                </select>
            </div>
            <div class="col-12"><button class="btn btn-primary">Save Event</button><a class="btn btn-outline-secondary" href="/events">Cancel</a></div>
        </form>
    </div>
</main>
<%@ include file="../partials/footer.jspf" %>
