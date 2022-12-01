package br.org.com.recode.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pacotes")

public class Pacotes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	

    @Column(nullable = false)
    private String acomodacao;
    
    @Column(nullable = false)
    private String hoteis;


    @Column(nullable = false)
    private String valor;
    
	public Pacotes() {
		
	}

	public Pacotes(long id, String acomodacao, String hoteis, String valor) {
		super();
		this.id = id;
		this.acomodacao = acomodacao;
		this.hoteis = hoteis;
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAcomodacao() {
		return acomodacao;
	}

	public void setAcomodacao(String acomodacao) {
		this.acomodacao = acomodacao;
	}

	public String getHoteis() {
		return hoteis;
	}

	public void setHoteis(String hoteis) {
		this.hoteis = hoteis;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acomodacao, hoteis, id, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacotes other = (Pacotes) obj;
		return Objects.equals(acomodacao, other.acomodacao) && Objects.equals(hoteis, other.hoteis) && id == other.id
				&& Objects.equals(valor, other.valor);
	}	
	
	@Override
    public String toString() {
        return "Pacotes [acomodacao=" + acomodacao + ",id=" + id + ", hoteis=" + hoteis + ", valor="
                + valor + "]";
        
	}

	


	

	



}


