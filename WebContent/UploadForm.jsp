<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload a Picture</title>
</head>
<body>
<p>
	<stripes:errors></stripes:errors></p>
	<stripes:form action="/UploadPicture.action">
		<stripes:text name="name"></stripes:text>
		<stripes:file name="pic" />
		<stripes:submit name="upload"></stripes:submit>
	</stripes:form>
</body>
</html>