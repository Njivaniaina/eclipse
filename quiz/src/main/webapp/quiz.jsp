<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession session2 = request.getSession();

	if(session2.getAttribute("loged") == null)
	{
		response.sendRedirect("http://localhost:8080/quiz/accueil.jsp");
	}	
%>    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/quiz.css">
    <title>Quiz</title>
</head>
<body>
    <header>
        <a href="" class="title">Quiz</a>
        <div class="navigator">
            <div class="navigator-items">
                <button id="accueil">Accueil</button>
                <button id="start">Sarter</button>
                <button id="propos">A propos</button>
                <a href="http://localhost:8080/quiz/Quiz?quit=yes" class="deconnection"><button id="deconnection">Se deconnecter</button></a>
            </div>
        </div>
    </header>

    <div class="accueil">
        <div class="content-item">
            <h1>Bienvenue</h1>
            <div class="context">
                <p>Cette site permet d'augmenter votre connaissance générale...</p><br>
                <a id="propos_vers">Voir plus...</a>
            </div>
        </div>
    </div>

    <div class="content">
        <div class="content-item">
            <h1>A propos</h1>
            <div class="context">
                <p>Cette site permet d'augmenter votre connaissance générale...</p><br>
                <p>Les questions poser sont tous des questions de la connaissance générale qui n'est pas spécifier à une domaine.</p>
            </div>
        </div>
    </div>

    <div class="start">
        <div class="content-item">
            <h1>Commencer de repondre</h1>
            <div class="context">
            	<p>Vous serez rediriger vers la page de question si vous appuillez sur le bouton commencer.</p>
            	<a href="http://localhost:8080/quiz/Generate"><button id="commencer_bouton">Commencer</button></a>
            </div>
        </div>
    </div>
	
    <script src="./js/quiz.js"></script>
</body>
</html>