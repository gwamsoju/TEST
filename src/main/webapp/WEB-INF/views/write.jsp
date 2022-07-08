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
  <form method="post" action="/write">
      <label for="title">제목 :</label>
      <input type="text" id="title" name="title"/><br>
      <label for="context">내용 :</label>
      <textarea name="context" id="context"></textarea><br>
      <label for="id">작성자 :</label>
      <input type="text" id="id" name="id"/><br>
  </form>

</table>
</body>
</html>