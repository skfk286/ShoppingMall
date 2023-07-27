<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 추가</title>
</head>
<body>
    <h1>게시물 추가</h1>
    <form action="/board/create" method="post">
        <!-- sn 값은 사용자가 직접 입력하지 않고 서버에서 생성합니다. -->
        <input type="hidden" name="sn" value="0">

        <label for="title">제목:</label>
        <input type="text" id="title" name="title"><br>

        <label for="cn">내용:</label>
        <textarea id="cn" name="cn" rows="4" cols="50"></textarea><br>

        <label for="fileSn">파일 번호:</label>
        <input type="text" id="fileSn" name="fileSn"><br>

        <input type="submit" value="추가">
    </form>
    <p><a href="/board/list">목록으로 돌아가기</a></p>
</body>
</html>
