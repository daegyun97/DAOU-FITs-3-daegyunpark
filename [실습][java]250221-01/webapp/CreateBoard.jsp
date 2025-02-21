<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
</head>
<body>
<h2>게시글 작성</h2>

<form action="CreateBoardServlet" method="post">
    <label for="title">제목:</label>
    <input type="text" id="title" name="title" required>
    <br><br>

    <label for="content">내용:</label>
    <textarea id="content" name="content" rows="5" cols="40" required></textarea>
    <br><br>

    <button type="submit">작성</button>
    <button type="button" onclick="location.href='BoardList.jsp'">취소</button>
</form>
</body>
</html>