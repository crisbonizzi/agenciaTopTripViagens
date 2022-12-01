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
@Table(name = "passagens")
public class Passagens {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Long id;

    @Column(nullable = false)
    private Double preco_passagem;
    

    @Column(nullable = false, name = "data_ida")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate data_ida;
    
    @Column(nullable = false, name = "data_volta")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate data_volta;


    @Column(nullable = false)
    private String origem;
    

    @Column(nullable = false)
    private String destino;
    
	
	public Passagens() {
		
	}


	public Passagens(Long id, Double preco_passagem, LocalDate data_ida, LocalDate data_volta, String origem,
			String destino) {
		super();
		this.id = id;
		this.preco_passagem = preco_passagem;
		this.data_ida = data_ida;
		this.data_volta = data_volta;
		this.origem = origem;
		this.destino = destino;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getPreco_passagem() {
		return preco_passagem;
	}


	public void setPreco_passagem(Double preco_passagem) {
		this.preco_passagem = preco_passagem;
	}


	public LocalDate getData_ida() {
		return data_ida;
	}


	public void setData_ida(LocalDate data_ida) {
		this.data_ida = data_ida;
	}


	public LocalDate getData_volta() {
		return data_volta;
	}


	public void setData_volta(LocalDate data_volta) {
		this.data_volta = data_volta;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	@Override
	public int hashCode() {
		return Objects.hash(data_ida, data_volta, destino, id, origem, preco_passagem);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passagens other = (Passagens) obj;
		return Objects.equals(data_ida, other.data_ida) && Objects.equals(data_volta, other.data_volta)
				&& Objects.equals(destino, other.destino) && Objects.equals(id, other.id)
				&& Objects.equals(origem, other.origem) && Objects.equals(preco_passagem, other.preco_passagem);
	}	
	
	@Override
    public String toString() {
        return "Passagens [preco_passagem=" + preco_passagem + ", id=" + id + ", data_ida=" + data_ida + ", data_volta=" + data_volta + "origem="
                + origem + ", destino=" + destino + "]";
        
	}
    
}
	






