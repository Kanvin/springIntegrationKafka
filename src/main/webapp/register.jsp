

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.3.min.js"></script>

    <script type="text/javascript">

        $().ready(function(){

            $("#sButton").click(function(){

                var json = {
                    "name": $("#name").val(),
                    "password": $("#password").val()
                }

                $.ajax({
                    type: "POST",
                    url: "kafka/register.json",
                    data: JSON.stringify(json),
                    contentType: 'application/json',
                    success: function(data) {
                        $("#result").val(JSON.stringify(data));
                    }
                });
            });
        });

    </script>
</head>
<body>

<br/>
Name:    <input type="text" name="name" id="name"/><br/>
<br/>
Password: <input type="text" name="password" id="password"/><br/>
<br/>

<input type="submit" name="submit" id="sButton" style="margin-left:150px;">
<br/><br/><br/>
Result:<br/>
<textarea rows="10" cols="10" id="result"></textarea><br/>



</body>
</html>