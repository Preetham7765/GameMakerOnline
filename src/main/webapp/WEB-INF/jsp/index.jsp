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
  		
  		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  		<style>
  		*{
  			box-sizing : border-box;
  		}
  		html, body {
  			height: 100%;
		}

		.wrapper {
 			width :100%;
  			height: 170vh;
		}
		
		h5 {
			color:#664d00;
		}

		.inner{
			height: 12%;
			background-image: url("images/image1.jpg");
			color: #cc9900; /*#fff13b  */
			background-size: cover;
			margin:auto auto;
		}	
  		#outer{
  			background-image: url("images/background.jpg");
			width: 100%;
			height : 88%;
			background-position: center;
			background-repeat : no-repeat;
  			background-size : cover;
  		}
  		.card-text{
  			font-weight : bold;
  		}
		
		ul.items
		{
		  text-align: center; 
		  list-style-type: none;  
		  width: 400px;
		}
		
		.display-inline
		{
		    display: inline;
		    padding: 10px 40px;     
		}
		
		.button {
		  background-color: Crimson;  
		  border-radius: 5px;
		  color: white;
		  padding: .5em;
		  text-decoration: none;
		}
		
		.button:focus,
		.button:hover {
		  background-color: FireBrick;
		  color: White;
		}
  		
  	</style>
	</head>
	<body>
		<div class="wrapper">
			<header class="inner d-flex justify-content-center align-items-center">
				<div class ="text-align">
					<h1 style = "margin_bottom: 0;">Game Maker</h1>
					<p  style = "text-align:center;">Team 2</p>
				</div>
			</header>
			<div id="outer">
				<div class="d-flex justify-content-center align-items-center ml-3">
					<div class ="text-align mt-3" style = "text-align:center;">
						<p class="card-text" style ="color:#664d00;">Make arcade games using the game Maker
						Upload your score and compete with the world:
						<ul style = "list-style-type:none">
						<li> Make your game </li>
						<li> Save and upload your game to our servers </li>
						<li> OR</li>
						<li> Download and load a game</li>
						<li> Play your game </li>
						<li> Post your score </li>
						<li> Compare yourself to the world on our scoreboard </li>
						</ul>	
									
						
						</p>
						<!--<button type="button" class="btn btn-secondary btn-lg"><a href="${gameMaker}" style = "color: #ffffff">Play</a> </button>-->
						<a href="${gameMaker}" style = "color: #664d00">Play</a> 
					</div>
				</div>
				<div class="mt-3 ml-3"">
					<h5>File Upload:</h5>
					Select a file to upload: <br />
					<form action = "/file/upload" method = "post" enctype = "multipart/form-data">
						<input type = "file" name = "file" size = "50" style ="color:#664d00;"/>
						<input type = "submit" value = "Upload File" />
					</form>
				</div>
				<div class="mt-3 ml-3">
					<h5>File Download:</h5>
					<div class = "mt-5 mb-5">
						<ul class="items">
							<c:forEach items = "${downloadFiles}" var = "file" varStatus = "Status">
								<li class = "display-inline">
									<a href="/file/download?fileName=${file}" class="button js-button" role="button">${file}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
					<!--
					<div class="list-group">
						<c:forEach items = "${downloadFiles}" var = "file" varStatus = "Status">
							<a href="/file/download?fileName=${file}" class="list-group-item list-group-item-action">${file}</a>
						</c:forEach>
					</div>
					-->
				</div>
				<div class="mt-3 ml-3">
					<h5 >Scoreboard</h5>
					<table class="table table-hover table-dark mt-4" style = "width : 25%;">
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
		  				</tbody>
					</table>
				</div>
			</div>
	</body>
<html>
