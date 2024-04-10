<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	HttpSession session1 = request.getSession();

	if(session1.getAttribute("loged") != null)
	{
		response.sendRedirect("http://localhost:8080/quiz/quiz.jsp");
	}	
	String result = (String)request.getAttribute("result");
	String register = (String)request.getAttribute("register");
%>    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/accueil.css">
    <title>Quiz</title>
</head>
<body>
    <header>
        <a href="" class="title">Quiz</a>
        <div class="navigator">
            <div class="navigator-items">
                <button id="inscription">S'inscrire</button>
                <button id="connexion">Connexion</button>
            </div>
        </div>
    </header>
    
    <% if(result != null && result.equals("inconnu")) { %>
    <div class="content">
        <div class="content-item">
            <h1>Echec d'authentification</h1>
            <div class="context">
                <p>Votre login est incorrect!!!! </p><br>
                <a href="http://localhost:8080/quiz/accueil.jsp">Retour</a>
            </div>
        </div>
    </div>
    <% }else if( result != null && result.equals("incorrect")){ %>
    <div class="content">
        <div class="content-item">
            <h1>Echec d'authentification</h1>
            <div class="context">
                <p>Votre mot de passe est incorrect!!!! </p><br>
                <a href="http://localhost:8080/quiz/accueil.jsp">Retour</a>
            </div>
        </div>
    </div>
    <% }else if( register != null && register.equals("equals")){ %>
    <div class="content">
        <div class="content-item">
            <h1>Echec d'inscription</h1>
            <div class="context">
                <p>Le login que vous entrez est déjà utiliser!!!! </p><br>
                <a href="http://localhost:8080/quiz/accueil.jsp">Retour</a>
            </div>
        </div>
    </div>
    <% }else{ %>

    <div class="content">
        <div class="content-item">
            <h1>Bienvenue</h1>
            <div class="context">
                <p>Cette site permet d'augmenter votre connaissance générale... </p><br>
                <a href="">Voir plus...</a>
            </div>
        </div>
    </div>

    <div class="connexion">
        <div class="form_connexion">
            <h1>Connection</h1>
            <form action="http://localhost:8080/quiz/Authentified" method="post">
                <label for="login">Utilisateur</label><br><input type="text" name="login" id="login" class="enter" /><br>
                <label for="passwd">Mot de passe</label><br><input type="password" name="passwd" class="enter" id="passwd"/><br>
                <input type="submit" value="Se connecter" class="submit"/>
            </form>
        </div>
    </div>

    <div class="inscription">
        <div class="form_inscription">
            <h1>Inscription</h1>
            <form action="http://localhost:8080/quiz/Register" method="post">
                <label for="login1">Utilisateur</label><br><input type="text" name="login1" id="login1" class="enter" /><br>
                <label for="passwd1">Mot de passe</label><br><input type="password" name="passwd1" class="enter" id="passwd1"/><br>
                <label for="passwd2">Retaper le mot de passse</label><br><input type="password" name="passwd2" class="enter" id="passwd2" /><br>
                <input type="submit" value="S'inscrire" class="submit"/>
            </form>
        </div>
    </div>
    <% } %>

    <script src="./js/accueil.js"></script>
</body>
</html>