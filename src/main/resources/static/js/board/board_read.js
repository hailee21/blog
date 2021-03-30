function comments(){
    $.ajax({
        url: "/api/v1/boards/"+$("#id").val()+"/comments",
        method: 'GET',
        success: function(data){
            let table_data = "";

            for(const i in data){
                table_data += "<tr>";
                table_data += "  <td>"+data[i].content+"</td>";
                table_data += "  <td>"+data[i].createdAt.slice(0,10)+"</td>";
                table_data += "  <td><input type='button' class='updateCommentBtn' id='"+data[i].id+"' value='수정'></td>";
                //table_data += "  <td><input type='button' onClick='updateComment("+data[i].id+")' value='수정'></td>";
                table_data += "  <td><input type='button' onClick='deleteComment("+data[i].id+")' value='삭제'></td>";
                table_data += "</tr>";
            }
            table_data += "<tr>";
            table_data += "<td><input type='text' name='content' id='comment_content'></td>";
            table_data += "<td><input type='button' onClick='addComment()' value='댓글 작성하기'></td>";
            //table_data += "<td><button id='addCommentBtn'>댓글 작성하기</button></td>";
            table_data += "</tr>";

            $("#comments_area").append(table_data);
        }
    })
}

// 댓글 작성
function addComment(){
    const boardId = {
        id: parseInt($("#id").val())
    }
    const commentEntity = {
        boardEntity: boardId,
        content: $("#comment_content").val()
    }

    $.ajax({
        url: "/api/v1/boards/"+$("#id").val()+"/comments",
        method: 'POST',
        data: JSON.stringify(commentEntity),
        contentType: 'application/json',
        success: function(data) {
            location.reload();
        }
    })
}

// 댓글 수정
// function updateComment(commentId){
//     location.href="/boards/comments/"++"/get/"+commentId;
// }

// 댓글 삭제
function deleteComment(commentId){

}


$(function(){
    $("#header").load("/layouts/header.html");

    comments();

        // 게시물 수정
        $("#updateBtn").on("click",function() {
            const boardEntity = {
                title: $("#title").val(),
                content: $("#content").val()
            }

            $.ajax({
                url: "/boards/update/" + parseInt($("#id").val()),
                method: 'POST',
                data: JSON.stringify(boardEntity),
                contentType: 'application/json',
                success: function(data) {
                    location.reload();
                }
            })
        });

        // 게시물 삭제
        $("#deleteBtn").on("click",function() {
            $.ajax({
                url: "/boards/delete/" + parseInt($("#id").val()),
                method: 'POST',
                success: function(data) {
                }
            })
        });

        // 댓글 수정
        $(".updateCommentBtn").on("click",function(){
           console.log("수정 클릭");
        });
});