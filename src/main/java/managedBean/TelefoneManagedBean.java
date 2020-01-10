package managedBean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.DaoTelefone;
import dao.DaoUsuario;
import model.UsuarioPessoa;
import model.TelefoneUser;

@ViewScoped
@ManagedBean(name = "telefoneManagedBean")
public class TelefoneManagedBean {
	
	private UsuarioPessoa user = new UsuarioPessoa();
	private DaoTelefone<TelefoneUser> daoTelefone = new DaoTelefone<TelefoneUser>(); 
	private DaoUsuario<UsuarioPessoa> daoUser = new DaoUsuario<UsuarioPessoa>();
	private TelefoneUser telefone= new TelefoneUser();
	
	@PostConstruct
	public void init() {
		String codUser=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigoUser");
		System.out.println(codUser);
		user=daoUser.pesquisar(Long.parseLong(codUser), UsuarioPessoa.class);
	}
	
	public void setTelefone(TelefoneUser telefone) {
		this.telefone = telefone;
	}
	
	public TelefoneUser getTelefone() {
		return telefone;
	}

	public UsuarioPessoa getUser() {
		return user;
	}

	public void setUser(UsuarioPessoa user) {
		this.user = user;
	}

	public DaoTelefone<TelefoneUser> getDaoTelefone() {
		return daoTelefone;
	}

	public void setDaoTelefone(DaoTelefone<TelefoneUser> daoTelefone) {
		this.daoTelefone = daoTelefone;
	}

	public DaoUsuario getDaoUser() {
		return daoUser;
	}

	public void setDaoUser(DaoUsuario daoUser) {
		this.daoUser = daoUser;
	}
	
	public String salvar() {
		telefone.setUsuarioPessoa(user);
		daoTelefone.salvar(telefone);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Salvo com sucesso"));
		telefone=new TelefoneUser();
		user=daoUser.pesquisar(user.getId(), UsuarioPessoa.class);
		return null;
	}
	
	public String removeTelefone() throws Exception {
		daoTelefone.deletarPoId(telefone);
		user=daoUser.pesquisar(user.getId(), UsuarioPessoa.class);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Excluído com sucesso"));
		telefone=new TelefoneUser();
		return null;
		
	}
	
	

}
