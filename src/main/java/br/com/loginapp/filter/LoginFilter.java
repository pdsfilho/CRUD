package br.com.loginapp.filter;

import br.com.loginapp.model.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebFilter(urlPatterns = "/pages/*",servletNames = "{Faces Servlet}")
public class LoginFilter extends AbstractFilter implements Filter {


    public void init(FilterConfig fc) throws ServletException {

    }
    
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;
        
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        if (session.isNew() || user == null) {
            try {
				doLogin(sr, sr1, request);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }else{
             fc.doFilter(sr, sr1); 
        }
    }

    public void destroy() {
        throw new UnsupportedOperationException("Não suportado ainda."); 
    }

}
