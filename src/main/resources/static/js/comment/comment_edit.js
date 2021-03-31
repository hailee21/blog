$(function(){
    $("#editBtn").on("click",function() {
        const boardId = {
            id: parseInt($("#boardId").val())
        }
        const commentEntity = {
            boardEntity: boardId,
            content: $("#content").val()
        }

        $.ajax({
            url: "/api/v1/boards/"+$("#boardId").val()+"/comments/"+$("#commentId").val(),
            method: 'PUT',
            data: JSON.stringify(commentEntity),
            contentType: 'application/json',
            success: function(data) {
                location.href="/boards";
            }
        })
    });
});