package cl.aiep.java.cft.repository;

import java.util.List;

import cl.aiep.java.cft.modelo.Alumno;

public interface AlumnoRepository {
	
	public List<Alumno> findAll();
	public Alumno findById(int id);
	public void create(Alumno alumno);
	public void edite(Alumno alumno);
	public void delete(int id);
	

}
