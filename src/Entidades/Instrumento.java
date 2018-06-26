/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "instrumento")
@NamedQueries({
    @NamedQuery(name = "Instrumento.findAll", query = "SELECT i FROM Instrumento i")})
public class Instrumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_instrumento")
    private Integer idInstrumento;
    @Column(name = "nome_instrumento")
    private String nomeInstrumento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_hora_aula")
    private Double valorHoraAula;
    @JoinTable(name = "professor_has_instrumento", joinColumns = {
        @JoinColumn(name = "instrumento_id_instrumento", referencedColumnName = "id_instrumento")}, inverseJoinColumns = {
        @JoinColumn(name = "professor_id_professor", referencedColumnName = "id_professor")})
    @ManyToMany
    private List<Professor> professorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instrumento")
    private List<Aula> aulaList;

    public Instrumento() {
    }

    public Instrumento(Integer idInstrumento) {
        this.idInstrumento = idInstrumento;
    }

    public Integer getIdInstrumento() {
        return idInstrumento;
    }

    public void setIdInstrumento(Integer idInstrumento) {
        this.idInstrumento = idInstrumento;
    }

    public String getNomeInstrumento() {
        return nomeInstrumento;
    }

    public void setNomeInstrumento(String nomeInstrumento) {
        this.nomeInstrumento = nomeInstrumento;
    }

    public Double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(Double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }

    public List<Aula> getAulaList() {
        return aulaList;
    }

    public void setAulaList(List<Aula> aulaList) {
        this.aulaList = aulaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstrumento != null ? idInstrumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrumento)) {
            return false;
        }
        Instrumento other = (Instrumento) object;
        if ((this.idInstrumento == null && other.idInstrumento != null) || (this.idInstrumento != null && !this.idInstrumento.equals(other.idInstrumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Instrumento[ idInstrumento=" + idInstrumento + " ]";
    }
    
}
