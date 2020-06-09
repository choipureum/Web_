<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 var json = {"a":1, "b":2, "c":"Cherry","d":true,"e":["1","2","3"]};
 
console.log(json.e);
console.log(json.c);

//json객체 ->json텍스트
var jsonText = JSON.stringify(json); //마샬링
console.log(jsonText);

// JSON텍스트 -> JSON객체 
var jsonObject = JSON.parse(jsonText);
console.log(jsonObject);

</script>
</head>
<body>
	
</body>
</html>
