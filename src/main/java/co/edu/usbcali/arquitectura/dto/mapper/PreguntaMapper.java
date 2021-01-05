package co.edu.usbcali.arquitectura.dto.mapper;

import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.Pregunta;
import co.edu.usbcali.arquitectura.modelo.control.*;
import co.edu.usbcali.arquitectura.modelo.dto.PreguntaDTO;

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
public class PreguntaMapper implements IPreguntaMapper {
    private static final Logger log = LoggerFactory.getLogger(PreguntaMapper.class);

    /**
    * Logic injected by Spring that manages Categoria entities
    *
    */
    @Autowired
    ICategoriaLogic logicCategoria1;

    @Transactional(readOnly = true)
    public PreguntaDTO preguntaToPreguntaDTO(Pregunta pregunta)
        throws Exception {
        try {
            PreguntaDTO preguntaDTO = new PreguntaDTO();

            preguntaDTO.setIdPregunta(pregunta.getIdPregunta());
            preguntaDTO.setPregunta((pregunta.getPregunta() != null)
                ? pregunta.getPregunta() : null);

            if (pregunta.getCategoria() != null) {
                preguntaDTO.setIdCategoria_Categoria(pregunta.getCategoria()
                                                             .getIdCategoria());
            } else {
                preguntaDTO.setIdCategoria_Categoria(null);
            }

            return preguntaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Pregunta preguntaDTOToPregunta(PreguntaDTO preguntaDTO)
        throws Exception {
        try {
            Pregunta pregunta = new Pregunta();

            pregunta.setIdPregunta(preguntaDTO.getIdPregunta());
            pregunta.setPregunta((preguntaDTO.getPregunta() != null)
                ? preguntaDTO.getPregunta() : null);

            Categoria categoria = new Categoria();

            if (preguntaDTO.getIdCategoria_Categoria() != null) {
                categoria = logicCategoria1.getCategoria(preguntaDTO.getIdCategoria_Categoria());
            }

            if (categoria != null) {
                pregunta.setCategoria(categoria);
            }

            return pregunta;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PreguntaDTO> listPreguntaToListPreguntaDTO(
        List<Pregunta> listPregunta) throws Exception {
        try {
            List<PreguntaDTO> preguntaDTOs = new ArrayList<PreguntaDTO>();

            for (Pregunta pregunta : listPregunta) {
                PreguntaDTO preguntaDTO = preguntaToPreguntaDTO(pregunta);

                preguntaDTOs.add(preguntaDTO);
            }

            return preguntaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Pregunta> listPreguntaDTOToListPregunta(
        List<PreguntaDTO> listPreguntaDTO) throws Exception {
        try {
            List<Pregunta> listPregunta = new ArrayList<Pregunta>();

            for (PreguntaDTO preguntaDTO : listPreguntaDTO) {
                Pregunta pregunta = preguntaDTOToPregunta(preguntaDTO);

                listPregunta.add(pregunta);
            }

            return listPregunta;
        } catch (Exception e) {
            throw e;
        }
    }
}
