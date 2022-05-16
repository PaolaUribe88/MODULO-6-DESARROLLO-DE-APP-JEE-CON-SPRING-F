package cl.aiep.java.cft.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.java.cft.modelo.Alumno;
import cl.aiep.java.cft.modelo.Carrera;

@Repository
public class AlumnoRepositoryImp implements AlumnoRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private CarreraRepository carreraRepository;
	
	private Alumno makeObject(ResultSet rs, int filaNum) throws SQLException {
		int id	 = rs.getInt("id");	//(id) nombres de la columna de la tabla de base de datos 
		String nombre 				 = rs.getString("nombre");
		LocalDate fechaNacimiento 	 = rs.getObject("fecha_nacimiento", LocalDate.class);
		int carreraId                = rs.getInt("carrera_id");
		Carrera carrera              = carreraRepository.findById(carreraId);
		return new Alumno(id, nombre, fechaNacimiento,carrera);

	}
	@Override
	public List<Alumno> findAll() {
		
		return jdbcTemplate.query("SELECT * FROM alumnos", this::makeObject);
	}

	@Override
	public Alumno findById(int id) {
		
		return jdbcTemplate.queryForObject("SELECT * FROM alumnos WHERE id = ?", this::makeObject, id);
	}

	@Override
	public void create(Alumno alumno) {
		String sql ="INSERT INTO alumnos(nombre,fecha_nacimiento, carrera_id)values(?,?,?)";
		jdbcTemplate.update(sql, 
				alumno.getNombre(), 
				alumno.getFechaNacimiento(),
			    alumno.getCarrera().getId());
		
	}

	@Override
	public void edite(Alumno alumno) {
		String sql ="UPDATE alumnos SET nombre = ?, fecha_nacimiento = ?, carrera_id = ? WHERE id = ?";
		jdbcTemplate.update(sql, alumno.getNombre(), alumno.getFechaNacimiento(), alumno.getCarrera().getId(), alumno.getId());
				
	}

	@Override
	public void delete(int id) {
		String sql ="DELETE from alumnos WHERE id =?";
		jdbcTemplate.update(sql, id);
	}

}
