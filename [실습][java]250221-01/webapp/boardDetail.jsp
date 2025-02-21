
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, java.time.format.DateTimeFormatter" %>
<%@ page import="org.example.board.vo.Board" %>
<%@ page import="org.example.board.dto.BoardDto" %>
<%
    BoardDto board = (BoardDto) request.getAttribute("board");
    String userName = (String) request.getAttribute("name");

%>
<script>
  var userName = "<%= userName != null ? userName : "" %>";
</script>
<html>
<head>
    <title>detail</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="js/comment.js"></script>
    <script src="js/board.js"></script>
    <script src="js/like.js"></script>

    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
      }

      #board {
        background-color: white;
        padding: 20px;
        margin: 20px auto;
        width: 80%;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      }

      #boardTitle {
        font-size: 24px;
        font-weight: bold;
        color: #333;
      }

      #boardContent {
        margin-top: 15px;
        font-size: 18px;
        color: #555;
      }

      #board h1 {
        margin: 5px 0;
      }

      #likeBtn {
        background: none;
        border: none;
        font-size: 28px;
        color: #ff6347;
        cursor: pointer;
        margin-left: 10px;
      }

      #likeBtn:hover {
        color: #ff4500;
      }

      .comment-item {
        background-color: #f9f9f9;
        margin-top: 15px;
        padding: 10px;
        border-radius: 5px;
        border: 1px solid #ddd;
      }

      .comment-item p {
        margin: 5px 0;
        font-size: 16px;
        color: #333;
      }

      .comment-item .author {
        color: #777;
        font-size: 14px;
      }

      #commentForm {
        margin-top: 20px;
        display: flex;
        justify-content: space-between;
        align-items: center;
      }

      #commentContent {
        width: 80%;
        padding: 8px;
        font-size: 16px;
        border: 1px solid #ddd;
        border-radius: 4px;
      }

      #commentForm input[type="button"] {
        padding: 8px 15px;
        font-size: 16px;
        color: white;
        background-color: #28a745;
        border: none;
        border-radius: 4px;
        cursor: pointer;
      }

      #commentForm input[type="button"]:hover {
        background-color: #218838;
      }

      .edit-form {
        background-color: #fafafa;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        display: none;
        width: 50%;
        margin: 20px auto;
      }

      .edit-form input,
      .edit-form textarea {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border-radius: 5px;
        border: 1px solid #ddd;
      }

      .edit-form input[type="button"] {
        background-color: #007bff;
        color: white;
        cursor: pointer;
      }

      .edit-form input[type="button"]:hover {
        background-color: #0056b3;
      }

      .delete-button {
        background-color: #dc3545;
        color: white;
        border: none;
        border-radius: 5px;
        padding: 8px 15px;
        cursor: pointer;
      }

      .delete-button:hover {
        background-color: #c82333;
      }


       body {
         font-family: Arial, sans-serif;
         background-color: #f4f4f4;
         margin: 0;
         padding: 0;
       }

      #board {
        background-color: white;
        padding: 20px;
        margin: 20px auto;
        width: 80%;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      }

      #boardTitle {
        font-size: 24px;
        font-weight: bold;
        color: #333;
      }

      #boardContent {
        margin-top: 15px;
        font-size: 18px;
        color: #555;
      }

      #board h1 {
        margin: 5px 0;
      }

      #likeBtn {
        background: none;
        border: none;
        font-size: 28px;
        color: #ff6347;
        cursor: pointer;
        margin-left: 10px;
      }

      #likeBtn:hover {
        color: #ff4500;
      }

      /* 댓글 리스트 */
      #commentList {
        margin-top: 20px;
      }

      .comment-item {
        background-color: #f9f9f9;
        padding: 15px;
        margin: 10px 0;
        border-radius: 8px;
        border: 1px solid #ddd;
        font-size: 16px;
      }

      .comment-item p {
        margin: 5px 0;
        color: #333;
      }

      .comment-item .author {
        color: #777;
        font-size: 14px;
      }

      .comment-item .createdAt {
        color: #aaa;
        font-size: 12px;
      }

      /* 댓글 작성 폼 */
      #commentForm {
        margin-top: 20px;
        display: flex;
        justify-content: space-between;
        align-items: center;
      }

      #commentContent {
        width: 80%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ddd;
        border-radius: 4px;
      }

      #commentForm input[type="button"] {
        padding: 10px 20px;
        font-size: 16px;
        color: white;
        background-color: #28a745;
        border: none;
        border-radius: 4px;
        cursor: pointer;
      }

      #commentForm input[type="button"]:hover {
        background-color: #218838;
      }

      /* 댓글 삭제 버튼 */
      .delete-btn {
        background-color: #dc3545;
        color: white;
        border: none;
        padding: 5px 10px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 14px;
        margin-left: 10px;
      }

      .delete-btn:hover {
        background-color: #c82333;
      }

      /* 수정 폼 */
      .edit-form {
        background-color: #fafafa;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        display: none;
        width: 50%;
        margin: 20px auto;
      }

      .edit-form input,
      .edit-form textarea {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border-radius: 5px;
        border: 1px solid #ddd;
      }

      .edit-form input[type="button"] {
        background-color: #007bff;
        color: white;
        cursor: pointer;
      }

      .edit-form input[type="button"]:hover {
        background-color: #0056b3;
      }
    </style>
</head>
<body>
    <div id="board" data-board-id="<%= board.getId() %>">
        <h1 id="boardTitle"><%= board.getTitle() %>
            <input type="button" id="likeBtn" value="<%= board.getLiked() ? "♥" : "♡" %>">
        </h1>
        <h1 id="boardContent"><%= board.getContent() %></h1>
        <h1><%= board.getAuthor() %></h1>
        <h1><%= board.getCreatedAt() %></h1>
    </div>

    <!-- ✅ 삭제 및 수정 버튼 (작성자일 경우에만 표시) -->
    <%
        if (userName != null && userName.equals(board.getAuthor())) {
    %>
    <div>
        <input type="button" value="수정" onclick="editBoard()">
        <input type="button" value="삭제" onclick="deleteBoard()">
    </div>
    <% } %>

    <!-- ✅ 댓글 작성 폼 -->
    <div>
        <form id="commentForm">
            <input type="text" id="commentContent" placeholder="댓글을 입력하세요">
            <input type="button" value="댓글 작성" onclick="send()">
        </form>
    </div>

    <!-- ✅ 댓글 리스트 -->
    <div id="commentList"></div>

    <!-- ✅ 수정 폼 (숨겨져 있음) -->
    <div id="editForm" style="display: none;">
        <h2>수정</h2>
        <input type="text" id="newTitle" value="<%= board.getTitle() %>">
        <textarea id="newContent"><%= board.getContent() %></textarea>
        <input type="button" value="수정 완료" onclick="submitEdit()">
    </div>
</body>
</html>
