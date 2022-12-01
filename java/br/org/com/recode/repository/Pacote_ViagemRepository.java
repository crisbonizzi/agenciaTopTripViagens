package br.org.com.recode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.com.recode.model.Pacotes;

@Repository
public interface Pacote_ViagemRepository extends JpaRepository<Pacotes, Long>{

}
