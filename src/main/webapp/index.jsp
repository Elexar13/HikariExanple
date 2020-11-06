<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/6/20
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Page</title>
    <style>
      body{
        font-family: Monserrat, sans-serif;
        margin-left: auto;
        margin-right: auto;
        text-align: center;
        width: 30%;
      }
      input{
        margin: 10px 0;
        padding: 10px;
        border: unset;
        border-bottom: 2px solid #e3e3e3;
        outline: none;
      }
      table {
        background: #e3e3e3;
        width: 100%;
        text-align: center;
      }
      th {
        font-weight: normal;
        font-size: 14px;
        color: #339;
        padding: 10px 12px;
        background: white;
      }
      td {
        color: #669;
        border-top: 1px solid white;
        padding: 10px 12px;
        background: rgba(51, 51, 153, .2);
        transition: .3s;
      }
      tr:hover td {
        background: rgba(51, 51, 153, .1);
      }
      .butt{
        padding: 10px;
        background: #e3e3e3;
        border: unset;
        cursor: pointer;
      }
    </style>
  </head>
  <body>
  <jsp:useBean id = "driverBean" class = "beans.DriverBean" scope="request"/>
      <h1>All drivers</h1>
  <table>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Truck id</th>
    </tr>
    <c:forEach items="${driverBean.drivers}" var="driver">
      <tr>
        <td>${driver.id}</td>
        <td>${driver.name}</td>
        <td>${driver.truckId}</td>
      </tr>
    </c:forEach>
  </table>

  <form method="post" action="${driverBean.addDriver(driverBean.driver)}" >
      <input type="text" name="name" value="${driverBean.driver.name}" placeholder="Enter name">
      <input type="text" name="truck_id" value="${driverBean.driver.truckId}" placeholder="Enter truck">
      <input class="butt" type="submit" value="Add driver">
  </form>
  </body>
</html>
