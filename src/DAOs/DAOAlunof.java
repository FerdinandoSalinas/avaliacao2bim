package DAOs;

import Entidades.Alunof;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOAlunof extends DAOGenerico<Alunof> {

    public DAOAlunof() {
        super(Alunof.class);
    }

    public int autoIdAlunof() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idAluno) FROM Alunof e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Alunof> listByIdAluno(int idAluno) {
        return em.createQuery("SELECT e FROM Alunof e WHERE e.idAluno = :idAluno").setParameter("idAluno", idAluno).getResultList();
    }

    public List<Alunof> listByMomeAluno(String momeAluno) {
        return em.createQuery("SELECT e FROM Alunof e WHERE e.momeAluno LIKE :momeAluno").setParameter("momeAluno", "%" + momeAluno + "%").getResultList();
    }

    public List<Alunof> listInOrderIdAluno() {
        return em.createQuery("SELECT e FROM Alunof e ORDER BY e.idAluno").getResultList();
    }

    public List<Alunof> listInOrderMomeAluno() {
        return em.createQuery("SELECT e FROM Alunof e ORDER BY e.momeAluno").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Alunof> lf;
        if (qualOrdem.equals("idAluno")) {
            lf = listInOrderIdAluno();
        } else {
            lf = listInOrderMomeAluno();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdAluno() + ";" + lf.get(i).getMomeAluno() + ";" + lf.get(i).getEMail() + ";" + lf.get(i).getTelefone() + ";" + lf.get(i).getCelular() + ";" + lf.get(i).getEndereco() + ";" + lf.get(i).getBairro() + ";" + lf.get(i).getCidade() + ";" + lf.get(i).getCep() + ";" + lf.get(i).getNivelIdNivel() + ";" + lf.get(i).getEstadoSigla() + ";");
        }
        return ls;
    }
}

