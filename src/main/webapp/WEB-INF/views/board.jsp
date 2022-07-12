<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="ko">
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
                <td><a onclick="location.href='/lists/${list.idx}'">${list.title}</a></td>
                <td>${list.id}</td>
                <td>${list.createAt}</td>
            </tr>
        </c:forEach>
    </table>
    <div class='pull-right'>
        <ul class="pagination">
            <c:if test="${pageMaker.prev}">
                <a href="/?pageNum=${pageMaker.startPage -1}">이전</a>
            </c:if>
            <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                    <a href="/?pageNum=${num}">${num}</a>
            </c:forEach>
            <c:if test="${pageMaker.next}">
                <a href="/?pageNum=${pageMaker.endPage + 1}">다음</a>
            </c:if>
        </ul>
    </div>
</body>
</html>