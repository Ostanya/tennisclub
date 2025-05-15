$(document).ready(function () {
    // Smooth scroll for all .click-scroll links
    $('.click-scroll').on('click', function (e) {
        const target = $(this.getAttribute('href'));
        if (target.length) {
            e.preventDefault();
            $('html, body').animate({
                scrollTop: target.offset().top - 70
            }, 500);

            // Collapse navbar (mobile)
            $('.navbar-collapse').collapse('hide');
        }
    });

    // Highlight current section in navbar
    const sections = $('section[id]');
    $(window).on('scroll', function () {
        const scrollPos = $(document).scrollTop() + 80;

        sections.each(function () {
            const currLink = $('.nav-link[href="#' + this.id + '"]');
            const top = $(this).offset().top;
            const bottom = top + $(this).outerHeight();

            if (scrollPos >= top && scrollPos <= bottom) {
                $('.nav-link').removeClass('active');
                currLink.addClass('active');
            }
        });
    });
});
