package br.com.loginapp.controller;
import br.com.loginapp.controller.UsuarioController;
import br.com.loginapp.controller.AbstractController;
import br.com.loginapp.dao.UsuarioDAO;
import br.com.loginapp.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
@ManagedBean
public class LoginController extends AbstractController {

    @ManagedProperty(value = UsuarioController.INJECTION_NAME)
    private UsuarioController usuarioController;

    private String dsEmail;
    private String dsSenha;

    public void setUsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    private Usuario isValidLogin(String dsEmail, String dsSenha) {
         Usuario user;
         
        if(isEmail(dsEmail)){
            user = new UsuarioDAO().findByEmail(dsEmail);
        }else{
            user = new UsuarioDAO().findByNome(dsEmail);
        }
        
        if (user == null || !dsSenha.equals(user.getDsSenha())) {
            return null;
        }
        return user;
    }
    
    private boolean isEmail(String value){
        return value.contains("@");
    }

    public String entrar() {
        Usuario user = isValidLogin(dsEmail, dsSenha);

        if (user != null) {
            usuarioController.setUser(user);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.getSession().setAttribute("user", user);
            return "index.xhtml";
        }
        displayErrorMessage("Verifique seu email/senha");
        return null;
    }

}