package co.edu.usbcali.arquitectura.dataaccess.dao;

import co.edu.usbcali.arquitectura.dataaccess.api.Dao;
import co.edu.usbcali.arquitectura.modelo.Pregunta;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   PreguntaDAO.
*
*/
public interface IPreguntaDAO extends Dao<Pregunta, Integer> {
	public Integer consultarPreguntaBD(String pregunta);
	public List<String> consultarTodasLasPreguntas();
}
