package Generate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Servlet implementation class Generate
 */
public class Generate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Generate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
	    {
	      FileReader file = new FileReader("/home/njiva/eclipse-workspace/quiz/src/main/webapp/conf/question.csv");
	      BufferedReader filename = new BufferedReader(file);
	      String line = "";
	      ArrayList<String[]> data = new ArrayList<String[]>();

	      while ((line=filename.readLine()) != null) 
	      {
	        String[] words = line.split(","); 
	        if(words.length > 1)
	        {
	        	data.add(words);
	        }
	      }
	     
	      request.setAttribute("data", data);
	      request.setAttribute("note", -1);
	      
	      file.close();
	      request.getRequestDispatcher("question.jsp").forward(request, response);
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
	    {
	      FileReader file = new FileReader("/home/njiva/eclipse-workspace/quiz/src/main/webapp/conf/question.csv");
	      BufferedReader filename = new BufferedReader(file);
	      String line = "";
	      ArrayList<String[]> data = new ArrayList<String[]>();
	      int note=0;
	      HttpSession session2 = request.getSession();
	      List<Integer> order = (List<Integer>)session2.getAttribute("order");

	      while ((line=filename.readLine()) != null) 
	      {
	        String[] words = line.split(","); 
	        if(words.length > 1)
	        {
	        	data.add(words);
	        }
	      }
	      
	      for(String[] s : data) 
	      {
	    	  String var = request.getParameter(s[0]);
	    	  if(var!=null) {
	    		  if(var.equals("1")) {
	    			  note++;
	    		  }
	    	  }
	    	  else
	    	  {
	    		  System.out.println("la variable var est null");
	    	  }
	    	  System.out.println("numero: "+s[0]);
	      }
	      System.out.println("Le note est : "+note);
	      request.setAttribute("note", note);
	      request.getRequestDispatcher("question.jsp").forward(request, response);
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}

}
