<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<hmtl>
	<head>
		<title>Game Maker</title>
  		<meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  		<style>
  		html, body {
  			height: 100%;
		}

		.wrapper {
  			display: flex;
  			flex-direction: column;
 			width :100%
  			height: 100%;
		}
  		.jumbotron {
			background-image: url("images/image1.jpg");
			color: #fff13b;
			background-size: cover;
		}
		header{
			position: fixed;
			height: 2%;
		}	
  		#outer{
  			position:fixed;
  			background-image: url("images/background.jpg");
			background-size: cover;
			width: 100%;
			height : 90%;
  			background-repeat: no-repeat;
  			flex-grow: 1;
  		}
  		</style>
	</head>
	<body>
		<div class="wrapper">
		<header class="jumbotron text-center" style="margin-bottom:0">
			<h1>Game Maker</h1>
  			<p>Team 2</p> 
		</header>	
		<div id= "outer">
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
			      		<td>${entry.gameName}</td>
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
     
     	<form action = "/file/download" method = "get">
     		<c:forEach items = "${downloadFiles}" var = "file" varStatus = "Status">
     			<input TYPE=radio name=fileName VALUE=${file}> ${file} <BR>
			</c:forEach>
			<input type = "submit" value = "Download" />
		</form>    
		
		</div>
		</div>
		
	</body>
<html>
