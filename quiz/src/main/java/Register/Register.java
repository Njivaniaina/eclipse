package Register;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login1");
	    String passwd = request.getParameter("passwd1");
	    String passwd1 = request.getParameter("passwd2");
	    boolean exist = false;
	    
	    try 
	    {
	      FileReader file = new FileReader("/home/njiva/eclipse-workspace/quiz/src/main/webapp/conf/login.csv");
	      BufferedReader filename = new BufferedReader(file);
	      String line = "";

	      while ((line=filename.readLine()) != null) 
	      {
	        String[] words = line.split(",");
	        if(words[0].equals(login))
	        {
	        	exist=true;
	        }
	      }
	      
	      file.close();
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    if(exist) {
	    	request.setAttribute("register", "equals");
		    request.getRequestDispatcher("accueil.jsp").forward(request, response);
	    }
	    else if(passwd.equals(passwd1) && login != null) 
	    {
			FileWriter fileWrite = new FileWriter("/home/njiva/eclipse-workspace/quiz/src/main/webapp/conf/login.csv", true);
			fileWrite.write(login+","+passwd+"\n");
		    fileWrite.close();
		    
		    HttpSession session = request.getSession();
		    session.setAttribute("loged", "yes");
		    response.sendRedirect("http://localhost:8080/quiz/quiz.jsp");
	    }
	}

}
