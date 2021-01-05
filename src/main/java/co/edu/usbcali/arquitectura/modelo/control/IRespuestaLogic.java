package co.edu.usbcali.arquitectura.modelo.control;

import co.edu.usbcali.arquitectura.modelo.Pregunta;
import co.edu.usbcali.arquitectura.modelo.Respuesta;
import co.edu.usbcali.arquitectura.modelo.dto.RespuestaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IRespuestaLogic {
    public List<Respuesta> getRespuesta() throws Exception;

    /**
         * Save an new Respuesta entity
         */
    public void saveRespuesta(Respuesta entity) throws Exception;

    /**
         * Delete an existing Respuesta entity
         *
         */
    public void deleteRespuesta(Respuesta entity) throws Exception;

    /**
        * Update an existing Respuesta entity
        *
        */
    public void updateRespuesta(Respuesta entity) throws Exception;

    /**
         * Load an existing Respuesta entity
         *
         */
    public Respuesta getRespuesta(Integer idRespuesta)
        throws Exception;

    public List<Respuesta> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Respuesta> findPageRespuesta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRespuesta() throws Exception;

    public List<RespuestaDTO> getDataRespuesta() throws Exception;

    public void validateRespuesta(Respuesta respuesta) throws Exception;
    
    public Pregunta ultimaPregunta() throws Exception;
}
