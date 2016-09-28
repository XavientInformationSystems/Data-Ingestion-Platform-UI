<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Data Ingest UI</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dataIngest.css"> </link>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/dataIngest.js"></script>
</head>
<body bgcolor="#3B5998">
	<div align="center">
		<h1 align="center">DATA INGESTION PLATFORM</h1>
		<h2 align="center">STORM|SPARK-STREAMING|FLINK|APEX</h2>
		<br /> <br /> <br />
		<div>
	      <span id="streamingPlatformError" class="error"></span>
	    </div>
		<h2 align="center">Choose Streaming Platform</h2>
			<input type="radio" name="streamingPlatform" value="STORM" checked ><span style="color: white;" >STORM</span> &nbsp;&nbsp;
			<input type="radio" name="streamingPlatform" value="FLINK" disabled /><span style="color: white;" >FLINK</span> &nbsp;&nbsp;
			<input type="radio" name="streamingPlatform" value="APEX" disabled /><span style="color: white;" >APEX</span> &nbsp;&nbsp;
			<input type="radio" name="streamingPlatform" value="SPARK" disabled /><span style="color: white;" >SPARK</span> 
			<br> <br>
		<form action="ingestText" method="post" id="ingestTextForm">
			<h2>Enter JSON/XML Message</h2>
			<br>
			<div>
	           <span id="textDataError" class="error"></span>
	        </div>
			<textarea rows="10" cols="150" name="data" id="textData"> </textarea>
			<br> <br> 
			<button class="data-submit a" type="button" upload-data="ingestTextForm">Submit</button>
		</form>

		<br /> <br /> <br />
		<h2>Upload File</h2>
		<br />
		<form action="ingestFile" method="post"
			enctype="multipart/form-data" id="ingestFileForm">
			<div>
	           <span id="fileDataError" class="error"></span>
	        </div>
			<input type="file" id="fileData" name="file" size="50" class="a"
				id="uploadedFile" /> 
			<br> <br> 
			<button class="data-submit a" type="button" upload-data="ingestFileForm">Upload File</button>
			<!-- <input type="submit" id="upload" class
				value="Upload File" class="a" /> -->
		</form>
	</div>
</body>
</html>