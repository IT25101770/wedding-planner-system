<%@ include file="partials/header.jspf" %>
<section class="hero ios-hero">
    <div class="hero-left">
        <p class="hero-kicker">Premium Wedding Management Platform</p>
        <h1 class="hero-title">Plan Your<br><em>Perfect Day</em><br>with Group 107</h1>
        <p class="hero-desc">Orchestrate every detail of your dream wedding from vendor bookings to budget management in one beautifully designed platform.</p>
        <form class="movie-search" method="get" action="/vendors">
            <input name="keyword" placeholder="Search photographers, catering, decoration, music bands...">
            <button class="btn btn-primary px-4"><i class="bi bi-search"></i> Search</button>
        </form>
        <div class="hero-scroll"><span class="scroll-line"></span>Scroll to discover</div>
        <div class="hero-actions">
            <a href="/register" class="btn btn-primary btn-lg">Begin Your Journey</a>
            <a href="/services" class="btn btn-ghost btn-lg">Explore Services</a>
        </div>
    </div>
    <div class="hero-photo-panel" aria-label="Wedding celebration photo">
        <img src="https://images.pexels.com/photos/2253842/pexels-photo-2253842.jpeg?auto=compress&cs=tinysrgb&w=1200" alt="Smiling wedding couple outdoors">
        <div class="hero-photo-caption">
            <span>Your Day, Beautifully Planned</span>
            <strong>From the first idea to the final celebration, every detail stays organized.</strong>
        </div>
    </div>
</section>

<section class="story-band">
    <div class="story-copy animate-rise">
        <p class="section-label">Dream Day</p>
        <h2 class="section-title text-start">Wedding day is your dream day. We make it happen.</h2>
        <p>Plan with care, choose trusted suppliers, and keep every event, booking, discount, and payment beautifully organized.</p>
        <a href="/vendors" class="btn btn-primary">Explore Vendors</a>
    </div>
    <div class="story-gallery">
        <figure class="story-photo photo-one"><img src="https://images.pexels.com/photos/169196/pexels-photo-169196.jpeg?auto=compress&cs=tinysrgb&w=900" alt="Wedding reception table"></figure>
        <figure class="story-photo photo-two"><img src="https://images.pexels.com/photos/2959192/pexels-photo-2959192.jpeg?auto=compress&cs=tinysrgb&w=900" alt="Wedding photographer"></figure>
        <figure class="story-photo photo-three"><img src="https://images.pexels.com/photos/1444442/pexels-photo-1444442.jpeg?auto=compress&cs=tinysrgb&w=900" alt="Wedding flowers"></figure>
    </div>
</section>

<section class="features" id="features">
    <div class="section-header">
        <p class="section-label">Why Choose Us</p>
        <h2 class="section-title">Everything You Need<br>in One Elegant System</h2>
    </div>
    <div class="features-grid">
        <div class="feature-card"><div class="feature-icon"><i class="bi bi-calendar2-heart"></i></div><h3 class="feature-title">Event Management</h3><p class="feature-desc">Create and manage wedding events with control over dates, venues, themes, and guest counts.</p></div>
        <div class="feature-card"><div class="feature-icon"><i class="bi bi-shop"></i></div><h3 class="feature-title">Vendor Network</h3><p class="feature-desc">Browse photographers, caterers, decorators, and music bands with package and availability details.</p></div>
        <div class="feature-card"><div class="feature-icon"><i class="bi bi-journal-check"></i></div><h3 class="feature-title">Smart Booking</h3><p class="feature-desc">Book vendors for wedding events, cancel bookings, and track pending or confirmed status.</p></div>
    </div>
</section>

