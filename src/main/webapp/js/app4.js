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


    trZoomInf.on("click", function () {

        $(this).next().toggleClass("hide");

    });

    trHideMy.on("click", function () {
        $(this).toggleClass("hide");
    });

    trZoomInf.on("mouseover", function () {
        $(this).addClass("active");
    });

    trZoomInf.on("mouseleave", function () {
        $(this).removeClass("active");
    });

    trHideMy.on("mouseover", function () {
        $(this).addClass("active");
    });

    trHideMy.on("mouseleave", function () {
        $(this).removeClass("active");
    });

    var linksFromAdd = $(document).find('.hidemy a');
    linksFromAdd.on('mouseover', function () {
       $(this).addClass('active2');
    });

    linksFromAdd.on('mouseleave', function () {
        $(this).removeClass('active2');
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