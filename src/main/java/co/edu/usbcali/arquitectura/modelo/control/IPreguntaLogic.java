package co.edu.usbcali.arquitectura.modelo.control;

import co.edu.usbcali.arquitectura.modelo.Pregunta;
import co.edu.usbcali.arquitectura.modelo.dto.PreguntaDTO;

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
public interface IPreguntaLogic {
	
	public String preguntaResponde(String pregunta) throws Exception;
	
    public List<Pregunta> getPregunta() throws Exception;

    /**
         * Save an new Pregunta entity
         */
    public void savePregunta(Pregunta entity) throws Exception;

    /**
         * Delete an existing Pregunta entity
         *
         */
    public void deletePregunta(Pregunta entity) throws Exception;

    /**
        * Update an existing Pregunta entity
        *
        */
    public void updatePregunta(Pregunta entity) throws Exception;

    /**
         * Load an existing Pregunta entity
         *
         */
    public Pregunta getPregunta(Integer idPregunta) throws Exception;

    public List<Pregunta> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Pregunta> findPagePregunta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPregunta() throws Exception;

    public List<PreguntaDTO> getDataPregunta() throws Exception;

    public void validatePregunta(Pregunta pregunta) throws Exception;
}
