<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>board</title>
    <script type="text/javascript">
        $(document).ready(function() {

            var actionForm = $("#actionForm");
            var searchForm = $("#searchForm");

            $(".paginate_button a").on("click", function (e) {
                e.preventDefault();

                console.log('click');
                actionForm.find("input[name='pageNum']").val($(this).attr("href"));
                actionForm.submit();
            });

            $("#searchForm button").on("click",function(e){

                if(!searchForm.find("option:selected").val()){
                    alert("검색 조건을 선택해주세요.");
                    return false;
                }
                if(!searchForm.find("input[name='keyword']").val()){
                    alert("키워드를 입력하세요.");
                    return false;
                }

                searchForm.find("input[name='pageNum']").val("1");
                e.preventDefault();

                searchForm.submit();
            });

        });
    </script>
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
                <td><a class="move" href="/lists/${list.idx}">${list.title}</a></td>
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
                <div class="paginate_button  ${pageMaker.pageUtil.pageNum == num ? "active" : ""}">
                    <a href="${num}">${num}</a>
                </div>
            </c:forEach>
            <c:if test="${pageMaker.next}">
                <a href="/?pageNum=${pageMaker.endPage + 1}">다음</a>
            </c:if>
        </ul>
        <form id="actionForm" action="/" method="get">
            <input type="hidden" name="pageNum" value="${pageMaker.pageUtil.pageNum}"/>
            <input type="hidden" name="amount" value="${pageMaker.pageUtil.amount}"/>
            <input type="hidden" name="type" value="<c:out value='${pageMaker.pageUtil.type}'/>"/>
            <input type="hidden" name="keyword"  value="<c:out value='${pageMaker.pageUtil.keyword}'/>"/>
        </form>
        <form id="searchForm" action="/" method="get">
            <select name="type">
                <option value="" <c:out value="${pageMaker.pageUtil.type == null ? 'selected' : ''}"/>></option>
                <option value="T" <c:out value="${pageMaker.pageUtil.type eq 'T' ? 'selected' : ''}"/>>제목</option>
                <option value="C" <c:out value="${pageMaker.pageUtil.type eq 'C' ? 'selected' : ''}"/>>내용</option>
                <option value="W" <c:out value="${pageMaker.pageUtil.type eq 'W' ? 'selected' : ''}"/>>작성자</option>
                <option value="TC" <c:out value="${pageMaker.pageUtil.type eq 'TC' ? 'selected' : ''}"/>>제목 or 내용</option>
                <option value="TW" <c:out value="${pageMaker.pageUtil.type eq 'TW' ? 'selected' : ''}"/>>제목 or 작성자</option>
                <option value="CW" <c:out value="${pageMaker.pageUtil.type eq 'CW' ? 'selected' : ''}"/>>내용 or 작성자</option>
            </select>
            <input type="text"  name="keyword" value="<c:out value='${pageMaker.pageUtil.keyword}'/>"/>
            <input type="hidden" name="pageNum" value="${pageMaker.pageUtil.pageNum}"/>
            <input type="hidden" name="amount" value="${pageMaker.pageUtil.amount}"/>
            <button class="btn btn-default">Search</button>
        </form>
    </div>
</body>
</html>