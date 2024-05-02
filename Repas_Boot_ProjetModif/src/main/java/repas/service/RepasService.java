package repas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repas.dao.IDAORepas;
import repas.model.Repas;


@Service
public class RepasService {

	@Autowired
	IDAORepas daoRepas;
	
	public Repas getById(Integer id) 
	{
		Optional<Repas> opt = daoRepas.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return opt.get();
		}
	}

	
	public List<Repas> getAll()
	{
		return daoRepas.findAll();
	}
	
	

	
	public Repas insert(Repas Repas) 
	{
		return daoRepas.save(Repas);
	}
	
	
	public Repas update(Repas Repas) 
	{
		if(Repas.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
	
		return daoRepas.save(Repas);
	}
	
	/*public void delete(Repas Repas) 
	{
		daoRepas.delete(Repas);
	}*/
	
	public void deleteById(Integer id) 
	{
		daoRepas.deleteById(id);
	}
	
	
	public List<Repas> findAllByRecette(Integer id)
	{
		return daoRepas.findAllByRecette(id);
	}
	
	
}
