package cl.aiep.java.cft.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		return new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad"));

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
		String sql ="INSERT INTO alumnos(nombre,edad)values(?,?)";
		jdbcTemplate.update(sql, 
				alumno.getNombre(), 
				alumno.getEdad());
		
	}

	@Override
	public void edite(Alumno alumno) {
		String sql ="UDTAPE alumnos SET nombre = ?,edad =? WHERE id =?";
		jdbcTemplate.update(sql, 
				alumno.getNombre(),
				alumno.getEdad(),
				alumno.getId());
	}

	@Override
	public void delete(int id) {
		String sql ="DELETE from alumnos WHERE id =?";
		jdbcTemplate.update(sql, id);
	}

}
