<%-- 
    Document   : schedule
    Created on : 16 Jun 2026, 2:59:23 PM
    Author     : MP2-4
--%>

<%@ page import="java.util.*" %>
<%@ page import="com.model.SessionBean" %>

<%@ include file="header.html" %>

<html>
<head>
<title>Schedule Dashboard</title>
</head>

<body>

<h2>Schedule dashboard</h2>

<table border="1">

<tr>
    <th>ID</th>
    <th>Student Name</th>
    <th>Branch</th>
    <th>Lesson Type</th>
    <th>Status</th>
</tr>


<%
List<SessionBean> sessionList =
(List<SessionBean>)request.getAttribute("sessionList");

for(SessionBean s : sessionList){
%>

<tr>
    <td><%= s.getSession_id() %></td>
    <td><%= s.getStudent_name() %></td>
    <td><%= s.getBranch_location() %></td>
    <td><%= s.getLesson_type() %></td>
    <td><%= s.getStatus() %></td>
</tr>

<%
}
%>



</table>

</body>
</html>

<%@ include file="footer.jsp" %>

