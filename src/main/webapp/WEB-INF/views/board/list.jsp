<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 목록</title>
</head>
<body>
    <h1>게시물 목록</h1>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>등록일시</th>
            <th>파일 번호</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
        <c:forEach items="${boardList}" var="board">
            <tr>
                <td>${board.sn}</td>
                <td>${board.title}</td>
                <td>${board.cn}</td>
                <td>${board.modifyDate}</td>
                <td>${board.fileSn}</td>
                <td><a href="/board/${board.sn}/update">수정</a></td>
                <td><a href="/board/${board.sn}/delete">삭제</a></td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="/board/create">게시물 추가</a></p>
</body>
</html>