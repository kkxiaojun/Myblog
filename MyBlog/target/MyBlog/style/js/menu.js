$(function() {
    // 修改catagoty
    $('.allcatagory').on('click', 'a', function(e) {
        if (e.target.className == 'editType') {
            var span = $(this).parent('.allcatagory').prev().find('.showcatagory');
            var form = $(this).parent('.allcatagory').prev().find('.changecatagory');
            var content = span.text();
            form.find('.contentinput').val(content);
            span.hide();
            form.show();
        }
    });
    $('.allcatagory').on('click', 'a', function(e) {
        if (e.target.className == 'resetType') {
            var span = $(this).parent('.changecatagory').prev();
            var form = $(this).parent('.changecatagory');
            var content = $(this).prev('.contentinput').text();
            span.val(content);
            form.hide();
            span.show();
        }
    });
    //导航菜单
    function navList() {
        var $obj = $("#nav_dot");
        $obj.find("h4").click(function() {
            var $div = $(this).siblings(".list-item");
            if ($(this).parent().hasClass("selected")) {
                $div.slideUp(600);
                $(this).parent().removeClass("selected");
            }
            if ($div.is(":hidden")) {
                $("#nav_dot li").find(".list-item").slideUp(600);
                $("#nav_dot li").removeClass("selected");
                $(this).parent().addClass("selected");
                $div.slideDown(600);

            } else {
                $div.slideUp(600);
            }
        });
    }
    navList();
});
