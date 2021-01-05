package co.edu.usbcali.arquitectura.dto.mapper;

import co.edu.usbcali.arquitectura.modelo.Respuesta;
import co.edu.usbcali.arquitectura.modelo.dto.RespuestaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IRespuestaMapper {
    public RespuestaDTO respuestaToRespuestaDTO(Respuesta respuesta)
        throws Exception;

    public Respuesta respuestaDTOToRespuesta(RespuestaDTO respuestaDTO)
        throws Exception;

    public List<RespuestaDTO> listRespuestaToListRespuestaDTO(
        List<Respuesta> respuestas) throws Exception;

    public List<Respuesta> listRespuestaDTOToListRespuesta(
        List<RespuestaDTO> respuestaDTOs) throws Exception;
}
