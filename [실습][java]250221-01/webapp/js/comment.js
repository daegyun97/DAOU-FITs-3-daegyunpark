$(document).ready(function() {
  // 페이지 로드 후 자동으로 댓글을 불러옴
  var boardId = $('#board').data('board-id');
  loadComments(boardId);
});

function loadComments(boardId) {

  $.ajax({
    url: "CommentServlet",
    type: "GET",
    data: { boardId: boardId },
    dataType: "json",
    success: function (comments) {
      let commentList = $("#commentList");
      commentList.empty();

      $.each(comments, function (index, comment) {
        let deleteButton = '';
        if (comment.authorName === userName) {
          deleteButton = `<input type="button" class="delete-btn" data-id="${comment.id}" value="삭제" >`;
        }

        let commentHtml = `
                    <div class="comment-item" data-id="${comment.id}">
                        <p>${comment.content} - ${comment.authorName} - ${comment.createdAt}</p>
                         ${deleteButton}
                    </div>
                `;
        commentList.append(commentHtml);
      });
    },
    error: function (xhr, status, error) {
      // 서버 응답이 실패하면 에러 메시지를 출력
      console.error("Request failed: " + error);
      console.log("Response text: " + xhr.responseText);
      alert("댓글을 불러올 수 없습니다.");
    }
  });
}

function send()  {
  // event.preventDefault();
  var boardId = $('#board').data('board-id');
  var commentContent = $('#commentContent').val();  // 댓글 내용 가져오기


  if(commentContent.trim() === "") {
    alert("댓글을 입력해주세요.");
    return;
  }

  // 댓글을 서버로 보내는 AJAX 요청
  $.ajax({
    url: "CommentServlet",  // 서버 서블릿 URL
    type: "POST",           // POST 방식
    data: {
      boardId: boardId,       // boardId 전송
      content: commentContent // 댓글 내용 전송
    },
    success: function(comment) {
      loadComments(boardId);
      $('#commentContent').val('');
    },
    error: function(xhr, status, error) {
      // 에러 처리
      console.error("Error saving comment: " + error);
      alert("댓글을 저장할 수 없습니다.");
    }
  });
}

$(document).on("click", ".delete-btn", function () {
  let commentId = $(this).data("id"); // 댓글 ID 가져오기
  let commentItem = $(this).closest(".comment-item"); // 해당 댓글 요소

  $.ajax({
    url: "DeleteCommentServlet", // 서버의 댓글 삭제 엔드포인트
    type: "POST",
    data: { id: commentId }, // 삭제할 댓글 ID 전송
    success: function (response) {
      commentItem.remove();

    },
    error: function (xhr, status, error) {
      console.error("댓글 삭제 실패:", error);
      alert("서버 오류로 댓글 삭제에 실패하였습니다.");
    }
  });
});