package dao;

import model.UsuarioPessoa;

public class DaoUsuario<E> extends DaoGeneric<UsuarioPessoa>{
	
	public void removerUsuario(UsuarioPessoa usuarioPessoa) throws Exception {
		getEntityManager().getTransaction().begin();		
		String sqlDelTelefone="delete from telefoneuser where usuariopessoa_id = " + usuarioPessoa.getId();
		getEntityManager().createNativeQuery(sqlDelTelefone).executeUpdate();
		getEntityManager().getTransaction().commit();
		super.deletarPoId(usuarioPessoa);
		
	}

}
