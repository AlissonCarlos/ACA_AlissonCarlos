package br.atos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.atos.dataBase.LoginDAO;
import br.atos.model.EntidadeLogin;

@WebServlet("/telaCadastro")
public class CadasatrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadasatrarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String confirmar = request.getParameter("confirmarPassword");
    	
    	if(password.equals(confirmar)) {
    		LoginDAO dao = new LoginDAO();
    		
        	EntidadeLogin login = new EntidadeLogin();
        	login.setUsername(username);
        	login.setPassword(password);
        	
        	if(dao.salvarUsuario(login)) {
        		response.sendRedirect(request.getContextPath() + "/login.jsp");
        	}
    	}else {
    		response.sendRedirect(request.getContextPath() + "/cadastroErro.jsp");
    	}
    	
	}

}
