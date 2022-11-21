package br.atos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.atos.dao.UsuarioDAO;
import br.atos.model.Usuario;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrationServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario user = new Usuario();
		
		user.setNome(request.getParameter("nome"));
		user.setSenha(request.getParameter("senha"));
		user.setEmail(request.getParameter("email"));
		user.setTelefone(request.getParameter("telefone"));
		
		RequestDispatcher dispatcher = null;
		
		PrintWriter saida = response.getWriter();
		
		dispatcher = request.getRequestDispatcher("registration.jsp");//Direcionando para a JSP registration.jsp
		
		if(dao.salvarUsuario(user)) {
			//saida.print("Registrado com Sucesso");
			request.setAttribute("statusDispacher", "sucesso");// Criação da variavel
		}else {
			request.setAttribute("statusDispacher", "falha");
		}
		
		dispatcher.forward(request, response);
	}

}
