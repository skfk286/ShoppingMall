<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 수정</title>
</head>
<body>
    <h1>게시물 수정</h1>
    <form action="/board/${board.sn}/update" method="post">
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" value="${board.title}"><br>

        <label for="cn">내용:</label>
        <textarea id="cn" name="cn" rows="4" cols="50">${board.cn}</textarea><br>

        <label for="fileSn">파일 번호:</label>
        <input type="text" id="fileSn" name="fileSn" value="${board.fileSn}"><br>

        <input type="submit" value="수정">
    </form>
    <p><a href="/board/list">목록으로 돌아가기</a></p>
</body>
</html>
