<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<h3> Ajax Gson Test</h3>
<input type="button" value="text결과" id="ajaxBtn">
<input type="button" value="json결과" id="jsonBtn">

<input type="button" value="DTO결과" id="dtoBtn">
<input type="button" value="List결과" id="listBtn">
<input type="button" value="Map결과" id="mapBtn">

<input type="button" value="textJson결과" id="textJsonBtn">

<hr>
<div id="display"></div>


<script>
const baseURL = `${pageContext.request.contextPath}` //서버에서 EL로 처리되어 문자열로 온다.
document.getElementById("ajaxBtn").addEventListener("click",async()=>{
    try{
        const response = await fetch(`${"${baseURL}"}/ajax`,{
        method:"POST",
        body:new URLSearchParams({
            key:"text"
        })
    });

    if(!response.ok){
        throw new Error("error 발생"+response.status);
    }
    const result = await response.text(); //text()는 비동기처리이므로 await를 붙여야 한다.
    const display = document.getElementById("display").innerHTML = result;
    }catch(e){
        console.log(e);
        document.getElementById("display").innerHTML = e;
    }
});

document.getElementById("jsonBtn").addEventListener("click",async()=>{
    try{
        const response = await fetch(`${"${baseURL}"}/ajax`,{
        method:"POST",
        body:new URLSearchParams({
            key:"json"
        })
    });

    if(!response.ok){
        throw new Error("error 발생"+response.status);
    }
    const result = await response.json(); //text()는 비동기처리이므로 await를 붙여야 한다.
    let str = ""; // Initialize str to accumulate checkbox inputs
    result.forEach((item)=>{
        str+="<input type = 'checkbox' name = 'menu' value = "+item+">"+item+"<br>";
    })
    
    
    const display = document.getElementById("display").innerHTML = str;
    }catch(e){
        console.log(e);
        document.getElementById("display").innerHTML = e;
    }
});

document.getElementById("dtoBtn").addEventListener("click",async()=>{
    try{
        const response = await fetch(`${"${baseURL}"}/ajax`,{
        method:"POST",
        body:new URLSearchParams({
            key:"dto"
        })
    });

    if(!response.ok){
        throw new Error("error 발생"+response.status);
    }
    const result = await response.json(); //text()는 비동기처리이므로 await를 붙여야 한다.
    let str = "";
    //document.getElementById("display").innerHTML = result.name+"<br>"+result.age+"<br>"+result.addr+"<br>";
    
    str += "Name: " + result.name + "<br>Age: " + result.age + "<br>Address: " + result.addr + "<br>"; // Accumulate result details
    const display = document.getElementById("display").innerHTML = str; // Corrected to use str
    }catch(e){
        console.log(e);
        document.getElementById("display").innerHTML = e;
    }
});

document.getElementById("listBtn").addEventListener("click",async()=>{
    try{
        const response = await fetch(`${"${baseURL}"}/ajax`,{
        method:"POST",
        body:new URLSearchParams({
            key:"list"
        })
    });

    if(!response.ok){
        throw new Error("error 발생"+response.status);
    }
    const result = await response.json(); //text()는 비동기처리이므로 await를 붙여야 한다.
    let str = ""; // Initialize str to accumulate checkbox inputs
    result.forEach((item)=>{
        str+=item.id+" ";
        str+=item.name+" ";
        str+=item.age+" ";
        str+=item.addr+" ";
        str+="<br>";
    });
    const display = document.getElementById("display").innerHTML = str; // Corrected to use str
    }catch(e){
        console.log(e);
        document.getElementById("display").innerHTML = e;
    }
});

document.getElementById("mapBtn").addEventListener("click",async()=>{
    try{
        const response = await fetch(`${"${baseURL}"}/ajax`,{
        method:"POST",
        body:new URLSearchParams({
            key:"map"
        })
    });

    if(!response.ok){
        throw new Error("error 발생"+response.status);
    }
    const result = await response.json(); //text()는 비동기처리이므로 await를 붙여야 한다.
    let str = ""; // Initialize str to accumulate checkbox inputs
    str+=result.message+"<br>";
    str+=result.pageNo+"<br>";
    str+=result.dto.name+"<br>";
    str+=result.dto.age+"<br><hr>";
    let list = result.memberList;
    Object.values(list).forEach((item)=>{
        str+=item.id+" ";
        str+=item.name+" ";
        str+=item.age+" ";
        str+=item.addr+" ";
        str+="<br>";
    });
    
    

    const display = document.getElementById("display").innerHTML = str; // Corrected to use str
    }catch(e){
        console.log(e);
        document.getElementById("display").innerHTML = e;
    }
});



</script>



</body>
</html>













