<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: 陈浩--%>
<%--  Date: 2024/3/11--%>
<%--  Time: 18:12--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@include file="header.jsp"%>
This is my register JSP page.<br>
<form action="register" method="post">
    <div>
        <label for="id">id:</label>
        <input type="text" id="id" name="id" required>
    </div>
    <div>
        <label for="username">username:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="password">password:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <label for="email">email:</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div>
        <label for="birthday">birthday:</label>
        <input type="text" id="birthday" name="birthday" required>
    </div>
    <div>
        <%--@declare id="gender"--%><label for="gender">gender:</label>
        <input type="radio" id="male" name="gender" value="male">
        <label for="male">Male</label><br>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female">Female</label><br>
    </div>
    <div>
        <input type="submit" value="Register">
    </div>
</form>
<%@include file="footer.jsp"%>