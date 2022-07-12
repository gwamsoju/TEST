<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta charset="UTF-8">
    <title>board</title>
</head>
<body>
<table class="w3-border w3-table">
    <table class="w3-border w3-table">
        <tr>제목</tr><td>${board.title}<td>
        <tr>작성자</tr><td>${board.id}<td>
        <tr>내용</tr><td>${board.context}<td>
        <tr>작성일</tr><td>${board.createAt}<td>
       </table>
       <a href="/">목록</a>
</table>
</body>
</html>