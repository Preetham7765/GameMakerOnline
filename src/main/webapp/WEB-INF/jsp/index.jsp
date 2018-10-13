<!DOCTYPE html>
<hmtl>

<body>
	<h2>Hello ${name}</h2>

	 <p>Get your Game Maker <a href="${gameMaker}">here</a></p>
	 
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
