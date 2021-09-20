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

/*    $('tr.zoominf').on('click', function () {
        $(this).toggleClass('chosen');
    });*/

    var trZoomInf = document.querySelectorAll("tr .zoominf");

    for(var i=0; i < trZoomInf.length; i++){
        console.log(trZoomInf[i]);
            }



    for(var i=0; i < trZoomInf.length; i++){
        trZoomInf[i].addEventListener("click", function () {
            this.addClass("koci");
            // this.toggleClass('chosen');
        });
    }


/*    var trZoomInf = $(document).find('tr.zoominf');


    trZoomInf.click(function() {
        $( this ).toggleClass( "highlight" );
    });

    trZoomInf.on('mouseover', function () {
        $(this).addClass('active');
    });
    trZoomInf.on('mouseleave', function () {
        $(this).removeClass('active');
    });


    trZoomInf.on('click', function() {

        $(this).toggleClass('chosen');*/

/*        if($(this).hasClass('chosen')){
            $(this).removeClass('chosen');

        }else{
            $(this).addClass('chosen');
        }*/



/*        if (!$(this).hasClass('chosen')) {
            $(this).addClass('chosen');
            $(this).next().show();

        } else {
            $(this).removeClass('chosen');
            $(this).next().hide();

        }*/


/*    trHidden.on('click', function(){
        $(this).hide();
    });*/

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