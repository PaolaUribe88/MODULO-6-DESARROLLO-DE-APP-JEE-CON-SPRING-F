package cl.aiep.java.archivos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.archivos.model.Archivo;

public interface ArchivoRepository extends JpaRepository<Archivo, Long> {

}
