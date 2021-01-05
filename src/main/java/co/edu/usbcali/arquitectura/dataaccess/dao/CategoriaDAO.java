package co.edu.usbcali.arquitectura.dataaccess.dao;

import co.edu.usbcali.arquitectura.dataaccess.api.JpaDaoImpl;
import co.edu.usbcali.arquitectura.modelo.Categoria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Categoria entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Categoria
 */
@Scope("singleton")
@Repository("CategoriaDAO")
public class CategoriaDAO extends JpaDaoImpl<Categoria, Integer>
    implements ICategoriaDAO {
    private static final Logger log = LoggerFactory.getLogger(CategoriaDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ICategoriaDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ICategoriaDAO) ctx.getBean("CategoriaDAO");
    }
}
