<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>
        leftside area
        <div id="login_area" >
            <form id="login_form">
                로그인 안 되어있으면 로그인 폼 표시
                일단 로그인 폼부터

            </form>
        </div>

        <div id="user_info" hidden>
            로그인 되어있으면 유저 정보 표시
        </div>
        
    </body>

    <script>
        let isLogin = false;
        if (isLogin){
            document.getElementById("login_area").hidden = true;
            document.getElementById("user_info").hidden = false;
        }else{
            document.getElementById("login_area").hidden = false;
            document.getElementById("user_info").hidden = true;
        }

    </script>


    </html>