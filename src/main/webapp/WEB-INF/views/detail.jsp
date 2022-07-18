<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <script type="text/javascript" src="/js/reply.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
        <%--console.log("JS test");--%>

        var bnoValue = '<c:out value="${board.idx}"/>'

        <%--replyService.add({reply:"JS test", replyer: "tester", bno: bnoValue}--%>
        <%--    ,--%>
        <%--    function(result){--%>
        <%--        alert("Result : " + result);--%>
        <%--    }--%>
        <%--);--%>

        console.info("JS test");

        replyService.getList({bnoValue, page:1},function(list){
            for( var i = 0, len = list.length || 0; i < len; i++){
                console.log(list[i]);
            }

            $(document).ready(function(){
                var replyUL = $(".chat");

                showList(1);

                function showList(page){
                    replyService.getList({bnoValue, page: page || 1}, function(list){
                        var str = "";
                        if(list == null || list.length == 0){
                            replyUL.html("");
                            return;
                        }
                        for(var i = 0, len = list.length || 0; i < len; i++){
                            str += "<li class='left left clearfix' data-rno'"+list[i].rno + "'>";
                            str += " <div><div class='header><string class='primary-font'>" + list[i].replyer + "</strong>";
                            str += "<small class='pull-right text-muted'>" + list[i].replyDate + "</small></div>";
                        }
                        replyUL.html(str);
                    })
                }
            })
        });
    </script>
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
    <div class="panel-body" >
        <ul class="chat" >
            <c:forEach items="${replies}" var="reply">
                <li style="border: 1px gray" class="left clearfix">
                    <div>
                        <div class="header">
                            <strong class="primary-font">${reply.replyer}</strong>
                            <small class="pull-right text-muted"><fmt:formatDate value="${reply.replyDate}" type="both"/>

                          </small>
                        </div>
                        <p>${reply.reply}</p>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</table>
</body>
</html>