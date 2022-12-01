package br.org.com.recode.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "compras")


public class Compras {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
    private Long id;

    @Column(nullable = false, name = "data")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate data;

    
    @Column(nullable = false)
    private String qtd_itens;

    
    @Column(nullable = false)
    private Double valor_total;
    
    @Column(nullable = false)
    private String nome_cliente;
    
    public Compras() {
		// TODO Auto-generated constructor stub
	}
	

	public Compras(Long id, LocalDate data, String qtd_itens, Double valor_total, String nome_cliente) {
		super();
		this.id = id;
		this.data = data;
		this.qtd_itens = qtd_itens;
		this.valor_total = valor_total;
		this.nome_cliente = nome_cliente;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public String getQtd_itens() {
		return qtd_itens;
	}


	public void setQtd_itens(String qtd_itens) {
		this.qtd_itens = qtd_itens;
	}


	public Double getValor_total() {
		return valor_total;
	}


	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}
	
	public String getNome_cliente() {
		return nome_cliente;
	}


	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}


	@Override
	public int hashCode() {
		return Objects.hash(data, id, qtd_itens, valor_total);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compras other = (Compras) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(qtd_itens, other.qtd_itens) && Objects.equals(valor_total, other.valor_total)&& Objects.equals(nome_cliente, other.nome_cliente);
	}



	@Override
    public String toString() {
        return "Compras [data=" + data + ", id=" + id + ", qtd_itens=" + qtd_itens + ", valor_total="
                + valor_total + ", nome_cliente=" + nome_cliente +"]";
        
	}
    
}





