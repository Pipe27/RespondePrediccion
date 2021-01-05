package co.edu.usbcali.arquitectura.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "respuesta", schema = "public")
public class Respuesta implements java.io.Serializable {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idRespuesta;
    @NotNull
    private Pregunta pregunta;
    @NotNull
    @NotEmpty
    @Size(max = 500)
    private String respuesta;

    public Respuesta() {
    }

    public Respuesta(Integer idRespuesta, Pregunta pregunta, String respuesta) {
        this.idRespuesta = idRespuesta;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_respuesta", unique = true, nullable = false)
    public Integer getIdRespuesta() {
        return this.idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta")
    public Pregunta getPregunta() {
        return this.pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Column(name = "respuesta", nullable = false)
    public String getRespuesta() {
        return this.respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
