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
    $('input').click(function(){
        $('.error').empty();
    });
});