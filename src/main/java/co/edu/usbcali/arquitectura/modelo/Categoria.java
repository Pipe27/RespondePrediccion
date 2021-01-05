package co.edu.usbcali.arquitectura.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "categoria", schema = "public")
public class Categoria implements java.io.Serializable {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCategoria;
    @NotNull
    @NotEmpty
    @Size(max = 500)
    private String categoria;
    private Set<Pregunta> preguntas = new HashSet<Pregunta>(0);

    public Categoria() {
    }

    public Categoria(Integer idCategoria, String categoria,
        Set<Pregunta> preguntas) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.preguntas = preguntas;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_categoria", unique = true, nullable = false)
    public Integer getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Column(name = "categoria", nullable = false)
    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
    public Set<Pregunta> getPreguntas() {
        return this.preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
