$(function(){
    //$("#nav").load("/layouts/nav.html");

    //검색
    $("#searchBtn").on("click", function(){
        $.ajax({
            url: "/boards/search/"+$("#searchBar").val(),
            method: 'GET',
            success: function(data) {
                //location.href="/boards";
            }
        })
    })

    // 정렬
    $("#sortBoard").on("change", function(){
        const sortId = $("#sortBoard").val();
        sortBoard(sortId);
    })


});

function sortBoard(sortId){
    $.ajax({
        url: "/boards/sort/"+sortId,
        method: 'GET',
        success: function(data) {
            //location.href="/boards";
        }
    })
}