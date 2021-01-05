package co.edu.usbcali.arquitectura.dto.mapper;

import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.Respuesta;
import co.edu.usbcali.arquitectura.modelo.control.*;
import co.edu.usbcali.arquitectura.modelo.dto.RespuestaDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class RespuestaMapper implements IRespuestaMapper {
    private static final Logger log = LoggerFactory.getLogger(RespuestaMapper.class);

    /**
    * Logic injected by Spring that manages Pregunta entities
    *
    */
    @Autowired
    IPreguntaLogic logicPregunta1;

    @Transactional(readOnly = true)
    public RespuestaDTO respuestaToRespuestaDTO(Respuesta respuesta)
        throws Exception {
        try {
            RespuestaDTO respuestaDTO = new RespuestaDTO();

            respuestaDTO.setIdRespuesta(respuesta.getIdRespuesta());
            respuestaDTO.setRespuesta((respuesta.getRespuesta() != null)
                ? respuesta.getRespuesta() : null);

            if (respuesta.getPregunta() != null) {
                respuestaDTO.setIdPregunta_Pregunta(respuesta.getPregunta()
                                                             .getIdPregunta());
            } else {
                respuestaDTO.setIdPregunta_Pregunta(null);
            }

            return respuestaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Respuesta respuestaDTOToRespuesta(RespuestaDTO respuestaDTO)
        throws Exception {
        try {
            Respuesta respuesta = new Respuesta();

            respuesta.setIdRespuesta(respuestaDTO.getIdRespuesta());
            respuesta.setRespuesta((respuestaDTO.getRespuesta() != null)
                ? respuestaDTO.getRespuesta() : null);

            Pregunta pregunta = new Pregunta();

            if (respuestaDTO.getIdPregunta_Pregunta() != null) {
                pregunta = logicPregunta1.getPregunta(respuestaDTO.getIdPregunta_Pregunta());
            }

            if (pregunta != null) {
                respuesta.setPregunta(pregunta);
            }

            return respuesta;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RespuestaDTO> listRespuestaToListRespuestaDTO(
        List<Respuesta> listRespuesta) throws Exception {
        try {
            List<RespuestaDTO> respuestaDTOs = new ArrayList<RespuestaDTO>();

            for (Respuesta respuesta : listRespuesta) {
                RespuestaDTO respuestaDTO = respuestaToRespuestaDTO(respuesta);

                respuestaDTOs.add(respuestaDTO);
            }

            return respuestaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Respuesta> listRespuestaDTOToListRespuesta(
        List<RespuestaDTO> listRespuestaDTO) throws Exception {
        try {
            List<Respuesta> listRespuesta = new ArrayList<Respuesta>();

            for (RespuestaDTO respuestaDTO : listRespuestaDTO) {
                Respuesta respuesta = respuestaDTOToRespuesta(respuestaDTO);

                listRespuesta.add(respuesta);
            }

            return listRespuesta;
        } catch (Exception e) {
            throw e;
        }
    }
}
