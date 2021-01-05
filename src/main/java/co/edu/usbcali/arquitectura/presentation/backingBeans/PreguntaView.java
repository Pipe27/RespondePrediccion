package co.edu.usbcali.arquitectura.presentation.backingBeans;

import co.edu.usbcali.arquitectura.exceptions.*;
import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.dto.PreguntaDTO;
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
public class PreguntaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PreguntaView.class);
    private InputText txtPregunta;
    private InputText txtIdCategoria_Categoria;
    private InputText txtIdPregunta;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<PreguntaDTO> data;
    private PreguntaDTO selectedPregunta;
    private Pregunta entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public PreguntaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedPregunta = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedPregunta = null;

        if (txtPregunta != null) {
            txtPregunta.setValue(null);
            txtPregunta.setDisabled(true);
        }

        if (txtIdCategoria_Categoria != null) {
            txtIdCategoria_Categoria.setValue(null);
            txtIdCategoria_Categoria.setDisabled(true);
        }

        if (txtIdPregunta != null) {
            txtIdPregunta.setValue(null);
            txtIdPregunta.setDisabled(false);
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
            Integer idPregunta = FacesUtils.checkInteger(txtIdPregunta);
            entity = (idPregunta != null)
                ? businessDelegatorView.getPregunta(idPregunta) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtPregunta.setDisabled(false);
            txtIdCategoria_Categoria.setDisabled(false);
            txtIdPregunta.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtPregunta.setValue(entity.getPregunta());
            txtPregunta.setDisabled(false);
            txtIdCategoria_Categoria.setValue(entity.getCategoria()
                                                    .getIdCategoria());
            txtIdCategoria_Categoria.setDisabled(false);
            txtIdPregunta.setValue(entity.getIdPregunta());
            txtIdPregunta.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedPregunta = (PreguntaDTO) (evt.getComponent().getAttributes()
                                             .get("selectedPregunta"));
        txtPregunta.setValue(selectedPregunta.getPregunta());
        txtPregunta.setDisabled(false);
        txtIdCategoria_Categoria.setValue(selectedPregunta.getIdCategoria_Categoria());
        txtIdCategoria_Categoria.setDisabled(false);
        txtIdPregunta.setValue(selectedPregunta.getIdPregunta());
        txtIdPregunta.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedPregunta == null) && (entity == null)) {
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
            entity = new Pregunta();

            Integer idPregunta = FacesUtils.checkInteger(txtIdPregunta);

            entity.setIdPregunta(idPregunta);
            entity.setPregunta(FacesUtils.checkString(txtPregunta));
            entity.setCategoria((FacesUtils.checkInteger(
                    txtIdCategoria_Categoria) != null)
                ? businessDelegatorView.getCategoria(FacesUtils.checkInteger(
                        txtIdCategoria_Categoria)) : null);
            businessDelegatorView.savePregunta(entity);
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
                Integer idPregunta = new Integer(selectedPregunta.getIdPregunta());
                entity = businessDelegatorView.getPregunta(idPregunta);
            }

            entity.setPregunta(FacesUtils.checkString(txtPregunta));
            entity.setCategoria((FacesUtils.checkInteger(
                    txtIdCategoria_Categoria) != null)
                ? businessDelegatorView.getCategoria(FacesUtils.checkInteger(
                        txtIdCategoria_Categoria)) : null);
            businessDelegatorView.updatePregunta(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedPregunta = (PreguntaDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedPregunta"));

            Integer idPregunta = new Integer(selectedPregunta.getIdPregunta());
            entity = businessDelegatorView.getPregunta(idPregunta);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idPregunta = FacesUtils.checkInteger(txtIdPregunta);
            entity = businessDelegatorView.getPregunta(idPregunta);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deletePregunta(entity);
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

    public String action_modifyWitDTO(Integer idPregunta, String pregunta,
        Integer idCategoria_Categoria) throws Exception {
        try {
            entity.setPregunta(FacesUtils.checkString(pregunta));
            businessDelegatorView.updatePregunta(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("PreguntaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtPregunta() {
        return txtPregunta;
    }

    public void setTxtPregunta(InputText txtPregunta) {
        this.txtPregunta = txtPregunta;
    }

    public InputText getTxtIdCategoria_Categoria() {
        return txtIdCategoria_Categoria;
    }

    public void setTxtIdCategoria_Categoria(InputText txtIdCategoria_Categoria) {
        this.txtIdCategoria_Categoria = txtIdCategoria_Categoria;
    }

    public InputText getTxtIdPregunta() {
        return txtIdPregunta;
    }

    public void setTxtIdPregunta(InputText txtIdPregunta) {
        this.txtIdPregunta = txtIdPregunta;
    }

    public List<PreguntaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataPregunta();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<PreguntaDTO> preguntaDTO) {
        this.data = preguntaDTO;
    }

    public PreguntaDTO getSelectedPregunta() {
        return selectedPregunta;
    }

    public void setSelectedPregunta(PreguntaDTO pregunta) {
        this.selectedPregunta = pregunta;
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
