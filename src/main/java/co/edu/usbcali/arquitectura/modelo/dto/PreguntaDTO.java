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
public class PreguntaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PreguntaDTO.class);
    private Integer idPregunta;
    private String pregunta;
    private Integer idCategoria_Categoria;

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Integer getIdCategoria_Categoria() {
        return idCategoria_Categoria;
    }

    public void setIdCategoria_Categoria(Integer idCategoria_Categoria) {
        this.idCategoria_Categoria = idCategoria_Categoria;
    }
}
