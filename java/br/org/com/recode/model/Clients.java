package br.org.com.recode.model;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



	
@Entity
@Table(name = "clients")
public class Clients {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long id_cliente;

    @Column(nullable = false)
    private String nome_cliente;
    
    @Column(nullable = false)
    private String email_cliente;

    @Column(nullable = false, name = "Data_nascimento")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate Data_nascimento;

    @Column(nullable = false)
    private String cpf_cliente;
    
    @Column(nullable = false)
    private String senha;

    
    
    public Clients() {
		// TODO Auto-generated constructor stub
	}
    
    
    public Clients (Long id_cliente, String nome_cliente, String email_cliente, LocalDate Data_nascimento, String cpf_cliente , String senha) {
    	this.id_cliente = id_cliente;
		this.nome_cliente = nome_cliente;
		this.email_cliente = email_cliente;
		this.Data_nascimento = Data_nascimento;
		this.cpf_cliente = cpf_cliente;
		this.senha = senha;
		
	   
	}

    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
	public LocalDate getData_nascimento() {
		return Data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		Data_nascimento = data_nascimento;
	}

	public Long getId_cliente() {
        return this.id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() {
        return this.nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getEmail_cliente() {
        return this.email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getCpf_cliente() {
        return this.cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }


	@Override
	public int hashCode() {
		return Objects.hash(Data_nascimento, cpf_cliente, email_cliente, id_cliente, nome_cliente);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clients other = (Clients) obj;
		return Objects.equals(Data_nascimento, other.Data_nascimento) && Objects.equals(cpf_cliente, other.cpf_cliente)
				&& Objects.equals(email_cliente, other.email_cliente) && id_cliente == other.id_cliente
				&& Objects.equals(nome_cliente, other.nome_cliente);
	}
    
	@Override
    public String toString() {
        return "Clients [Data_nascimento=" + Data_nascimento + ", id_cliente=" + id_cliente + ", nome_cliente=" + nome_cliente + ", email_cliente="
                + email_cliente + "]";
        
	}
    
}
