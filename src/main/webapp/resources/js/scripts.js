$(function() {
    var str=location.href.toLowerCase();
    $('#panhead li a').each(function() {
        if (str.indexOf(this.href.toLowerCase()) > -1) {
            $('#panhead li').removeClass("active");
            $(this).parent().toggleClass("active");
        }
    });
    $('#panuser li a').each(function() {
        if (str.indexOf(this.href.toLowerCase()) > -1) {
            $('#panuser li').removeClass("active");
            $(this).parent().toggleClass("active");
        }
    });
    $('#panprod li a').each(function() {
        if (str.indexOf(this.href.toLowerCase()) > -1) {
            $('#panprod li').removeClass("active");
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

    $("#prod").dataTable();
});