package DAOs;

import Entidades.Nivel;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAONivel extends DAOGenerico<Nivel> {

    public DAONivel() {
        super(Nivel.class);
    }

    public int autoIdNivel() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idNivel) FROM Nivel e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Nivel> listByIdNivel(int idNivel) {
        return em.createQuery("SELECT e FROM Nivel e WHERE e.idNivel = :idNivel").setParameter("idNivel", idNivel).getResultList();
    }

    public List<Nivel> listByNomeNivel(String nomeNivel) {
        return em.createQuery("SELECT e FROM Nivel e WHERE e.nomeNivel LIKE :nomeNivel").setParameter("nomeNivel", "%" + nomeNivel + "%").getResultList();
    }

    public List<Nivel> listInOrderIdNivel() {
        return em.createQuery("SELECT e FROM Nivel e ORDER BY e.idNivel").getResultList();
    }

    public List<Nivel> listInOrderNomeNivel() {
        return em.createQuery("SELECT e FROM Nivel e ORDER BY e.nomeNivel").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Nivel> lf;
        if (qualOrdem.equals("idNivel")) {
            lf = listInOrderIdNivel();
        } else {
            lf = listInOrderNomeNivel();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdNivel() + ";" + lf.get(i).getNomeNivel() + ";");
        }
        return ls;
    }
}

