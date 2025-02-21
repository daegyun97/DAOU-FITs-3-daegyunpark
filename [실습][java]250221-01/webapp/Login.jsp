
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인 페이지</title>
    <style>
      /* 전체 페이지 스타일 */
      body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh; /* 화면 전체 높이 */
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
      }

      /* 버튼을 담을 컨테이너 */
      .button-container {
        display: flex;
        flex-direction: column; /* 버튼을 세로로 배치 */
        gap: 20px; /* 버튼 사이의 간격 */
        align-items: center;
      }

      /* 공통 버튼 스타일 */
      .btn {
        font-size: 18px;
        padding: 20px 40px;
        width: 200px;
        text-align: center;
        border: none;
        border-radius: 10px;
        cursor: pointer;
        transition: background-color 0.3s;
      }

      .btn:hover {
        background-color: #0066cc;
        color: white;
      }

      .logout-btn {
        background-color: #ff4d4d;
      }

      .board-btn {
        background-color: #4caf50;
      }
    </style>
</head>
<body>

<div class="button-container">
    <!-- 로그아웃 버튼 -->
    <button class="btn logout-btn" onclick="window.location.href='index.jsp'">로그아웃</button>

    <!-- 게시판 버튼 -->
    <form id="boardForm" action="BoardListServlet" method="get">
        <button type="submit" class="btn board-btn">게시판</button>
    </form>
</div>

</body>
</html>