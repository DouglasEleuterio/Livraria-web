package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import database.FabricaConexao;
import model.Livro;

public class LivroDao implements Dao<Livro, Integer> {
	Logger LOG = Logger.getGlobal();

	private static final String OBTER_POR_ID_SQL = "SELECT AUTOR, TITULO, COD_LIVRO, IMAGEM, PRECO, DESCRICAO,"
			+ "FROM ESTOQUE WHERE TITULO LIKE ?";
	private static final String CONSULTAR_SQL = "SELECT COD_LIVRO, TITULO, AUTOR, PRECO, IMAGEM,"
			+ "DESCRICAO FROM ESTOQUE WHERE TITULO LIKE ?";

	private static final String SALVAR_SQL = "insert into ESTOQUE (TITULO,AUTOR,PRECO,IMAGEM,DESCRICAO) values (?,?,?,?,?)";

	@Override
	public Livro consultar(Integer codigo) {
		Livro livro = null;

		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(OBTER_POR_ID_SQL);) {

			consulta.setInt(1, codigo);

			ResultSet resultado = consulta.executeQuery();

			if (resultado.next()) {
				livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setDescricao(resultado.getString("DESCRICAO"));
			}

			resultado.close();

		} catch (SQLException e) {
			LOG.severe(e.toString());
		}
		return livro;
	}

	public List<Livro> consutar(String titulo) {
		ArrayList<Livro> lista = new ArrayList<>();
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(CONSULTAR_SQL);) {
			consulta.setString(1, "%" + titulo.toUpperCase() + "%");

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {
				Livro livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setDescricao(resultado.getString("DESCRICAO"));
				lista.add(livro);
			}
			resultado.close();

		} catch (SQLException e) {
			LOG.severe(e.toString());
		}
		return lista;
	}

	@Override
	public void alterar(Livro livro) {

	}

	@Override
	public void salvar(Livro livro) {

		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(SALVAR_SQL);) {

			consulta.setString(1, livro.getTitulo());
			consulta.setString(2, livro.getAutor());
			consulta.setDouble(3, livro.getPreco());
			consulta.setString(4, livro.getImagem());
			consulta.setString(4, livro.getDescricao());
			consulta.execute();

		} catch (SQLException e) {
			LOG.severe(e.toString());
		}

	}

	@Override
	public void remover(Livro Integer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Livro> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
