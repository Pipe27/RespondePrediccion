package co.edu.usbcali.arquitectura.modelo.control;

import co.edu.usbcali.arquitectura.modelo.Categoria;
import co.edu.usbcali.arquitectura.modelo.dto.CategoriaDTO;

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
public interface ICategoriaLogic {
    public List<Categoria> getCategoria() throws Exception;

    /**
         * Save an new Categoria entity
         */
    public void saveCategoria(Categoria entity) throws Exception;

    /**
         * Delete an existing Categoria entity
         *
         */
    public void deleteCategoria(Categoria entity) throws Exception;

    /**
        * Update an existing Categoria entity
        *
        */
    public void updateCategoria(Categoria entity) throws Exception;

    /**
         * Load an existing Categoria entity
         *
         */
    public Categoria getCategoria(Integer idCategoria)
        throws Exception;

    public List<Categoria> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Categoria> findPageCategoria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCategoria() throws Exception;

    public List<CategoriaDTO> getDataCategoria() throws Exception;

    public void validateCategoria(Categoria categoria)
        throws Exception;
}
