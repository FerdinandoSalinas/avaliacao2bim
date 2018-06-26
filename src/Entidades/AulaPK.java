/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Asus
 */
@Embeddable
public class AulaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "aluno_id_aluno")
    private int alunoIdAluno;
    @Basic(optional = false)
    @Column(name = "professor_id_professor")
    private int professorIdProfessor;
    @Basic(optional = false)
    @Column(name = "instrumento_id_instrumento")
    private int instrumentoIdInstrumento;

    public AulaPK() {
    }

    public AulaPK(int alunoIdAluno, int professorIdProfessor, int instrumentoIdInstrumento) {
        this.alunoIdAluno = alunoIdAluno;
        this.professorIdProfessor = professorIdProfessor;
        this.instrumentoIdInstrumento = instrumentoIdInstrumento;
    }

    public int getAlunoIdAluno() {
        return alunoIdAluno;
    }

    public void setAlunoIdAluno(int alunoIdAluno) {
        this.alunoIdAluno = alunoIdAluno;
    }

    public int getProfessorIdProfessor() {
        return professorIdProfessor;
    }

    public void setProfessorIdProfessor(int professorIdProfessor) {
        this.professorIdProfessor = professorIdProfessor;
    }

    public int getInstrumentoIdInstrumento() {
        return instrumentoIdInstrumento;
    }

    public void setInstrumentoIdInstrumento(int instrumentoIdInstrumento) {
        this.instrumentoIdInstrumento = instrumentoIdInstrumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) alunoIdAluno;
        hash += (int) professorIdProfessor;
        hash += (int) instrumentoIdInstrumento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AulaPK)) {
            return false;
        }
        AulaPK other = (AulaPK) object;
        if (this.alunoIdAluno != other.alunoIdAluno) {
            return false;
        }
        if (this.professorIdProfessor != other.professorIdProfessor) {
            return false;
        }
        if (this.instrumentoIdInstrumento != other.instrumentoIdInstrumento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AulaPK[ alunoIdAluno=" + alunoIdAluno + ", professorIdProfessor=" + professorIdProfessor + ", instrumentoIdInstrumento=" + instrumentoIdInstrumento + " ]";
    }
    
}
