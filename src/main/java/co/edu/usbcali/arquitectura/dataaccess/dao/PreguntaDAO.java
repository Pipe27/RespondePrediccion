package co.edu.usbcali.arquitectura.dataaccess.dao;

import co.edu.usbcali.arquitectura.dataaccess.api.JpaDaoImpl;
import co.edu.usbcali.arquitectura.modelo.Pregunta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Pregunta entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Pregunta
 */
@Scope("singleton")
@Repository("PreguntaDAO")
public class PreguntaDAO extends JpaDaoImpl<Pregunta, Integer>
    implements IPreguntaDAO {
    private static final Logger log = LoggerFactory.getLogger(PreguntaDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IPreguntaDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IPreguntaDAO) ctx.getBean("PreguntaDAO");
    }

	@Override
	public Integer consultarPreguntaBD(String pregunta) {
		String sql = "SELECT p.id_pregunta FROM Pregunta p WHERE p.pregunta LIKE '%" + pregunta + "%'";
		//return (Pregunta) entityManager.createQuery(sql).getSingleResult();
		return (Integer) entityManager.createNativeQuery(sql).getSingleResult();
	}

	@Override
	public List<String> consultarTodasLasPreguntas() {
		String sql = "SELECT p.pregunta FROM Pregunta p";
		return (List<String>) entityManager.createQuery(sql).getResultList();
	}
}
