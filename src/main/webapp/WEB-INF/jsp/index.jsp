<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<hmtl>
<<<<<<< HEAD
	<head>
		<title>Game Maker</title>
  		<meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	</head>
	<body>
		<p>Get your Game Maker <a href="${gameMaker}">here</a></p>
		<div>
			<table class="table table-hover table-dark">
		  	<thead>
		    	<tr>
		      		<th scope="col">Player Name</th>
		      		<th scope="col">Game</th>
		      		<th scope="col">Score</th>
		    	</tr>
		  </thead>
		  <tbody>
		  		<c:forEach items = "${PlayerScores}" var = "entry" varStatus = "Status"> 
			    	<tr>
			      		<td>${entry.userName}</td>
			      		<td>${entry.game}</td>
			      		<td>${entry.score}</td>
			    	</tr>
		    	</c:forEach>    
		    <!--
		    <tr>
		      <td>Jacob</td>
		      <td>Thornton</td>
		      <td>@fat</td>
		    </tr>
		    <tr>
		      <td colspan="2">Larry the Bird</td>
		      <td>@twitter</td>
		    </tr>
		    -->
		  </tbody>
		</table>
		</div>
		
	<h3>File Upload:</h3>
      Select a file to upload: <br />
      <form action = "/file/upload" method = "post" enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "50" />
         <br />
         <input type = "submit" value = "Upload File" />
      </form>
      
     <h3>File Download:</h3>
      <form action = "/file/download" method = "get" enctype = "multipart/form-data">
         <input type="text" name="filename" />
         <br />
		<input type="submit" value = "Download"/>
      </form>
	</body>
<hmtl>
