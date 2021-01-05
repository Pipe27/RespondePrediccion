package co.edu.usbcali.arquitectura.presentation.backingBeans;



import java.util.Observer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.arquitectura.modelo.Pregunta;
import co.edu.usbcali.arquitectura.presentation.businessDelegate.IBusinessDelegatorView;


@ManagedBean
@ViewScoped
public class RealizarPreguntaObserverView {
	
	private static final Logger log = LoggerFactory.getLogger(RealizarPreguntaObserverView.class);
	
	Pregunta preg = new Pregunta();
	Observer o1 = new ContadorView();
	
	private InputText txtPregunta;
	private String txtRespuesta;
	
	
	private CommandButton btnExecuteAction;
	private CommandButton btnFindAction;
	private CommandButton btnClearAction;
	
	
	@ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    
	
	
	public RealizarPreguntaObserverView() {
		super();
		Pregunta.getObservable().addObserver(o1);
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
	
	public CommandButton getBtnExecuteAction() {
		return btnExecuteAction;
	}


	public void setBtnExecuteAction(CommandButton btnExecuteAction) {
		this.btnExecuteAction = btnExecuteAction;
	}


	public CommandButton getBtnFindAction() {
		return btnFindAction;
	}


	public void setBtnFindAction(CommandButton btnFindAction) {
		this.btnFindAction = btnFindAction;
	}


	public CommandButton getBtnClearAction() {
		return btnClearAction;
	}


	public void setBtnClearAction(CommandButton btnClearAction) {
		this.btnClearAction = btnClearAction;
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
	
	public String ExecuteAction() throws Exception {
		
		if(businessDelegatorView.preguntaResponde(txtPregunta.getValue().toString()).equalsIgnoreCase("No hay una respuesta para su pregunta") ) {
			txtRespuesta = businessDelegatorView.preguntaResponde(txtPregunta.getValue().toString());
			log.info("/*/*/*/*/ PREGUNTA " + txtPregunta.getValue().toString());
			log.info("/*/*/*/*/ RESPUESTA " + businessDelegatorView.preguntaResponde(txtPregunta.getValue().toString()));
			preg.contarPreguntas(preg.getNumPreguntas()+1);
			
			
			
		}else {
			
			log.info("/*/*/*/*/ RESPUESTA " + businessDelegatorView.preguntaResponde(txtPregunta.getValue().toString()));
			txtRespuesta = businessDelegatorView.preguntaResponde(txtPregunta.getValue().toString());
			preg.contarRespuestas(preg.getNumPreguntas()+1, preg.getNumRespuestas()+1);
		}
		
		
		return ""; 
	}
	
	
}
