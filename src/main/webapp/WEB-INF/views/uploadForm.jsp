<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta charset="UTF-8">
    <title>board</title>
</head>
<body>
    <form action="/upload" method="post" enctype="multipart/form-data"> <!-- 가장 중요한 것은 enctype이다. -->
        <input type="file" name="uploadFiles" multiple/> <!-- multiple으로 하나의 태그로 한꺼번에 여러 개의 파일을 업로드 가능.-->
        <button>Submit</button>
    </form>
</body>
</html>