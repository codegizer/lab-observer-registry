<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head> 
	<title>Home</title>
    <script>
    function docEvntExecute(frm,key,evntTyp)
    {
        var cboEvnt = frm["evntTyp_"+key];

        frm.docKey.value = key;
        frm.evntTyp.value = cboEvnt.options[cboEvnt.selectedIndex].value;

        frm.submit();
    }
    </script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P><b>도큐먼트 목록</b></P>
<form action="./subjectEvtExec" method="post">
<!--Subject 옵저버 연계처리를 위한 Form 값-->
<input type="hidden" name="docKey"> 
<input type="hidden" name="evntTyp">
<!-- Subject 엔티티 목록(ComboBox)-->
<c:forEach items="${docList}" var="doc">
<li>
	${doc.title}(${doc.taskId}) 
    <select name="evntTyp_${doc.key}">
        <option value="SAVE">SAVE</option>
        <option value="DELETE">DELETE</option>
        <option value="EDIT">EDIT</option>
        <option value="ROLLBACK">ROLLBACK</option>
        <option value="APPROVE">APPROVE</option>
    </select>
    <input type="button" value="이벤트발생" onclick="docEvntExecute(this.form,'${doc.key}',this.form.evntTyp)" />
</li>
</c:forEach>
</form>    
<hr/>    
    
<P><b>새로운 도큐먼트 추가</b></P>
<form action="./documentAdd" method="post">    
    제목:<input type="text" name="title"/>
    연계업무:
	<!--옵저버 목록(ComboBox)-->
    <select name="taskId">
        <c:forEach items="${taskList}" var="registry">
            <option value="${registry.TASKID}">${registry.TASKID}</option>
        </c:forEach>    
    </select>
	<input type="submit" value="전송">
</form>

<hr/>
    
<P><b>서비스 레지스트리 옵저버등록 현황</b> </P>
<c:forEach items="${taskList}" var="registry">
<li>
	${registry.TASKID} ===> ${registry.CLASS_NAME}
</li>
</c:forEach>
</body>
</html>
