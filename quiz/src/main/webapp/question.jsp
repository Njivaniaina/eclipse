<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%
	HttpSession session2 = request.getSession();
	if(session2.getAttribute("loged") == null)
	{
		response.sendRedirect("http://localhost:8080/quiz/accueil.jsp");
	}
	ArrayList<String[]> data = (ArrayList<String[]>)request.getAttribute("data");
	int note = (int)request.getAttribute("note");
%>    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/question.css">
    <title>Quiz</title>
</head>
<body>
    <header>
        <a href="" class="title">Quiz</a>
        <div class="navigator">
            <div class="navigator-items">
                <a href="http://localhost:8080/quiz/quiz.jsp" class="deconnection"><button id="retour">Retour</button></a>
            </div>
        </div>
    </header>

	<% if(note == -1) { %>
    	<div class="content">
	    	<div class="content-item">
	    		<h1>Question</h1>
		    	<div class="context">
		    		<form action="http://localhost:8080/quiz/Generate" method="post">
				    	<% if(data != null) { %>
				    		<% for(String[] s : data) { %>
				    			<h3><%= s[0] %> - <%= s[1] %></h3><br>
				    			<% 
				    				int n = (int)(Math.random()*(1-0+1)+0);
				    				if( n == 1 ) {
				    			%>
					    			<input type="radio" name=<%=s[0]%> value="1" /><%=s[2]%>
					    			<input type="radio" name=<%=s[0]%> value="0" /><%= s[3]%>
					    			<br><br><br>
				    			<% } else { %>
					    			<input type="radio" name=<%=s[0]%> value="0" /><%=s[3]%>
					    			<input type="radio" name=<%=s[0]%> value="1" /><%= s[2]%>
					    			<br><br><br>
				    			<% } %>
				    		<% } %>
				    	<% }else{ %>
				    		<h1>La tableau est null!!!</h1>
				    	<% } %>
			    		<input type="submit" value="Envoyer" class="envoyer"/>
			    	</form>
		    	</div>
	    	</div>
    	</div>
    <% } else{ %>
    	<div class="content">
	    	<div class="content-item">
	    		<h1>Votre note</h1>
		    	<div class="context">
		    		<h1><%= note %>/7</h1>
		    	</div>
	    	</div>
    	</div>
    <% } %>
</body>
</html>