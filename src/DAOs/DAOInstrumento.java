package DAOs;

import Entidades.Instrumento;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOInstrumento extends DAOGenerico<Instrumento> {

    public DAOInstrumento() {
        super(Instrumento.class);
    }

    public int autoIdInstrumento() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idInstrumento) FROM Instrumento e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Instrumento> listByIdInstrumento(int idInstrumento) {
        return em.createQuery("SELECT e FROM Instrumento e WHERE e.idInstrumento = :idInstrumento").setParameter("idInstrumento", idInstrumento).getResultList();
    }

    public List<Instrumento> listByNomeInstrumento(String nomeInstrumento) {
        return em.createQuery("SELECT e FROM Instrumento e WHERE e.nomeInstrumento LIKE :nomeInstrumento").setParameter("nomeInstrumento", "%" + nomeInstrumento + "%").getResultList();
    }

    public List<Instrumento> listInOrderIdInstrumento() {
        return em.createQuery("SELECT e FROM Instrumento e ORDER BY e.idInstrumento").getResultList();
    }

    public List<Instrumento> listInOrderNomeInstrumento() {
        return em.createQuery("SELECT e FROM Instrumento e ORDER BY e.nomeInstrumento").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Instrumento> lf;
        if (qualOrdem.equals("idInstrumento")) {
            lf = listInOrderIdInstrumento();
        } else {
            lf = listInOrderNomeInstrumento();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdInstrumento() + ";" + lf.get(i).getNomeInstrumento() + ";" + lf.get(i).getValorHoraAula() + ";");
        }
        return ls;
    }
}

