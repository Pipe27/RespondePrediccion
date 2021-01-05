package co.edu.usbcali.arquitectura.presentation.backingBeans;

import co.edu.usbcali.arquitectura.exceptions.*;
import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.dto.RespuestaDTO;
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
public class RespuestaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RespuestaView.class);
    private InputText txtRespuesta;
    private InputText txtIdPregunta_Pregunta;
    private InputText txtIdRespuesta;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RespuestaDTO> data;
    private RespuestaDTO selectedRespuesta;
    private Respuesta entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public RespuestaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedRespuesta = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedRespuesta = null;

        if (txtRespuesta != null) {
            txtRespuesta.setValue(null);
            txtRespuesta.setDisabled(true);
        }

        if (txtIdPregunta_Pregunta != null) {
            txtIdPregunta_Pregunta.setValue(null);
            txtIdPregunta_Pregunta.setDisabled(true);
        }

        if (txtIdRespuesta != null) {
            txtIdRespuesta.setValue(null);
            txtIdRespuesta.setDisabled(false);
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
            Integer idRespuesta = FacesUtils.checkInteger(txtIdRespuesta);
            entity = (idRespuesta != null)
                ? businessDelegatorView.getRespuesta(idRespuesta) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtRespuesta.setDisabled(false);
            txtIdPregunta_Pregunta.setDisabled(false);
            txtIdRespuesta.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtRespuesta.setValue(entity.getRespuesta());
            txtRespuesta.setDisabled(false);
            txtIdPregunta_Pregunta.setValue(entity.getPregunta().getIdPregunta());
            txtIdPregunta_Pregunta.setDisabled(false);
            txtIdRespuesta.setValue(entity.getIdRespuesta());
            txtIdRespuesta.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedRespuesta = (RespuestaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedRespuesta"));
        txtRespuesta.setValue(selectedRespuesta.getRespuesta());
        txtRespuesta.setDisabled(false);
        txtIdPregunta_Pregunta.setValue(selectedRespuesta.getIdPregunta_Pregunta());
        txtIdPregunta_Pregunta.setDisabled(false);
        txtIdRespuesta.setValue(selectedRespuesta.getIdRespuesta());
        txtIdRespuesta.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedRespuesta == null) && (entity == null)) {
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
            entity = new Respuesta();

            Integer idRespuesta = FacesUtils.checkInteger(txtIdRespuesta);

            entity.setIdRespuesta(idRespuesta);
            entity.setRespuesta(FacesUtils.checkString(txtRespuesta));
            entity.setPregunta((FacesUtils.checkInteger(txtIdPregunta_Pregunta) != null)
                ? businessDelegatorView.getPregunta(FacesUtils.checkInteger(
                        txtIdPregunta_Pregunta)) : null);
            businessDelegatorView.saveRespuesta(entity);
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
                Integer idRespuesta = new Integer(selectedRespuesta.getIdRespuesta());
                entity = businessDelegatorView.getRespuesta(idRespuesta);
            }

            entity.setRespuesta(FacesUtils.checkString(txtRespuesta));
            entity.setPregunta((FacesUtils.checkInteger(txtIdPregunta_Pregunta) != null)
                ? businessDelegatorView.getPregunta(FacesUtils.checkInteger(
                        txtIdPregunta_Pregunta)) : null);
            businessDelegatorView.updateRespuesta(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedRespuesta = (RespuestaDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedRespuesta"));

            Integer idRespuesta = new Integer(selectedRespuesta.getIdRespuesta());
            entity = businessDelegatorView.getRespuesta(idRespuesta);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idRespuesta = FacesUtils.checkInteger(txtIdRespuesta);
            entity = businessDelegatorView.getRespuesta(idRespuesta);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteRespuesta(entity);
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

    public String action_modifyWitDTO(Integer idRespuesta, String respuesta,
        Integer idPregunta_Pregunta) throws Exception {
        try {
            entity.setRespuesta(FacesUtils.checkString(respuesta));
            businessDelegatorView.updateRespuesta(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RespuestaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtRespuesta() {
        return txtRespuesta;
    }

    public void setTxtRespuesta(InputText txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
    }

    public InputText getTxtIdPregunta_Pregunta() {
        return txtIdPregunta_Pregunta;
    }

    public void setTxtIdPregunta_Pregunta(InputText txtIdPregunta_Pregunta) {
        this.txtIdPregunta_Pregunta = txtIdPregunta_Pregunta;
    }

    public InputText getTxtIdRespuesta() {
        return txtIdRespuesta;
    }

    public void setTxtIdRespuesta(InputText txtIdRespuesta) {
        this.txtIdRespuesta = txtIdRespuesta;
    }

    public List<RespuestaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRespuesta();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RespuestaDTO> respuestaDTO) {
        this.data = respuestaDTO;
    }

    public RespuestaDTO getSelectedRespuesta() {
        return selectedRespuesta;
    }

    public void setSelectedRespuesta(RespuestaDTO respuesta) {
        this.selectedRespuesta = respuesta;
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
