package br.com.loginapp.filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AbstractFilter {
	public AbstractFilter() {
		
	}
	//Redirecionar para página de Login.
	protected void doLogin(ServletRequest request, ServletResponse response, HttpServletRequest req) throws ServletException, Exception {
		RequestDispatcher dispatcher = req.getRequestDispatcher("login");
		dispatcher.forward(request, response);
	}
	//Redirecionar para a página de acesso negado.
	protected void acessoNegado(ServletRequest request, ServletResponse response, HttpServletRequest req) throws ServletException, Exception {
		RequestDispatcher dispatcher = req.getRequestDispatcher("acessoNegado");
		dispatcher.forward(request, response);
	}
}
