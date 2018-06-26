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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "alunof")
@NamedQueries({
    @NamedQuery(name = "Alunof.findAll", query = "SELECT a FROM Alunof a")})
public class Alunof implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_aluno")
    private Integer idAluno;
    @Column(name = "mome_aluno")
    private String momeAluno;
    @Column(name = "e_mail")
    private String eMail;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "celular")
    private String celular;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @Column(name = "estado_sigla")
    private String estadoSigla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunof")
    private List<Aula> aulaList;
    @JoinColumn(name = "nivel_id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne(optional = false)
    private Nivel nivelIdNivel;

    public Alunof() {
    }

    public Alunof(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Alunof(Integer idAluno, String estadoSigla) {
        this.idAluno = idAluno;
        this.estadoSigla = estadoSigla;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getMomeAluno() {
        return momeAluno;
    }

    public void setMomeAluno(String momeAluno) {
        this.momeAluno = momeAluno;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstadoSigla() {
        return estadoSigla;
    }

    public void setEstadoSigla(String estadoSigla) {
        this.estadoSigla = estadoSigla;
    }

    public List<Aula> getAulaList() {
        return aulaList;
    }

    public void setAulaList(List<Aula> aulaList) {
        this.aulaList = aulaList;
    }

    public Nivel getNivelIdNivel() {
        return nivelIdNivel;
    }

    public void setNivelIdNivel(Nivel nivelIdNivel) {
        this.nivelIdNivel = nivelIdNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAluno != null ? idAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alunof)) {
            return false;
        }
        Alunof other = (Alunof) object;
        if ((this.idAluno == null && other.idAluno != null) || (this.idAluno != null && !this.idAluno.equals(other.idAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Alunof[ idAluno=" + idAluno + " ]";
    }
    
}
