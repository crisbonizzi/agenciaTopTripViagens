package br.org.com.recode.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.org.com.recode.model.Clients;


@Repository
public interface ClientRepository extends JpaRepository<Clients, Long>{

	static Object findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
