<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String snm[][]={{"Rama","101","BBSR","400"},{"Hari","102","Cuttack","500"},{"Gopal","103","Delhi","600"}};
		        
%>
<Table border="3">
<Tr>
<Th>Name</Th>
<Th>Roll no</Th>
<Th>Address</Th>
<Th>Mark</Th>
</Tr>
<%
for(int i=0;i<3;i++)
{
%>
<Tr>
<%
for(int j=0;j<4;j++)
{
%>
<Td><%=snm[i][j] %></Td>
 <%
}
 %>
</Tr>
 <%
}
 %>
</Table>	        
</body>
</html>