$(function(){
    $('.lnb_wrap .dth1 > li a').on('click', function(){
        $(this).toggleClass('on').parent().siblings().removeClass('on').find('a').removeClass('on');
    });
});

$(function(){
    const thWidth = $('.popup.mem_info .txt_table .th').width();
    $('.popup.mem_info .img_table .board .th').width(thWidth);
    $(window).resize(function(){
        const thWidth = $('.popup.mem_info .txt_table .th').width();
        $('.popup.mem_info .img_table .board .th').width(thWidth);
    });
});

$(function(){
    $(".select-btn").on("click", function(){
        $(".select-box").slideDown();
    });
    
    $(".select-box .btn_25").on("click", function(){
        $(".select-box").slideUp();
    });
});