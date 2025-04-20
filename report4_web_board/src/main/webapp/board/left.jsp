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
            <!-- 로그인 안 되어있으면 로그인 폼 표시. iframe의 left 페이지를 갱신. 페이지 이동은 없다. -->
			<form id="login_form" method="post" action="${pageContext.request.contextPath}/Login" target="left">
		    <label id="id_input_label">ID : </label><input id="user_id" name="user_id" required><br>
            <label id="pw_input_label">PWD : </label><input id="user_pw" name="user_id" required><br>
			<button id ="login_submit"> 로그인 </button> <button id="cancel_button">취소 </button>
            <!--  로그인은 알겠는데 취소버튼은 왜있는거지 -->
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