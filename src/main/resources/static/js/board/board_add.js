$(function(){
    $("#nav").load("/layouts/nav.html");

    $("#addBtn").on("click",function() {
        const boardEntity = {
            title: $("#title").val(),
            content: $("#content").val()
        }

        $.ajax({
            url: "/boards/create",
            data: JSON.stringify(boardEntity),
            type: 'POST',
            contentType: 'application/json',
            success: function(data) {
                window.location.href = '/boards';
            }
        })
    });
});