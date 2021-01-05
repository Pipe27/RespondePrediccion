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
import co.edu.usbcali.arquitectura.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private ICategoriaLogic categoriaLogic;
    @Autowired
    private IPreguntaLogic preguntaLogic;
    @Autowired
    private IRespuestaLogic respuestaLogic;

    public List<Categoria> getCategoria() throws Exception {
        return categoriaLogic.getCategoria();
    }

    public void saveCategoria(Categoria entity) throws Exception {
        categoriaLogic.saveCategoria(entity);
    }

    public void deleteCategoria(Categoria entity) throws Exception {
        categoriaLogic.deleteCategoria(entity);
    }

    public void updateCategoria(Categoria entity) throws Exception {
        categoriaLogic.updateCategoria(entity);
    }

    public Categoria getCategoria(Integer idCategoria)
        throws Exception {
        Categoria categoria = null;

        try {
            categoria = categoriaLogic.getCategoria(idCategoria);
        } catch (Exception e) {
            throw e;
        }

        return categoria;
    }

    public List<Categoria> findByCriteriaInCategoria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return categoriaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Categoria> findPageCategoria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return categoriaLogic.findPageCategoria(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCategoria() throws Exception {
        return categoriaLogic.findTotalNumberCategoria();
    }

    public List<CategoriaDTO> getDataCategoria() throws Exception {
        return categoriaLogic.getDataCategoria();
    }

    public void validateCategoria(Categoria categoria)
        throws Exception {
        categoriaLogic.validateCategoria(categoria);
    }

    public List<Pregunta> getPregunta() throws Exception {
        return preguntaLogic.getPregunta();
    }

    public void savePregunta(Pregunta entity) throws Exception {
        preguntaLogic.savePregunta(entity);
    }

    public void deletePregunta(Pregunta entity) throws Exception {
        preguntaLogic.deletePregunta(entity);
    }

    public void updatePregunta(Pregunta entity) throws Exception {
        preguntaLogic.updatePregunta(entity);
    }

    public Pregunta getPregunta(Integer idPregunta) throws Exception {
        Pregunta pregunta = null;

        try {
            pregunta = preguntaLogic.getPregunta(idPregunta);
        } catch (Exception e) {
            throw e;
        }

        return pregunta;
    }

    public List<Pregunta> findByCriteriaInPregunta(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return preguntaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Pregunta> findPagePregunta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return preguntaLogic.findPagePregunta(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberPregunta() throws Exception {
        return preguntaLogic.findTotalNumberPregunta();
    }

    public List<PreguntaDTO> getDataPregunta() throws Exception {
        return preguntaLogic.getDataPregunta();
    }

    public void validatePregunta(Pregunta pregunta) throws Exception {
        preguntaLogic.validatePregunta(pregunta);
    }

    public List<Respuesta> getRespuesta() throws Exception {
        return respuestaLogic.getRespuesta();
    }

    public void saveRespuesta(Respuesta entity) throws Exception {
        respuestaLogic.saveRespuesta(entity);
    }

    public void deleteRespuesta(Respuesta entity) throws Exception {
        respuestaLogic.deleteRespuesta(entity);
    }

    public void updateRespuesta(Respuesta entity) throws Exception {
        respuestaLogic.updateRespuesta(entity);
    }

    public Respuesta getRespuesta(Integer idRespuesta)
        throws Exception {
        Respuesta respuesta = null;

        try {
            respuesta = respuestaLogic.getRespuesta(idRespuesta);
        } catch (Exception e) {
            throw e;
        }

        return respuesta;
    }

    public List<Respuesta> findByCriteriaInRespuesta(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return respuestaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Respuesta> findPageRespuesta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return respuestaLogic.findPageRespuesta(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberRespuesta() throws Exception {
        return respuestaLogic.findTotalNumberRespuesta();
    }

    public List<RespuestaDTO> getDataRespuesta() throws Exception {
        return respuestaLogic.getDataRespuesta();
    }

    public void validateRespuesta(Respuesta respuesta) throws Exception {
        respuestaLogic.validateRespuesta(respuesta);
    }

	@Override
	public String preguntaResponde(String pregunta) throws Exception {
		return preguntaLogic.preguntaResponde(pregunta);
	}

	@Override
	public Pregunta ultimaPregunta() throws Exception {
		return respuestaLogic.ultimaPregunta();
	}
}
