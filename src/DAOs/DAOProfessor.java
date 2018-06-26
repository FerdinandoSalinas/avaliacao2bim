package DAOs;

import Entidades.Professor;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOProfessor extends DAOGenerico<Professor> {

    public DAOProfessor() {
        super(Professor.class);
    }

    public int autoIdProfessor() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idProfessor) FROM Professor e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Professor> listByIdProfessor(int idProfessor) {
        return em.createQuery("SELECT e FROM Professor e WHERE e.idProfessor = :idProfessor").setParameter("idProfessor", idProfessor).getResultList();
    }

    public List<Professor> listByNomeProfessor(String nomeProfessor) {
        return em.createQuery("SELECT e FROM Professor e WHERE e.nomeProfessor LIKE :nomeProfessor").setParameter("nomeProfessor", "%" + nomeProfessor + "%").getResultList();
    }

    public List<Professor> listInOrderIdProfessor() {
        return em.createQuery("SELECT e FROM Professor e ORDER BY e.idProfessor").getResultList();
    }

    public List<Professor> listInOrderNomeProfessor() {
        return em.createQuery("SELECT e FROM Professor e ORDER BY e.nomeProfessor").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Professor> lf;
        if (qualOrdem.equals("idProfessor")) {
            lf = listInOrderIdProfessor();
        } else {
            lf = listInOrderNomeProfessor();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdProfessor() + ";" + lf.get(i).getNomeProfessor() + ";");
        }
        return ls;
    }
}

