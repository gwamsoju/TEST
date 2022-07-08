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
        <th>게시물 번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <c:forEach items="${lists}" var="list">
            <tr>
                <td>${list.idx}</td>
                <td>${list.title}</td>
                <td>${list.id}</td>
                <td>${list.createAt}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>