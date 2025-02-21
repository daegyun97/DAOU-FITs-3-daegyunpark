$(document).ready(function () {
  $("#likeBtn").on("click", function () {
    let boardId = $("#board").data("board-id");
    let isLiked = $(this).val() === "♥"; // 현재 좋아요 상태 확인
    $.ajax({
      url: "LikeServlet",
      type: "POST",
      data: { boardId: boardId, isLiked: isLiked },
      dataType: "json",
      success: function (response) {

        $("#likeBtn").val(response ? "♥" : "♡"); // 하트 변경
      },
      error: function (xhr, status, error) {
        // 서버 응답이 실패하면 에러 메시지를 출력
        console.error("Request failed: " + error);
        console.log("Response text: " + xhr.responseText);
        alert("서버 오류 발생!");
      }
    });
  });
});
