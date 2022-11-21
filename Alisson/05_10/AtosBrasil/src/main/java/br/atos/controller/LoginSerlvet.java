package br.atos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.atos.dao.UsuarioDAO;
import br.atos.model.Usuario;

@WebServlet("/login")
public class LoginSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario user = new Usuario();
		
		user.setNome(request.getParameter("nome"));
		user.setSenha(request.getParameter("senha"));
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		if(usuarioDAO.validaLogin(user)) {
			session.setAttribute("nome", user.getNome());
			dispatcher = request.getRequestDispatcher("index.jsp");
		}else {
			request.setAttribute("statusDispacher", "falha");
			dispatcher = request.getRequestDispatcher("login.jsp");
			
		}
		dispatcher.forward(request, response);
	}
}
