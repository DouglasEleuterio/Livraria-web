package dao;

import java.util.List;

import model.Livro;

public class CatalogoService {

	private Livro livro;
	private List<Livro> livros; 
	
	
	public List<Livro> consultar (String titulo){
		if (titulo == null){
			titulo = "";
		}
		System.out.println("Pesquisa: " + titulo);
		LivroDao dao = new LivroDao();
		livros = dao.consutar(titulo);
		
		if (livros.size() <=0){
			System.out.println("Livro Não Localizado");
		}
		return livros;
	}
	
	public Livro verLivro (Integer codigo){
		LivroDao dao = new LivroDao();
		livro = dao.consultar(codigo);
		return livro;
	}
}
