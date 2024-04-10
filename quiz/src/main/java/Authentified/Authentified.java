package Authentified;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class Authentified
 */
public class Authentified extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentified() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/quiz";
	    String user = "quiz";
	    String password = "123456"; 
	    
	    System.out.println("Hello!!!!");
	    
	    try
	    {
	    	Connection connexion = DriverManager.getConnection(url, user, password);
	    	
	    	Statement stat  = (Statement) connexion.createStatement();
	    	String req = "SELECT * FROM users";
	    	ResultSet result = stat.executeQuery(req);
	    	
	    	while(result.next())
	    	{
	    		System.out.println("ID :"+result.getInt("id"));
	    		System.out.println("User :"+result.getInt("login"));
	    		System.out.println("ID :"+result.getInt("passwd"));
	    	}
	    	
	    	connexion.close();
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
	    
	    System.out.println("Fin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
	    String passwd = request.getParameter("passwd");
	    String result = "";
		
		try 
	    {
	      FileReader file = new FileReader("/home/njiva/eclipse-workspace/quiz/src/main/webapp/conf/login.csv");
	      BufferedReader filename = new BufferedReader(file);
	      String line = "";

	      while ((line=filename.readLine()) != null) 
	      {
	        String[] words = line.split(",");
	        if(words.length > 1)
	        {
	        	if(login.equals(words[0]))
	        	{	
	        		if(passwd.equals(words[1].trim()))
	        		{
	        			HttpSession session = request.getSession();
	        		    session.setAttribute("loged", "yes");
	        		}
	        		else
	        		{
	        			result = "incorrect";
	        		}
	        	}
	        }
	      }
	      if(result == "")
	      {
	    	  result = "inconnu";
	      }
	      request.setAttribute("result", result);
	      request.getRequestDispatcher("accueil.jsp").forward(request, response);
	      
	      file.close();
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	
	

}
