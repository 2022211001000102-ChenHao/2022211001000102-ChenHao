<%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2024/3/31
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
Login<br>
<form action="login" method="post">
    <div>
        <label for="username">username:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="password">password:</label>
        <input type="password" id="password" name="password" required>
    </div>

    <div>
        <input type="submit" value="login">
    </div>
</form>
<%@include file="footer.jsp"%>