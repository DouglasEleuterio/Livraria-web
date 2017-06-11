package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.CatalogoService;
import model.Livro;

@ManagedBean (name = "livroBean")
@SessionScoped

public class LivroBean {

	private String titulo;
	private Livro livro;
	private List<Livro> livros;
	private CatalogoService service;

	private static final String RESULTADO = "Resultado";
	private static final String LIVRO = "Livro";

	@PostConstruct
	public void init() {
		service = new CatalogoService();
		System.out.println("LivroBean.init()");
	}

	public String pesquisar(){
		livros = null;
		livros = service.consultar(titulo);
		
		return RESULTADO;
	}
	
	public String verLivro(int codigo){
		livro = service.verLivro(codigo);
		return LIVRO;
	}
}
