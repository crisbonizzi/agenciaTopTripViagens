package br.org.com.recode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.com.recode.model.Passagens;

@Repository
public interface PassagemRepository extends JpaRepository<Passagens, Long>{

}