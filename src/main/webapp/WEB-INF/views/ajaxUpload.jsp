<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>board</title>
</head>
<body>
    <div class="uploadDiv">
        <input type="file" name="uploadFile" multiple/>
    </div>
    <button id="uploadBtn">Submit</button>

    <script type="text/javascript">
        $(document).ready(function(){

            var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
            var maxSize = 5242880; // 5MB

            function checkExtension(fileName, fileSize) {  // 첨부파일을 업로드하면 해당 메서드가 실행되도록 함.
                if (fileSize > maxSize) {
                    alert("파일 사이즈 초과!");
                    return false;
                }

                if (regex.test(fileName)) {
                    alert("해당 종류의 파일은 업로드할 수 없습니다.");
                    return false;
                }
                return true;
            }

            $("#uploadBtn").on("click",function(e){

                var formData = new FormData(); // jQuery를 이용하는 경우에는 FormData라는 객체를 이용하여 파일 업로드를 함.
                                                // 가상의 form태그와 같다고 보면 된다.

                var inputFile = $("input[name='uploadFile']");

                var file = inputFile[0].files;

                console.log(file);

                for(var i = 0 ; i < file.length; i++){

                    if(!checkExtension(file[i].name, file[i].size)){
                        return false;
                    }

                    formData.append("uploadFile", file[i]);
                }

                $.ajax({
                   url : "/uploadAjaxAction",
                   processData: false, // 반드시 false
                   contentType: false, // 반드시 false
                   data: formData, // formData 자체를 전송, 전송할 데이터
                   type: "POST",
                    dataType:"JSON", // 받을 데이터 형태 
                   success: function(result){
                        console.log(result);
                   }
                });
            });
        });
    </script>
</body>
</html>