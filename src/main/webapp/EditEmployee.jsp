<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <% 
    AdminBean ab=(AdminBean)session.getAttribute("abean");
    EmployeeBean eb=(EmployeeBean)request.getAttribute("ebean");
    out.println("page belongs to Admin :"+ab.getfName()+"<br>");
    
    %>
    <form action="update" method="post">
    
       <input type="hidden" name="eid" value=<%= eb.geteId()%> >
       
       
       BasicSalary:<input type="text" name="bsal" value=<%=eb.getbSal()%>>
       
       <input type="submit" value="UploadEmployee"/>
    
    </form>

</body>

</html>