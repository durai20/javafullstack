package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.LoginModels;
import java.io.IOException;
//import java.io.PrintWriter;

import controller.LoginController;
//import controllers.LoginController;


/**
 * Servlet implementation class loginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		    LoginModels slm=new LoginModels();
			slm.setName(request.getParameter("username"));
			slm.setPass(request.getParameter("password"));
			LoginController slc= new LoginController(slm);
			if(slc.toGet()) {
				System.out.println("jdr");
			     RequestDispatcher dispatcher = request.getRequestDispatcher("SignupPage.html");
		            dispatcher.forward(request, response);
		       
		        } else {
		        	
		            response.sendRedirect("index.html");
		        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