<section class="packages" id="packages">
    <div class="section-header">
        <p class="section-label">Our Packages</p>
        <h2 class="section-title">Exclusive Discounts for Your Wedding</h2>
        <p class="section-desc">Choose a package on the payment page and the discount percentage will be applied automatically to the invoice total.</p>
    </div>
    <div class="packages-grid">
        <div class="package-card"><img src="https://images.pexels.com/photos/169211/pexels-photo-169211.jpeg?auto=compress&cs=tinysrgb&w=900" alt="Half package wedding planning table"><div class="package-body"><h3>Half Package</h3><div class="discount-badge">15% Discount</div><p>Support at any stage of wedding planning until your dream day.</p><a href="/payments/new?package=half" class="btn btn-primary">Get Now</a></div></div>
        <div class="package-card featured-package"><img src="https://images.pexels.com/photos/265722/pexels-photo-265722.jpeg?auto=compress&cs=tinysrgb&w=900" alt="Full package wedding ceremony"><div class="package-body"><h3>Full Package</h3><div class="discount-badge">20% Discount</div><p>Guidance from the beginning to the end with the strongest savings.</p><a href="/payments/new?package=full" class="btn btn-primary">Get Now</a></div></div>
        <div class="package-card"><img src="https://images.pexels.com/photos/931162/pexels-photo-931162.jpeg?auto=compress&cs=tinysrgb&w=900" alt="Day package wedding bouquet"><div class="package-body"><h3>Day Package</h3><div class="discount-badge">10% Discount</div><p>Peace of mind and coordination support on your wedding day.</p><a href="/payments/new?package=day" class="btn btn-primary">Get Now</a></div></div>
    </div>
</section>

<section class="services" id="services">
    <div class="section-header">
        <p class="section-label">Our Vendors</p>
        <h2 class="section-title">Curated Service Categories</h2>
    </div>
    <div class="services-grid">
        <a class="service-item" href="/vendors?category=Photographer"><div class="service-emoji"><i class="bi bi-camera"></i></div><div class="service-name">Photography</div><div class="service-sub">Albums, shoots, portraits</div></a>
        <a class="service-item" href="/vendors?category=Catering"><div class="service-emoji"><i class="bi bi-cup-hot"></i></div><div class="service-name">Catering</div><div class="service-sub">Menus and dining</div></a>
        <a class="service-item" href="/vendors?category=Decoration"><div class="service-emoji"><i class="bi bi-flower1"></i></div><div class="service-name">Decoration</div><div class="service-sub">Floral and venue styling</div></a>
        <a class="service-item" href="/vendors?category=MusicBand"><div class="service-emoji"><i class="bi bi-music-note-beamed"></i></div><div class="service-name">Music & Band</div><div class="service-sub">Live sound and celebration</div></a>
    </div>
</section>

<section class="cta-section">
    <p class="section-label cta-label">Start Today</p>
    <h2 class="cta-title">Your Dream Wedding<br>Begins Here</h2>
    <p class="cta-desc">Create your account, plan your event, browse trusted vendors, and manage every booking with elegance.</p>
    <div class="cta-buttons">
        <a href="/register" class="btn btn-primary btn-lg">Create Free Account</a>
        <a href="/admin/login" class="btn btn-outline-light btn-lg">Admin Access</a>
    </div>
</section>

<footer class="site-footer">
    <div class="footer-center">
        <div class="footer-logo new-footer-logo"><span>The Wedding Studio</span><strong>Group 107</strong><small>Planning, Vendors & Events</small></div>
        <p>Sri Lanka Institute of Information Technology, Malabe</p>
        <p>+94 710 951 040</p>
        <p><a href="mailto:group107@my.sliit.lk">group107@my.sliit.lk</a></p>
        <div class="social-links">
            <a href="#" aria-label="Facebook"><i class="bi bi-facebook"></i></a>
            <a href="#" aria-label="Instagram"><i class="bi bi-instagram"></i></a>
            <a href="#" aria-label="Twitter"><i class="bi bi-twitter-x"></i></a>
            <a href="#" aria-label="YouTube"><i class="bi bi-youtube"></i></a>
        </div>
    </div>
    <div class="footer-bottom">
        <div class="footer-copy">&copy; 2026 Group 107 Wedding Planning System. All rights reserved.</div>
        <div class="footer-copy">Built with care for unforgettable moments</div>
    </div>
</footer>
<%@ include file="partials/footer.jspf" %>