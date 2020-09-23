<html>
<head>
<title>First WebPage</title>
<link href="webjars/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class= "container">
  Add ToDo Page for ${name}
    <form method = "post">
    <fieldset class= "form-group">
        <label><B>Description</B></label>
        <input name = "desc" type = "text" class= "form-control"/>
        <button type = "submit" class="btn btn-success">Add</button>
    </fieldset>
    </form>
</div>
<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>