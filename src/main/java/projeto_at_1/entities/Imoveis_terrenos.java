package projeto_at_1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "imoveis_terrenos")
public class Imoveis_terrenos {
	
	@Id
	@GeneratedValue
    @Column
	private int id;
	private String titulo;
	private String endereco;
	private double metros_MxM;
	private float m_construidos;
	private int qtd_quartos;
	private int qtd_banheiros;
	private int v_garagem;
	private double preco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public double getMetros_MxM() {
		return metros_MxM;
	}
	public void setMetros_MxM(double metros_MxM) {
		this.metros_MxM = metros_MxM;
	}
	
	public float getM_construidos() {
		return m_construidos;
	}
	public void setM_construidos(float m_construidos) {
		this.m_construidos = m_construidos;
	}
	
	public int getQtd_quartos() {
		return qtd_quartos;
	}
	public void setQtd_quartos(int qtd_quartos) {
		this.qtd_quartos = qtd_quartos;
	}
	
	public int getQtd_banheiros() {
		return qtd_banheiros;
	}
	public void setQtd_banheiros(int qtd_banheiros) {
		this.qtd_banheiros = qtd_banheiros;
	}
	
	public int getV_garagem() {
		return v_garagem;
	}
	public void setV_garagem(int v_garagem) {
		this.v_garagem = v_garagem;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	@Override
	public String toString() {
		return "Imoveis_terrenos [id=" + id + ", titulo=" + titulo + ", endereco=" + endereco + ", metros_MxM="
				+ metros_MxM + ", m_construidos=" + m_construidos + ", qtd_quartos=" + qtd_quartos + ", qtd_banheiros="
				+ qtd_banheiros + ", v_garagem=" + v_garagem + ", preco=" + preco + "]";
	}
	
	public Imoveis_terrenos(int id, String titulo, String endereco, float metros_MxM, float m_construidos,
			int qtd_quartos, int qtd_banheiros, int v_garagem, double preco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.endereco = endereco;
		this.metros_MxM = metros_MxM;
		this.m_construidos = m_construidos;
		this.qtd_quartos = qtd_quartos;
		this.qtd_banheiros = qtd_banheiros;
		this.v_garagem = v_garagem;
		this.preco = preco;
	}
	public Imoveis_terrenos() {
		super();
	}
	
	
	
	
	
	

}
