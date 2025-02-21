<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, java.time.format.DateTimeFormatter" %>
<%@ page import="org.example.board.vo.Board" %>
<%@ page import="org.example.board.dto.BoardsDTO" %>
<%
    List<org.example.board.dto.BoardsDTO> boardList = (List<org.example.board.dto.BoardsDTO>) request.getAttribute("boards"); // Controller에서 전달된 데이터
    String userName = (String) request.getAttribute("userName");
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

      /* 검색 폼 스타일 */
      .search-container {
        text-align: right;
        margin-bottom: 20px;
      }

      .search-input {
        padding: 8px;
        font-size: 14px;
        width: 200px;
        border: 1px solid #ddd;
        border-radius: 4px;
      }

      .search-btn {
        padding: 8px 15px;
        font-size: 14px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
      }

      .search-btn:hover {
        background-color: #0056b3;
      }

      .no-results {
        color: red;
        font-weight: bold;
      }
    </style>
</head>
<body>
<!-- 검색 폼 -->
<div class="search-container">
    <form action="BoardListServlet" method="get">
        <input type="text" name="keyWord" class="search-input" placeholder="검색어 입력..." />
        <button type="submit" class="search-btn">검색</button>
    </form>
</div>

<div style="text-align: right; margin-bottom: 10px;">
    <button onclick="location.href='CreateBoardServlet'">글 작성</button>
</div>

<h2>게시판 목록</h2>

<!-- 검색 결과가 없을 때 표시 -->
<% if (boardList != null && boardList.isEmpty()) { %>
<p class="no-results">검색 결과가 없습니다.</p>
<% } %>

<table>
    <thead>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>댓글</th>
        <th>조회</th>
        <th>좋아요</th>
    </tr>
    </thead>
    <tbody>
    <% if (boardList != null && !boardList.isEmpty()) {
        for (BoardsDTO board : boardList) { %>
    <tr>
        <td><%= board.getId() %></td>
        <td>
            <a href="BoardDetailServlet?id=<%= board.getId() %>">
                <%= board.getTitle() %>
            </a>
        </td>
        <td><%= board.getAuthor() %></td>
        <td><%= board.getCreatedAt().format(formatter) %></td>
        <td><%= board.getCommentCnt() %></td>
        <td><%= board.getCnt() %></td>
        <td><%= board.getLikeCnt() %></td>
    </tr>
    <% }
    } else { %>
    <tr>
        <td colspan="7">등록된 게시글이 없습니다.</td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
