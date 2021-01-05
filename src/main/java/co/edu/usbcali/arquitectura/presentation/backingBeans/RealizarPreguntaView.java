package co.edu.usbcali.arquitectura.presentation.backingBeans;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import co.edu.usbcali.arquitectura.modelo.Respuesta;
import co.edu.usbcali.arquitectura.presentation.businessDelegate.IBusinessDelegatorView;


@ManagedBean
@ViewScoped
public class RealizarPreguntaView {
	
	private InputText txtPregunta;
	private String txtRespuesta;
	
	private CommandButton btnFind;
	private CommandButton btnClear;
	
	
	@ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    
	
	
	public RealizarPreguntaView() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public InputText getTxtPregunta() {
		return txtPregunta;
	}
	public void setTxtPregunta(InputText txtPregunta) {
		this.txtPregunta = txtPregunta;
	}
	public String getTxtRespuesta() throws Exception{
		
		//txtRespuesta = businessDelegatorView.preguntaResponde((txtPregunta.toString()));
		
		return txtRespuesta;
	}
	public void setTxtRespuesta(String txtRespuesta) {
		this.txtRespuesta = txtRespuesta;
	}
	public CommandButton getBtnFind() {
		return btnFind;
	}
	public void setBtnFind(CommandButton btnFind) {
		this.btnFind = btnFind;
	}
	public CommandButton getBtnClear() {
		return btnClear;
	}
	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}
	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}
	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}


	public String ClearAction() {
		txtPregunta.resetValue();
		txtRespuesta = "";

		
		return "";
	}
	
	public String FindAction() throws Exception {
		
		
			//String respuesta = businessDelegatorView.preguntaResponde(txtPregunta.getValue().toString());
			//txtRespuesta = respuesta;
		
		
		
		return "";
	}
		

}
