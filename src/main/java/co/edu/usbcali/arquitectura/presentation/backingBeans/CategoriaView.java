package co.edu.usbcali.arquitectura.presentation.backingBeans;

import co.edu.usbcali.arquitectura.exceptions.*;
import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.dto.CategoriaDTO;
import co.edu.usbcali.arquitectura.presentation.businessDelegate.*;
import co.edu.usbcali.arquitectura.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class CategoriaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CategoriaView.class);
    private InputText txtCategoria;
    private InputText txtIdCategoria;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CategoriaDTO> data;
    private CategoriaDTO selectedCategoria;
    private Categoria entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public CategoriaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedCategoria = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedCategoria = null;

        if (txtCategoria != null) {
            txtCategoria.setValue(null);
            txtCategoria.setDisabled(true);
        }

        if (txtIdCategoria != null) {
            txtIdCategoria.setValue(null);
            txtIdCategoria.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Integer idCategoria = FacesUtils.checkInteger(txtIdCategoria);
            entity = (idCategoria != null)
                ? businessDelegatorView.getCategoria(idCategoria) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCategoria.setDisabled(false);
            txtIdCategoria.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCategoria.setValue(entity.getCategoria());
            txtCategoria.setDisabled(false);
            txtIdCategoria.setValue(entity.getIdCategoria());
            txtIdCategoria.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedCategoria = (CategoriaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedCategoria"));
        txtCategoria.setValue(selectedCategoria.getCategoria());
        txtCategoria.setDisabled(false);
        txtIdCategoria.setValue(selectedCategoria.getIdCategoria());
        txtIdCategoria.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedCategoria == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Categoria();

            Integer idCategoria = FacesUtils.checkInteger(txtIdCategoria);

            entity.setCategoria(FacesUtils.checkString(txtCategoria));
            entity.setIdCategoria(idCategoria);
            businessDelegatorView.saveCategoria(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Integer idCategoria = new Integer(selectedCategoria.getIdCategoria());
                entity = businessDelegatorView.getCategoria(idCategoria);
            }

            entity.setCategoria(FacesUtils.checkString(txtCategoria));
            businessDelegatorView.updateCategoria(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedCategoria = (CategoriaDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedCategoria"));

            Integer idCategoria = new Integer(selectedCategoria.getIdCategoria());
            entity = businessDelegatorView.getCategoria(idCategoria);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idCategoria = FacesUtils.checkInteger(txtIdCategoria);
            entity = businessDelegatorView.getCategoria(idCategoria);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteCategoria(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String action_modifyWitDTO(String categoria, Integer idCategoria)
        throws Exception {
        try {
            entity.setCategoria(FacesUtils.checkString(categoria));
            businessDelegatorView.updateCategoria(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CategoriaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtCategoria() {
        return txtCategoria;
    }

    public void setTxtCategoria(InputText txtCategoria) {
        this.txtCategoria = txtCategoria;
    }

    public InputText getTxtIdCategoria() {
        return txtIdCategoria;
    }

    public void setTxtIdCategoria(InputText txtIdCategoria) {
        this.txtIdCategoria = txtIdCategoria;
    }

    public List<CategoriaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataCategoria();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CategoriaDTO> categoriaDTO) {
        this.data = categoriaDTO;
    }

    public CategoriaDTO getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(CategoriaDTO categoria) {
        this.selectedCategoria = categoria;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
