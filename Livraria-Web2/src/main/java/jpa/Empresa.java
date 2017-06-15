package jpa;

import login.Usuario;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Empresa {

	@Id
	@GeneratedValue
	private int id;
	private String nome;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "empresa_id")
	private List<Usuario> empregados;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Usuario> empregados) {
		this.empregados = empregados;
	}

}
