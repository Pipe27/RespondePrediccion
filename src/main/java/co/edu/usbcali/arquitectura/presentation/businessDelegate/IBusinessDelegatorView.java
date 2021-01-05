package co.edu.usbcali.arquitectura.presentation.businessDelegate;

import co.edu.usbcali.arquitectura.modelo.Categoria;
import co.edu.usbcali.arquitectura.modelo.Pregunta;
import co.edu.usbcali.arquitectura.modelo.Respuesta;
import co.edu.usbcali.arquitectura.modelo.control.CategoriaLogic;
import co.edu.usbcali.arquitectura.modelo.control.ICategoriaLogic;
import co.edu.usbcali.arquitectura.modelo.control.IPreguntaLogic;
import co.edu.usbcali.arquitectura.modelo.control.IRespuestaLogic;
import co.edu.usbcali.arquitectura.modelo.control.PreguntaLogic;
import co.edu.usbcali.arquitectura.modelo.control.RespuestaLogic;
import co.edu.usbcali.arquitectura.modelo.dto.CategoriaDTO;
import co.edu.usbcali.arquitectura.modelo.dto.PreguntaDTO;
import co.edu.usbcali.arquitectura.modelo.dto.RespuestaDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
	public String preguntaResponde(String pregunta) throws Exception;
	
    public List<Categoria> getCategoria() throws Exception;

    public void saveCategoria(Categoria entity) throws Exception;

    public void deleteCategoria(Categoria entity) throws Exception;

    public void updateCategoria(Categoria entity) throws Exception;

    public Categoria getCategoria(Integer idCategoria)
        throws Exception;

    public List<Categoria> findByCriteriaInCategoria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Categoria> findPageCategoria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCategoria() throws Exception;

    public List<CategoriaDTO> getDataCategoria() throws Exception;

    public void validateCategoria(Categoria categoria)
        throws Exception;

    public List<Pregunta> getPregunta() throws Exception;

    public void savePregunta(Pregunta entity) throws Exception;

    public void deletePregunta(Pregunta entity) throws Exception;

    public void updatePregunta(Pregunta entity) throws Exception;

    public Pregunta getPregunta(Integer idPregunta) throws Exception;

    public List<Pregunta> findByCriteriaInPregunta(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Pregunta> findPagePregunta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPregunta() throws Exception;

    public List<PreguntaDTO> getDataPregunta() throws Exception;

    public void validatePregunta(Pregunta pregunta) throws Exception;

    public List<Respuesta> getRespuesta() throws Exception;

    public void saveRespuesta(Respuesta entity) throws Exception;

    public void deleteRespuesta(Respuesta entity) throws Exception;

    public void updateRespuesta(Respuesta entity) throws Exception;

    public Respuesta getRespuesta(Integer idRespuesta)
        throws Exception;

    public List<Respuesta> findByCriteriaInRespuesta(Object[] variables,
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
