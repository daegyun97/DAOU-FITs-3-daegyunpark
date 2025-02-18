<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, java.time.format.DateTimeFormatter" %>
<%@ page import="org.example.board.vo.Board" %>
<%
    List<org.example.board.vo.Board> boardList = (List<org.example.board.vo.Board>) request.getAttribute("boards"); // Controller에서 전달된 데이터
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); // 날짜 포맷
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <style>
      table { width: 100%; border-collapse: collapse; }
      th, td { padding: 10px; border: 1px solid #ddd; text-align: center; }
      th { background-color: #f4f4f4; }
      a { text-decoration: none; color: blue; }
      a:hover { text-decoration: underline; }
    </style>
</head>
<body>
<h2>게시판 목록</h2>
<table>
    <thead>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
    </tr>
    </thead>
    <tbody>
    <% if (boardList != null && !boardList.isEmpty()) {
        for (Board board : boardList) { %>
    <tr>
        <td><%= board.getId() %></td>
        <td>
            <a href="boardDetail.jsp?id=<%= board.getId() %>">
                <%= board.getTitle() %>
            </a>
        </td>
        <td><%= board.getAuthor() %></td>
        <td><%= board.getCreatedAt().format(formatter) %></td>
    </tr>
    <% }
    } else { %>
    <tr>
        <td colspan="4">등록된 게시글이 없습니다.</td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
