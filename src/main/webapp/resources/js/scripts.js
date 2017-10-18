$(function() {
    var str=location.href.toLowerCase();
    $('.navbar-nav li a').each(function() {
        if (str.indexOf(this.href.toLowerCase()) > -1) {
            $('.navbar-nav li').removeClass("active");
            $(this).parent().toggleClass("active");
        }
    });
    $('.nav-pills li a').each(function() {
        if (str.indexOf(this.href.toLowerCase()) > -1) {
            $('.nav-pills li').removeClass("active");
            $(this).parent().toggleClass("active");
        }
    });
    $('.nav-sidebar li a').each(function() {
        if (str.indexOf(this.href.toLowerCase()) > -1) {
            $('.nav-sidebar li').removeClass("active");
            $(this).parent().toggleClass("active");
        }
    });
    $('input').click(function(){
        $('.error').empty();
    });

    $("input:file").change(function (){
        var fileName = $(this).val().split( '\\' ).pop();
        $(this).next('label').html('<i class="fa fa-file"></i> ' + fileName);
    });

});