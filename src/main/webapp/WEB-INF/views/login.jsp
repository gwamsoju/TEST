<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        function test(){

            var sample = {"name" : "wodud" , "password": "12345"};

            $.ajax({
                url:"/test",
                type:"post",
                data: JSON.stringify(sample), // JSON 데이터를 String으로 변환함.
                contentType: "application/json", // 전달되는 String 데이터가 JSON 형태로 이루어진 것을 알려주기 위함.
                success: function() {
                    alert("통신성공");
                },
                error: function() {
                    alert("error");
                }
            });
        }
    </script>
</head>
<body>
<form method="get" action="/loginProc">
    <input type="text" id="id" name="id"/>
    <input type="password" id="password" name="password"/>
    <input type="submit" value="로그인"/>
</form>
<button type="button" onclick="test()">전송</button>

</body>
</html>