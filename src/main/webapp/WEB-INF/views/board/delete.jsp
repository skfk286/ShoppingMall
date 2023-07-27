<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 삭제</title>
</head>
<body>
    <h1>게시물 삭제</h1>
    <form action="/board/${board.sn}/delete" method="post">
        <p>게시물을 삭제하시겠습니까?</p>
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="삭제">
    </form>
    <p><a href="/board/list">목록으로 돌아가기</a></p>
</body>
</html>
