package co.edu.usbcali.arquitectura.dataaccess.dao;

import co.edu.usbcali.arquitectura.dataaccess.api.Dao;
import co.edu.usbcali.arquitectura.modelo.Pregunta;
import co.edu.usbcali.arquitectura.modelo.Respuesta;

/**
* Interface for   RespuestaDAO.
*
*/
public interface IRespuestaDAO extends Dao<Respuesta, Integer> {

	public Pregunta ultimaPregunta();
	public Respuesta ConsultarRespuestaPorId(Integer id);

}
