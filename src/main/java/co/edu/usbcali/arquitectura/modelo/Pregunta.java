package co.edu.usbcali.arquitectura.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "pregunta", schema = "public")
public class Pregunta implements java.io.Serializable {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idPregunta;
    @NotNull
    private Categoria categoria;
    @NotNull
    @NotEmpty
    @Size(max = 500)
    private String pregunta;
    private Set<Respuesta> respuestas = new HashSet<Respuesta>(0);
    
    private int numPreguntas;
    private int numRespuestas;
    
    public Pregunta() {
    	this.numPreguntas = 0;
    	this.numRespuestas = 0;
    }

    public Pregunta(Integer idPregunta, Categoria categoria, String pregunta,
        Set<Respuesta> respuestas) {
        this.idPregunta = idPregunta;
        this.categoria = categoria;
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.numPreguntas = 0;
    	this.numRespuestas = 0;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_pregunta", unique = true, nullable = false)
    public Integer getIdPregunta() {
        return this.idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Column(name = "pregunta", nullable = false)
    public String getPregunta() {
        return this.pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pregunta")
    public Set<Respuesta> getRespuestas() {
        return this.respuestas;
    }

    public void setRespuestas(Set<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

	public int getNumPreguntas() {
		return numPreguntas;
	}

	public void setNumPreguntas(int numPreguntas) {
		this.numPreguntas = numPreguntas;
	}

	public int getNumRespuestas() {
		return numRespuestas;
	}

	public void setNumRespuestas(int numRespuestas) {
		this.numRespuestas = numRespuestas;
	}
	
	private static final PreguntaObservable OBSERVABLE;
	   
    static {
        OBSERVABLE = new PreguntaObservable();
    }

    public static Observable getObservable() {
        return OBSERVABLE;
    }
	
	public void contarPreguntas(int iteradorPregunta) {
		Contador evento = new Contador(this, iteradorPregunta, this.numRespuestas);
		this.numPreguntas = iteradorPregunta;
		synchronized (OBSERVABLE) {
            OBSERVABLE.setChanged();
            OBSERVABLE.notifyObservers(evento);            
        }
	}
	
	public void contarRespuestas(int iteradorPregunta, int iteradorRespuesta) {
		Contador evento = new Contador(this, iteradorPregunta, iteradorRespuesta);
		this.numPreguntas = iteradorPregunta;
		this.numRespuestas = iteradorRespuesta;
		synchronized (OBSERVABLE) {
            OBSERVABLE.setChanged();
            OBSERVABLE.notifyObservers(evento);            
        }
	}
	
	private static class PreguntaObservable extends Observable{
		@Override
	    public synchronized void setChanged() {
	        super.setChanged();
	    }
		
	}
    
}
