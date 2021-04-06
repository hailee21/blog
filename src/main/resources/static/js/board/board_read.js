function comments(){
    $.ajax({
        url: "/api/v1/boards/"+$("#id").val()+"/comments",
        method: 'GET',
        success: function(data){
            let table_data = "";

            for(const i in data){
                table_data += "<div>";
                table_data += "  <div class='form-group'>";
                table_data += "    <span class='col-sm-2 control-label'>"+data[i].content+"</span>";
                table_data += "      <div class='col-sm-10'>"
                table_data += "        <span class='col-sm-10' value='"+data[i].createdAt.slice(0,10)+"'></span>"
                table_data += "        <button type='button' onClick='updateComment("+$("#id").val()+","+data[i].id+")' className='update_btn btn btn-warning'>수정</button>";
                table_data += "        <button type='button' onClick='deleteComment("+$("#id").val()+","+data[i].id+")' className='delete_btn btn btn-danger'>삭제</button>";
                table_data += "      </div>"
                table_data += "  </div>";
                table_data += "</div>";
            }
            table_data += "<div>";
            table_data += "  <input type='text' name='content' class='col-sm-10' id='comment_content'>";
            table_data += "  <button type='button' class='replyWriteBtn btn btn-success' onClick='addComment()'>댓글 작성하기</button>";
            table_data += "</div>";

            $("#commentsArea").append(table_data);
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
function updateComment(boardId, commentId){
    location.href="/boards/"+boardId+"/comments/"+commentId;
}

// 댓글 삭제
function deleteComment(boardId, commentId){
    $.ajax({
        url: "/api/v1/boards/"+boardId+"/comments/"+commentId,
        method: 'DELETE',
        success: function(data) {
            location.href="/boards";
        }
    })
}

$(function(){
    comments();

    // 게시물 수정
    $("#updateBtn").on("click",function() {
        const boardEntity = {
            title: $("#title").val(),
            content: $("#content").val()
        }
        //const url = "/boards/update/" + parseInt($("#id").val());

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
            url: "/api/v1/boards/" + $("#id").val(),
            method: 'DELETE',
            success: function(data) {
                location.href="/boards";
            }
        })
    });
});