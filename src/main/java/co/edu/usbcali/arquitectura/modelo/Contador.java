package co.edu.usbcali.arquitectura.modelo;

public class Contador {
	private Pregunta pregunta;
	private int preguntas;
    private int respuestas;
    
    public Contador(Pregunta pregunta, int preguntas, int respuestas) {
		super();
		this.pregunta = pregunta;
		this.preguntas = preguntas;
		this.respuestas = respuestas;
	}
    
    public int getPreguntas() {
		return preguntas;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public int getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(int respuestas) {
		this.respuestas = respuestas;
	}

	public void setPreguntas(int preguntas) {
		this.preguntas = preguntas;
	} 
}
