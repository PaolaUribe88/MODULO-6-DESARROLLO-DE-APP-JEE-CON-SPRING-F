package cl.aiep.java.cft.repository;

import java.util.List;

import cl.aiep.java.cft.modelo.Carrera;

public interface CarreraRepository {
	
	public List<Carrera> findAll();
	public Carrera findById(int id);
	public void create(Carrera carrera);
	public void edit(Carrera carrera);
	public void delete(int id);
}
