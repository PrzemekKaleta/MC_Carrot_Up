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

    var footerDiv = $(document).find('footer div.haveLink');
    footerDiv.on('mouseover',function () {
        $(this).addClass('active');
        $(this).find('a').addClass('active2');
    });
    footerDiv.on('mouseleave',function () {
        $(this).removeClass('active');
        $(this).find('a').removeClass('active2');
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

    var countersFraction = document.querySelectorAll(".counterFraction");
    var speed = 100;


    countersFraction.forEach(counter => {
        var updateCount = () => {
            var target = +counter.getAttribute('data-target');


            var count = +counter.innerText;

            var inc = target / speed;

            if(count < target){
                counter.innerText = Math.ceil((count + inc)*4)/4;
                setTimeout(updateCount, 20);
            }else{
                count.innerText = target;
            }
        }
        updateCount();
    });

    var countersInteger = document.querySelectorAll(".counterInteger");


    countersInteger.forEach(counter => {
        var updateCount = () => {
            var target = +counter.getAttribute('data-target');

            var count = +counter.innerText;

            var inc = target / speed;

            if(count < target){
                counter.innerText = Math.ceil(count + inc);
                setTimeout(updateCount, 100);
            }else{
                count.innerText = target;
            }
        }
        updateCount();
    });


    var button = $(document).find('input[type="submit"]');
    button.on("mouseover", function () {
        $(this).addClass("active");

    });

    button.on("mouseleave", function () {
        $(this).removeClass("active");

    });

    var infoLinks = $(document).find('i.dot');
    infoLinks.on("mouseover", function () {
        $(this).removeClass("dot");
        $(this).addClass("active3");

    });

    infoLinks.on("mouseleave", function () {
        $(this).addClass("dot");
        $(this).removeClass("active3");

    });

    var formAddSuccess = $(document).find('form#addSuccess');

    formAddSuccess.submit(function (ev) {
        console.log("FOO");

        if(!$('input[type=radio]:checked').val()){
            alert("You don't choose kind of success");
            ev.preventDefault();
        };

    });

    var linksOfTagBox = $(document).find('div.tag-box a');

    linksOfTagBox.on("mouseover", function () {
        $(this).removeClass("previous");
        $(this).addClass("second");

    });

    linksOfTagBox.on("mouseleave", function () {
        $(this).addClass("previous");
        $(this).removeClass("second");

    });




});