package co.edu.usbcali.arquitectura.presentation.backingBeans;

import java.util.Observable;
import java.util.Observer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.usbcali.arquitectura.modelo.Contador;

@ManagedBean
@ViewScoped
public class ContadorView implements Observer{
	

	public ContadorView() {
		super();
	}

	@Override
	@SuppressWarnings("unchecked")
	public void update(Observable o, Object arg) {
		if (arg instanceof Contador) {
        	Contador evento = (Contador) arg;
            System.out.printf("\nPreguntas realizadas: " + evento.getPreguntas() + " - Preguntas respondidas: " + evento.getRespuestas() + "\n");
        }
		
	}

}
