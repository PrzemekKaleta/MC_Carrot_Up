$(function () {
    $(window).on('scroll', function () {
        if ( $(window).scrollTop() > 10 ) {
            $('.header').addClass('focus');
        } else {
            $('.header').removeClass('focus');
        }
    });

    $('li').on('mouseover', function () {
        $(this).addClass('active');

    });

    $('li').on('mouseleave', function () {
        $(this).removeClass('active');

    });

    var trHidden = $(document).find('tr.hidemy');
    trHidden.hide();

    var trZoomInf = $(document).find('tr.zoominf');

    trZoomInf.on('click', function(){
        $(this).next().show();
    });

    trHidden.on('click', function(){
        $(this).hide();
    });


});