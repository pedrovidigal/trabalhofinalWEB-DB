package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** modulo de conexão **/
	// parametros de conexão
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/projeto-final";
	private String user = "postgres";
	private String password = "pedro123";

	// metodo de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD CREATE **/
	public void inserirPrato(JavaBeans pratos) {
		String create = "insert into Prato (Codigo,Nome,Ingredientes,Tipo) values (?,?,?,?)";
		try {
			// abrir conexão com BD
			Connection con = conectar();
			// Preparar a query para execução BD
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parametros (?) pelo conteudo JavaBeans
			pst.setInt(1, pratos.getCodigo());
			pst.setString(2, pratos.getNome());
			pst.setString(3, pratos.getIngredientes());
			pst.setString(4, pratos.getTipo());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarPratos() {
		// criando um obj para acessar JB
		ArrayList<JavaBeans> pratos = new ArrayList<>();
		String read = "select * from Prato order by Codigo";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o laço abaixo sera executado enquanto tiver pratos
			while (rs.next()) {
				// variaveis de apoio para receber dados do banco
				int Codigo = rs.getInt(1);
				String Nome = rs.getString(2);
				String Ingredientes = rs.getString(3);
				String Tipo = rs.getString(4);
				// populando o Array
				pratos.add(new JavaBeans(Codigo, Nome, Ingredientes, Tipo));
			}
			con.close();
			return pratos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD UPDATE **/
	//selecionar o prato
	public void selecionarPrato(JavaBeans pratos) {
		String read2 = "select * from Prato where Codigo = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, pratos.getCodigo());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				//setar as variaveis JB
				pratos.setCodigo(rs.getInt(1));
				pratos.setNome(rs.getString(2));
				pratos.setIngredientes(rs.getString(3));
				pratos.setTipo(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//editar o prato
	public void alterarPrato(JavaBeans pratos) {
		String create = "update prato set Nome=?,Ingredientes=?,Tipo=? where Codigo=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, pratos.getNome());
			pst.setString(2, pratos.getIngredientes());
			pst.setString(3, pratos.getTipo());
			pst.setInt(4, pratos.getCodigo());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/** CRUD DELETE **/
	public void deletarPrato(JavaBeans pratos) {
		String delete = "delete from Prato where Codigo=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, pratos.getCodigo());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
