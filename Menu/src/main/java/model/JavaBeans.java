package model;

public class JavaBeans {
	private int Codigo;
	private String Nome;
	private String Ingredientes;
	private String Tipo_prato;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(int codigo, String nome, String ingredientes, String tipo) {
		super();
		Codigo = codigo;
		Nome = nome;
		Ingredientes = ingredientes;
		Tipo_prato = tipo;
	}

	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getIngredientes() {
		return Ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		Ingredientes = ingredientes;
	}
	public String getTipo() {
		return Tipo_prato;
	}
	public void setTipo(String tipo) {
		Tipo_prato = tipo;
	}
}
