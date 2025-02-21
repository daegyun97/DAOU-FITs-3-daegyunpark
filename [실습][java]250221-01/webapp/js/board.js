$(document).ready(function() {
  var boardId = $('#board').data('board-id');
  $.ajax({
    url: 'UpdateBoardServlet',  // 요청을 보낼 서버 URL
    type: 'GET',
    data: { id: boardId },  // 서버로 전달할 파라미터
    success: function(response) {
      console.log('Request successful');
    },
    error: function(xhr, status, error) {
      console.error("Request failed: " + error);
    }
  });
});

function deleteBoard() {
  var boardId = $('#board').data('board-id');
  $.ajax({
    url: "DeleteBoardServlet",
    type: "GET",
    data: { boardId: boardId },
    dataType: "json",
    success: function () {
      window.location.href = "/board_war_exploded/BoardListServlet";
    },
    error: function (xhr, status, error) {
      // 서버 응답이 실패하면 에러 메시지를 출력
      console.error("Request failed: " + error);
      console.log("Response text: " + xhr.responseText);
    }
  });
}
function editBoard() {
  // 현재 제목과 내용을 수정 폼에 채우고 폼을 보여줌
  var title = $('#boardTitle').text();
  var content = $('#boardContent').text();

  $('#newTitle').val(title);
  $('#newContent').val(content);

  // 수정 폼 보이기
  $('#editForm').show();
}

function submitEdit() {
  var boardId = $('#board').data('board-id');
  var newTitle = $('#newTitle').val();
  var newContent = $('#newContent').val();

  // AJAX를 통해 수정된 데이터를 서버로 전송
  $.ajax({
    url: "UpdateBoardServlet",
    type: "POST",
    data: {
      boardId: boardId,
      title: newTitle,
      content: newContent
    },
    success: function(response) {
      // 수정 성공 후 페이지 갱신
      window.location.reload(); // 또는 적절한 리다이렉트
    },
    error: function(xhr, status, error) {
      console.error("Request failed: " + error);
      console.log("Response text: " + xhr.responseText);
    }
  });
}