/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrodelivros;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author renato
 */
@Entity
@Table(name = "teste", catalog = "Livro", schema = "")
@NamedQueries({
    @NamedQuery(name = "Teste.findAll", query = "SELECT t FROM Teste t"),
    @NamedQuery(name = "Teste.findById", query = "SELECT t FROM Teste t WHERE t.id = :id"),
    @NamedQuery(name = "Teste.findByNomeLivro", query = "SELECT t FROM Teste t WHERE t.nomeLivro = :nomeLivro"),
    @NamedQuery(name = "Teste.findByNomeAutor", query = "SELECT t FROM Teste t WHERE t.nomeAutor = :nomeAutor"),
    @NamedQuery(name = "Teste.findByNomeEditora", query = "SELECT t FROM Teste t WHERE t.nomeEditora = :nomeEditora"),
    @NamedQuery(name = "Teste.findByGenero", query = "SELECT t FROM Teste t WHERE t.genero = :genero"),
    @NamedQuery(name = "Teste.findByNota", query = "SELECT t FROM Teste t WHERE t.nota = :nota")})
public class Teste implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NomeLivro")
    private String nomeLivro;
    @Basic(optional = false)
    @Column(name = "NomeAutor")
    private String nomeAutor;
    @Basic(optional = false)
    @Column(name = "NomeEditora")
    private String nomeEditora;
    @Basic(optional = false)
    @Column(name = "Genero")
    private String genero;
    @Basic(optional = false)
    @Lob
    @Column(name = "Comentarios")
    private String comentarios;
    @Basic(optional = false)
    @Column(name = "Nota")
    private int nota;

    public Teste() {
    }

    public Teste(Integer id) {
        this.id = id;
    }

    public Teste(Integer id, String nomeLivro, String nomeAutor, String nomeEditora, String genero, String comentarios, int nota) {
        this.id = id;
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
        this.nomeEditora = nomeEditora;
        this.genero = genero;
        this.comentarios = comentarios;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        String oldNomeLivro = this.nomeLivro;
        this.nomeLivro = nomeLivro;
        changeSupport.firePropertyChange("nomeLivro", oldNomeLivro, nomeLivro);
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        String oldNomeAutor = this.nomeAutor;
        this.nomeAutor = nomeAutor;
        changeSupport.firePropertyChange("nomeAutor", oldNomeAutor, nomeAutor);
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        String oldNomeEditora = this.nomeEditora;
        this.nomeEditora = nomeEditora;
        changeSupport.firePropertyChange("nomeEditora", oldNomeEditora, nomeEditora);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        String oldGenero = this.genero;
        this.genero = genero;
        changeSupport.firePropertyChange("genero", oldGenero, genero);
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        String oldComentarios = this.comentarios;
        this.comentarios = comentarios;
        changeSupport.firePropertyChange("comentarios", oldComentarios, comentarios);
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        int oldNota = this.nota;
        this.nota = nota;
        changeSupport.firePropertyChange("nota", oldNota, nota);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teste)) {
            return false;
        }
        Teste other = (Teste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastrodelivros.Teste[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
