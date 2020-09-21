<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>ToDo for ${name}</title>
<link href="webjars/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class = "container">
<caption><h1>Your ToDos are :</h1></caption>
<table class="table table-striped" >

    <thead>
        <tr>
            <td>Description</td>
            <td>Target Date</td>
            <td>Is it done?</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${todos}" var = "todo">       <!--JSTL for loop-->
        <tr>
               <td>${todo.desc}</td>
               <td>${todo.targetDate}</td>
               <td>${todo.done}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<div>
<A class= "button" href = "add-todo">Add a ToDo </A>
</div>
<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</div>
</body>
</html>