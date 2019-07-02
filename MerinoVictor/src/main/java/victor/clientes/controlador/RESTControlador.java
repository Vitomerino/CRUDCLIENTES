package victor.clientes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import victor.clientes.modelo.ClienteVO;
import victor.clientes.modelo.dao.IClienteVODAO;

@RestController
public class RESTControlador {

	
	@Autowired
	IClienteVODAO dao;
	
	
	@GetMapping("/clientes")
	public List<ClienteVO> getClientes(){
		return this.dao.findAll();
		
		
	}
	
	
	@GetMapping("/clientes/{rut}")
	public ClienteVO getCliente(@PathVariable String rut) {
		return dao.findById(rut).orElse(new ClienteVO());
	}
	
	
	@GetMapping("/clientes/buscar/{nombres}")
	public ClienteVO getClientenombres(@PathVariable String nombres) {
		return dao.findByNombres(nombres);
	}
	
	
	
	
	
	@PostMapping("/clientes")
	public boolean addClientes(@RequestBody ClienteVO nuevo) {
		if(!this.dao.existsById(nuevo.getRut())) {
			System.out.println(nuevo);
			this.dao.save(nuevo);
			return true;
		}
		return false;
	}
	
	
	@PutMapping("/clientes")
	public boolean modifyCliente(@RequestBody ClienteVO modificar) {
		if(this.dao.existsById(modificar.getRut())){
			this.dao.save(modificar);
			return true;
		}
		return false;
	}
	
	
	@DeleteMapping("/clientes/{rut}")
	public boolean BORRARcliente(@PathVariable String rut) {
		if(this.dao.existsById(rut)) {
			this.dao.deleteById(rut);
			return true;
		}
	
	return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
