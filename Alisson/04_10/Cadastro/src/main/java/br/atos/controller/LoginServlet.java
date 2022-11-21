package br.atos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.atos.dataBase.LoginDAO;
import br.atos.model.EntidadeLogin;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		LoginDAO dao = new LoginDAO();
		
		String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	EntidadeLogin login = new EntidadeLogin();
    	login.setUsername(username);
    	login.setPassword(password);
    	
    	if(dao.salvarUsuario(login)) {
    		response.sendRedirect("loginSucesso.jsp");
    	}else {
    		response.sendRedirect("loginInvaldo.jsp");
    	}
    	
	}

}
