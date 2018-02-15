package br.server.control.action;

/*
 * Document   : UsuarioAction.java
 * Created on : 30/05/2013, 10:25:45
 * Author     : Caio
 */
import br.server.control.action.session.Permissao;
import br.server.control.action.session.SessionUsuario;
import br.server.model.entities.Usuario;
import br.server.model.util.ConexaoUtil;
import br.server.model.util.repository.UsuarioRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.util.DigestUtils;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioAction implements Serializable {

    private Usuario usuario;
    private List<Usuario> usuarios;
    private Permissao permissao;
    private List<Permissao> permissoes;
    private String dsPermissao;
    private String dsSenha;
    private String dsConfirmaSenha;
    private String dsSenhaOriginal;
    private String dsPesquisa;

    public UsuarioAction() {
        this.usuario = new Usuario();
        obterUsuarioEdicao();
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        UsuarioRepository repository = getUsuarioRepository();
        Usuario user = null;
        if (usuario.getNrSequencia() != 0) {
            user = repository.getUsuario(usuario.getNrSequencia());
            usuario.setDsPermissao(user.getDsPermissao());
        }
        if (!getDsSenha().equals(getDsConfirmaSenha())
                || getDsSenha().equals(getDsSenhaOriginal())) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Senha confirmada incorretamente"));
            return;
        }
        if (getDsSenha().length() < 8) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "A senha deve conter no m�nimo 8 caracteres"));
            return;
        }
        usuario.setDtAtualizacao(new Date());
        usuario.setNmUsuarioAtualizacao(context.getExternalContext().getRemoteUser());
        usuario.setDsSenha(DigestUtils.md5DigestAsHex(getDsSenha().getBytes()));
        if (usuario.getNrSequencia() != 0) {
            if (!usuario.getNmUsuario().equalsIgnoreCase(user.getNmUsuario())) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "O nome do usu�rio n�o pode ser alterado"));
                return;
            }
            repository.updateUsuario(usuario);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Usu�rio atualizado com sucesso"));
        } else {
            if (repository.getUsuario(usuario.getNmUsuario()) != null) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Este nome de usu�rio j� existe.\n"
                        + "Entre com outro nome de usu�rio!"));
                return;
            }
            usuario.getDsPermissao().add("ROLE_USUARIO");
            repository.insertUsuario(usuario);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Usu�rio cadastrado com sucesso"));
        }
        setDsSenha(usuario.getDsSenha());
        setDsConfirmaSenha(usuario.getDsSenha());
        setDsSenhaOriginal(usuario.getDsSenha());
    }

    public String alterar() {
        return "/pages/admin/cadasUsuario";
    }

    public void excluir() {
        getUsuarioRepository().deleteUsuario(usuario.getNrSequencia());
        usuarios = null;
        permissoes = null;
    }

    public void addPermissao() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (usuario.getNrSequencia() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Para adicionar permiss�es � necess�rio selecionar um usu�rio"));
            return;
        }
        UsuarioRepository repository = getUsuarioRepository();
        Usuario user = repository.getUsuario(usuario.getNrSequencia());
        usuario.setDsPermissao(user.getDsPermissao());
        if ("Selecione".equalsIgnoreCase(dsPermissao)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Favor selecionar uma permiss�o!"));
            return;
        }
        if (usuario.getDsPermissao().contains(dsPermissao)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Este usu�rio j� possui esta permiss�o"));
            return;
        }
        usuario.setDsSenha(user.getDsSenha());
        usuario.getDsPermissao().add(dsPermissao);
        usuario.setDtAtualizacao(new Date());
        usuario.setNmUsuarioAtualizacao(context.getExternalContext().getRemoteUser());
        repository.updateUsuario(usuario);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Nova permiss�o adicionada ao usu�rio"));
        permissoes = null;
        dsPermissao = null;
    }

    public void excluirPermissao() {
        FacesContext context = FacesContext.getCurrentInstance();
        UsuarioRepository repository = getUsuarioRepository();
        usuario = repository.getUsuario(usuario.getNrSequencia());
        if (usuario.getDsPermissao().size() == 1) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "O usu�rio deve possuir no m�nimo uma permiss�o"));
            return;
        }
        usuario.getDsPermissao().remove(permissao.getDsPermissao());
        usuario.setDtAtualizacao(new Date());
        usuario.setNmUsuarioAtualizacao(context.getExternalContext().getRemoteUser());
        repository.updateUsuario(usuario);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Permiss�o removida do usu�rio"));
        permissoes = null;
    }

    public String pesquisar() {
        usuarios = getUsuarioRepository().getUsuarios(getDsPesquisa());
        return null;
    }

    public void alterarSenha() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        boolean isRoleUsuario = false;
        if (request.isUserInRole("ROLE_ADMINISTRADOR")) {
            if ("".equals(getDsSenha())
                    || "".equals(getDsConfirmaSenha())
                    || !getDsSenha().equals(getDsConfirmaSenha())) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Favor confirme a senha do usu�rio"));
                return;
            }
            if (getDsSenha().length() < 8) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "A senha deve conter no m�nimo 8 caracteres"));
                return;
            }
        } else {
            isRoleUsuario = true;
            if (!usuario.getNmUsuario().equalsIgnoreCase(context.getExternalContext().getRemoteUser())) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Usu�rio sem permiss�o para alterar senha de outros usu�rios"));
                return;
            }
            if ("".equals(getDsSenhaOriginal())) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Favor entre com a senha atual"));
                return;
            }
            if ("".equals(getDsSenha())) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Favor entre com a nova senha"));
                return;
            }
            if ("".equals(getDsConfirmaSenha())) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Favor entre com a senha de confirma��o"));
                return;
            }
            if (!getDsSenha().equals(getDsConfirmaSenha())) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Senha confirmada incorretamente"));
                return;
            }
            if (getDsSenha().length() < 8) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "A senha deve conter no m�nimo 8 caracteres"));
                return;
            }
        }
        UsuarioRepository repository = getUsuarioRepository();
        Usuario user = repository.getUsuario(usuario.getNrSequencia());
        if (isRoleUsuario
                && !DigestUtils.md5DigestAsHex(getDsSenhaOriginal().getBytes()).equals(user.getDsSenha())) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Favor entre com a senha atual"));
            return;
        }
        user.setDsSenha(DigestUtils.md5DigestAsHex(getDsSenha().getBytes()));
        user.setDtAtualizacao(new Date());
        user.setNmUsuarioAtualizacao(context.getExternalContext().getRemoteUser());
        repository.updateUsuario(user);
        setDsSenhaOriginal("");
        setDsSenha("");
        setDsConfirmaSenha("");
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio", "Senha alterada com sucesso"));
    }

    public List<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = getUsuarioRepository().getUsuarios();
        }
        return usuarios;
    }

    public List<Permissao> getPermissoes() {
        if (permissoes == null
                || permissoes.isEmpty()) {
            permissoes = new ArrayList<Permissao>();
            Set<String> dsPermissoes = usuario.getDsPermissao();
            Permissao p;
            for (String str : dsPermissoes) {
                p = new Permissao();
                p.setDsPermissao(str);
                permissoes.add(p);
            }
        }
        return permissoes;
    }

    private void obterUsuarioEdicao() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
        if (sessionMap != null
                && !sessionMap.isEmpty()
                && sessionMap.containsKey("sessionBean")) {
            SessionUsuario sessionUsuario = (SessionUsuario) sessionMap.get("sessionBean");
            if (sessionUsuario != null
                    && sessionUsuario.getNrSeqUsuarioEdicao() != 0) {
                usuario = getUsuarioRepository().getUsuario(sessionUsuario.getNrSeqUsuarioEdicao());
                setDsSenha(usuario.getDsSenha());
                setDsConfirmaSenha(usuario.getDsSenha());
                setDsSenhaOriginal(usuario.getDsSenha());
                sessionUsuario.setNrSeqUsuarioEdicao(0);
                context.getExternalContext().getSessionMap().put("sessionBean", sessionUsuario);
            }
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public String getDsPermissao() {
        return dsPermissao;
    }

    public void setDsPermissao(String dsPermissao) {
        this.dsPermissao = dsPermissao;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public String getDsConfirmaSenha() {
        return dsConfirmaSenha;
    }

    public void setDsConfirmaSenha(String dsConfirmaSenha) {
        this.dsConfirmaSenha = dsConfirmaSenha;
    }

    public String getDsSenhaOriginal() {
        return dsSenhaOriginal;
    }

    public void setDsSenhaOriginal(String dsSenhaOriginal) {
        this.dsSenhaOriginal = dsSenhaOriginal;
    }

    public String getDsPesquisa() {
        return dsPesquisa;
    }

    public void setDsPesquisa(String dsPesquisa) {
        this.dsPesquisa = dsPesquisa;
    }

    private UsuarioRepository getUsuarioRepository() {
        return new UsuarioRepository(new ConexaoUtil());
    }
}