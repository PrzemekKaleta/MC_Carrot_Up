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

    var trZoomInf = $("tr.zoominf");

    var trHideMy = $("tr.hidemy");

    console.log(trZoomInf);
    console.log(trHideMy);

    trZoomInf.on("click", function () {

        $(this).next().toggleClass("hide");

    });

    trHideMy.on("click", function () {
        $(this).toggleClass("hide");
    });



    var pagesTable = $(document).find('.links a');
    pagesTable.on('mouseover', function(){
            $(this).addClass('active');
        });


    pagesTable.on('mouseleave', function(){
        if(!$(this).hasClass('chosen')) {
            $(this).removeClass('active');
        }
    });


});