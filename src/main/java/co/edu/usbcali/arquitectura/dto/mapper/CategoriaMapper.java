package co.edu.usbcali.arquitectura.dto.mapper;

import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.Categoria;
import co.edu.usbcali.arquitectura.modelo.control.*;
import co.edu.usbcali.arquitectura.modelo.dto.CategoriaDTO;

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
public class CategoriaMapper implements ICategoriaMapper {
    private static final Logger log = LoggerFactory.getLogger(CategoriaMapper.class);

    @Transactional(readOnly = true)
    public CategoriaDTO categoriaToCategoriaDTO(Categoria categoria)
        throws Exception {
        try {
            CategoriaDTO categoriaDTO = new CategoriaDTO();

            categoriaDTO.setIdCategoria(categoria.getIdCategoria());
            categoriaDTO.setCategoria((categoria.getCategoria() != null)
                ? categoria.getCategoria() : null);

            return categoriaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO)
        throws Exception {
        try {
            Categoria categoria = new Categoria();

            categoria.setIdCategoria(categoriaDTO.getIdCategoria());
            categoria.setCategoria((categoriaDTO.getCategoria() != null)
                ? categoriaDTO.getCategoria() : null);

            return categoria;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CategoriaDTO> listCategoriaToListCategoriaDTO(
        List<Categoria> listCategoria) throws Exception {
        try {
            List<CategoriaDTO> categoriaDTOs = new ArrayList<CategoriaDTO>();

            for (Categoria categoria : listCategoria) {
                CategoriaDTO categoriaDTO = categoriaToCategoriaDTO(categoria);

                categoriaDTOs.add(categoriaDTO);
            }

            return categoriaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Categoria> listCategoriaDTOToListCategoria(
        List<CategoriaDTO> listCategoriaDTO) throws Exception {
        try {
            List<Categoria> listCategoria = new ArrayList<Categoria>();

            for (CategoriaDTO categoriaDTO : listCategoriaDTO) {
                Categoria categoria = categoriaDTOToCategoria(categoriaDTO);

                listCategoria.add(categoria);
            }

            return listCategoria;
        } catch (Exception e) {
            throw e;
        }
    }
}
