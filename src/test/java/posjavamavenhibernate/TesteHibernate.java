package posjavamavenhibernate;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.TelefoneUser;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();		
		UsuarioPessoa pessoa = new UsuarioPessoa();		
		pessoa.setIdade(45);
		pessoa.setLogin("teste");
		pessoa.setNome("Paulo");
		pessoa.setSenha("123");
		pessoa.setSobrenome("Egidio");
		pessoa.setEmail("javaavancado@javaavancado.com");
		
		daoGeneric.salvar(pessoa);
		
	}
	
	@Test
	public void testeBuscar(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(2L);
		
		pessoa = daoGeneric.pesquisar(pessoa);
		
		System.out.println(pessoa);
		
	}
	
	@Test
	public void testeBuscar2(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L , UsuarioPessoa.class);
		
		System.out.println(pessoa);
		
	}
	
	
	
	@Test
	public void testeUpdate(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L , UsuarioPessoa.class);
		
		pessoa.setIdade(99);
		pessoa.setNome("Nome atualizado Hibernate");
		pessoa.setSenha("sd4s5d4s4d");
		
		pessoa = daoGeneric.updateMerge(pessoa);
		
		System.out.println(pessoa);
		
	}
	
	
	@Test
	public void testeDelete(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(3L , UsuarioPessoa.class);
		
		try {
			daoGeneric.deletarPoId(pessoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void testeConsultar(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println("--------------------------------------------------");
		}
		
		
	}
	
	@Test
	public void TesteGravaTelefone() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(27L, UsuarioPessoa.class);
		System.out.println(pessoa.toString());
		TelefoneUser telefoneUser = new TelefoneUser();
		telefoneUser.setTipo("celular");
		telefoneUser.setNumero("48991886185");
		telefoneUser.setUsuarioPessoa(pessoa);
		DaoGeneric<TelefoneUser> daoGeneric2 = new DaoGeneric<TelefoneUser>();
		daoGeneric2.salvar(telefoneUser);		
		
	}
	

}
