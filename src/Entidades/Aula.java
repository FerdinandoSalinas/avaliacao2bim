/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "aula")
@NamedQueries({
    @NamedQuery(name = "Aula.findAll", query = "SELECT a FROM Aula a")})
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AulaPK aulaPK;
    @Basic(optional = false)
    @Column(name = "data_aula")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAula;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_fim")
    @Temporal(TemporalType.TIME)
    private Date horaFim;
    @Column(name = "aluno_compareceu")
    private Boolean alunoCompareceu;
    @Column(name = "observacoes_dessa_aula")
    private String observacoesDessaAula;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_hora_aula")
    private Double valorHoraAula;
    @JoinColumn(name = "aluno_id_aluno", referencedColumnName = "id_aluno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alunof alunof;
    @JoinColumn(name = "professor_id_professor", referencedColumnName = "id_professor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Professor professor;
    @JoinColumn(name = "instrumento_id_instrumento", referencedColumnName = "id_instrumento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Instrumento instrumento;

    public Aula() {
    }

    public Aula(AulaPK aulaPK) {
        this.aulaPK = aulaPK;
    }

    public Aula(AulaPK aulaPK, Date dataAula) {
        this.aulaPK = aulaPK;
        this.dataAula = dataAula;
    }

    public Aula(int alunoIdAluno, int professorIdProfessor, int instrumentoIdInstrumento) {
        this.aulaPK = new AulaPK(alunoIdAluno, professorIdProfessor, instrumentoIdInstrumento);
    }

    public AulaPK getAulaPK() {
        return aulaPK;
    }

    public void setAulaPK(AulaPK aulaPK) {
        this.aulaPK = aulaPK;
    }

    public Date getDataAula() {
        return dataAula;
    }

    public void setDataAula(Date dataAula) {
        this.dataAula = dataAula;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public Boolean getAlunoCompareceu() {
        return alunoCompareceu;
    }

    public void setAlunoCompareceu(Boolean alunoCompareceu) {
        this.alunoCompareceu = alunoCompareceu;
    }

    public String getObservacoesDessaAula() {
        return observacoesDessaAula;
    }

    public void setObservacoesDessaAula(String observacoesDessaAula) {
        this.observacoesDessaAula = observacoesDessaAula;
    }

    public Double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(Double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    public Alunof getAlunof() {
        return alunof;
    }

    public void setAlunof(Alunof alunof) {
        this.alunof = alunof;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aulaPK != null ? aulaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.aulaPK == null && other.aulaPK != null) || (this.aulaPK != null && !this.aulaPK.equals(other.aulaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Aula[ aulaPK=" + aulaPK + " ]";
    }
    
}
