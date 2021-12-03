import dao.SalaDao;
import model.Sala;

import java.util.List;

public class AppConsultas {
    public static void main(String[] args) {
        SalaDao salaDao = new SalaDao();
        List<Sala> salasPara20 = salaDao.findSalaByCapacity(21);
        System.out.println("Salas para 20:" + salasPara20);
    }
}
