package co.edu.usbcali.arquitectura.presentation.backingBeans;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import co.edu.usbcali.arquitectura.modelo.Categoria;
import co.edu.usbcali.arquitectura.modelo.Pregunta;
import co.edu.usbcali.arquitectura.modelo.Respuesta;
import co.edu.usbcali.arquitectura.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@ViewScoped
public class CreaPreguntaView {
	private InputText txtPregunta;
	private InputText txtRespuesta;
	private SelectOneMenu somCategoria;
	private CommandButton btnSave;
	private CommandButton btnClear;
	private List<SelectItem> lasCategoriasSelectItem;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	private static final Logger log = LoggerFactory.getLogger(CreaPreguntaView.class);
	
	public String creaPreguntaNueva() {
		try {
			Pregunta pregunta = new Pregunta();
			Respuesta respuesta = new Respuesta();
			pregunta.setPregunta(txtPregunta.getValue().toString());
			Categoria categoria = businessDelegatorView.getCategoria(Integer.parseInt(somCategoria.getValue().toString()));
			pregunta.setCategoria(categoria);
			businessDelegatorView.savePregunta(pregunta);
			
			Pregunta idUltimaPregunta = businessDelegatorView.ultimaPregunta();
			respuesta.setPregunta(idUltimaPregunta);
			
			respuesta.setRespuesta(txtRespuesta.getValue().toString());
			businessDelegatorView.saveRespuesta(respuesta);
			
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Pregunta guardada!", "Su nueva pregunta se ha almacenado en nuestra BD. (:"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "";
	}

	public InputText getTxtPregunta() {
		return txtPregunta;
	}

	public void setTxtPregunta(InputText txtPregunta) {
		this.txtPregunta = txtPregunta;
	}

	public InputText getTxtRespuesta() {
		return txtRespuesta;
	}

	public void setTxtRespuesta(InputText txtRespuesta) {
		this.txtRespuesta = txtRespuesta;
	}

	public SelectOneMenu getSomCategoria() {
		return somCategoria;
	}

	public void setSomCategoria(SelectOneMenu somCategoria) {
		this.somCategoria = somCategoria;
	}

	public List<SelectItem> getLasCategoriasSelectItem() throws Exception {
		if (lasCategoriasSelectItem == null) {
			List<Categoria> lasCategorias = businessDelegatorView.getCategoria();
			lasCategoriasSelectItem = new ArrayList<>();
			for (Categoria categoria : lasCategorias) {
				lasCategoriasSelectItem.add(
						new SelectItem(categoria.getIdCategoria(), categoria.getIdCategoria() + ". " + categoria.getCategoria()));
			}
		}
		return lasCategoriasSelectItem;
	}

	public void setLasCategoriasSelectItem(List<SelectItem> lasCategoriasSelectItem) {
		this.lasCategoriasSelectItem = lasCategoriasSelectItem;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public CommandButton getBtnClear() {
		return btnClear;
	}

	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}
	
}
