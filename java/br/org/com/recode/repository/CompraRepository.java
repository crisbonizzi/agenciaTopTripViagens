package br.org.com.recode.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.com.recode.model.Compras;


@Repository
public interface CompraRepository extends JpaRepository<Compras, Long>{

}
