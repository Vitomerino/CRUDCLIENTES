package victor.clientes.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import victor.clientes.modelo.ClienteVO;


@Repository
public interface IClienteVODAO extends JpaRepository<ClienteVO, String> {
	public ClienteVO findByNombres(String nombres);
	
}
