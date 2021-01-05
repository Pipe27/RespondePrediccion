package co.edu.usbcali.arquitectura.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class RespuestaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RespuestaDTO.class);
    private Integer idRespuesta;
    private String respuesta;
    private Integer idPregunta_Pregunta;

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Integer getIdPregunta_Pregunta() {
        return idPregunta_Pregunta;
    }

    public void setIdPregunta_Pregunta(Integer idPregunta_Pregunta) {
        this.idPregunta_Pregunta = idPregunta_Pregunta;
    }
}
