package cl.aiep.java.cft.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.java.Alumno;

@Repository
public class AlumnoRepositoryImp implements AlumnoRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Alumno makeObject(ResultSet rs, int filaNum) throws SQLException {
		int id						 = rs.getInt("id");//nombres de la columna de la tabla 
		String nombre 				 = rs.getString("nombre");
		LocalDate fechaNacimiento 	 = rs.getObject("fecha_nacimiento", LocalDate.class);
		
		return new Alumno(id, nombre, fechaNacimiento);

	}
	@Override
	public List<Alumno> findAll() {
		
		return jdbcTemplate.query("SELECT * FROM alumnos", this::makeObject);
	}

	@Override
	public Alumno findById(int id) {
		
		return jdbcTemplate.queryForObject("SELECT * FROM alumnos WHERE id = ?", this::makeObject);
	}

	@Override
	public void create(Alumno alumno) {
		String sql ="INSERT INTO alumnos(nombre,fecha_nacimiento)values(?,?)";
		jdbcTemplate.update(sql, 
				alumno.getNombre(), 
				alumno.getFechaNacimiento());
		
	}

	@Override
	public void edite(Alumno alumno) {
		String sql ="UDTAPE alumnos SET nombre = ?,fecha_nacimiento =? WHERE id =?";
		jdbcTemplate.update(sql, 
				alumno.getNombre(),
				alumno.getFechaNacimiento(),
				alumno.getId());
	}

	@Override
	public void delete(int id) {
		String sql ="DELETE from alumnos WHERE id =?";
		jdbcTemplate.update(sql, id);
	}

}
