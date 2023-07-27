<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 상세 보기</title>
</head>
<body>
    <h1>게시물 상세 보기</h1>
    <table>
        <tr>
            <th>번호</th>
            <td>${board.sn}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${board.title}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${board.cn}</td>
        </tr>
        <tr>
            <th>등록일시</th>
            <td>${board.modifyDate}</td>
        </tr>
        <tr>
            <th>파일 번호</th>
            <td>${board.fileSn}</td>
        </tr>
    </table>
</body>
</html>
