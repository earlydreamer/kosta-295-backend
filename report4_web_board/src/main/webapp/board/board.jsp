<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="ko-kr">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>

    <body>

        <style>
            #board_table, th, td{
                border: 1px solid gray;
                border-collapse: collapse;
            }

            #board_table th {
                background-color: orange;
                
            }

            #board_table td {
                text-align: center;
            }
        </style>

        board list
        <table id="board_table">
            <tr>
                <th>no.</th>
                <th>subject</th>
                <th>content</th>
            </tr>
			<tr>
			<td>
			d</td>
			<td>
			d</td>
			<td>
			d</td>
			</tr>
        </table>
        <form>
            <label id="number_input_label">번호</label><input id="number_input" required><br>
            <label id="subject_input_label">제목</label><input id="subject_input" required><br>
            <label id="content_input_label">본문</label><input id="content_input" required><br>
            <button id="submit_board" type="button">전송</button>
        </form>

        <script>
            let boardDto = []; // Servlet으로부터 받아온 boardDto를 여기다 담는다
            //for loop를 돌면서 'board_table' 테이블에 한줄씩 BoardDto의 값을 출력한다.
            // 출력에 필요한 값은 boardDto의 no, subject, content
            // document.write 말고 board_table.innerHTML이나 board_table.appendChild을 사용한다.
            //innerHTML을 사용하면 기존의 HTML을 덮어쓰게 된다.
            //innerHtml이 아닌 appendChild를 사용하면 기존의 HTML을 덮어쓰지 않고 추가할 수 있다.
            // 일단 여기까지를 함수화해서 페이지에 진입할 때 refresh 되도록 한다.


        </script>
    </body>

    </html>