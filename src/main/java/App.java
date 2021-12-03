import dao.ActaDao;
import dao.ReunionDao;
import dao.SalaDao;
import model.Acta;
import model.Persona;
import model.Reunion;
import model.Sala;

import javax.persistence.NoResultException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class App {
    public static void main(String[] args) {

        // Daos
        ReunionDao reunionDao = new ReunionDao();
        SalaDao salaDao = new SalaDao();
        ActaDao actaDao = new ActaDao();

        // Creación de objetos
        Sala s01 = new Sala("s1","Sala testing",15);
        Sala s02 = new Sala("s2","Sala de desarrollo", 10);
        Sala s03 = new Sala("s3","Sala de diseño", 20);
        Sala s04 = new Sala("s4", "Sala de juntas", 2);

        salaDao.save(s01);
        salaDao.save(s02);
        salaDao.save(s03);

        Persona p1 = new Persona("P1","Camilo Andres","Castro");
        Persona p2 = new Persona("P2","Andres","Mesa");
        Persona p3 = new Persona("P3","Pepito","Perez");

        Reunion r0 = new Reunion(LocalDateTime.now(),"Reunion Test");
        Reunion r1 = new Reunion(LocalDateTime.now().plus(2,ChronoUnit.HOURS),"Reunion Test");
        Reunion r2 = new Reunion(LocalDateTime.now().plus(2,ChronoUnit.DAYS),"Reunion Web");
        Reunion r3 = new Reunion(LocalDateTime.now().plus(2,ChronoUnit.DAYS),"Reunion Diseño");

        r0.addParticipante(p1);
        r0.setSala(s01);
        reunionDao.save(r0);
        Acta a0 = new Acta("Camilo se reune solo para testear", r0);
        actaDao.save(a0);
        reunionDao.update(r0);

        r1.addParticipante(p1);
        r1.addParticipante(p2);
        r1.addParticipante(p3);
        r1.setSala(s02);
        reunionDao.save(r1);

        r2.addParticipante(p3);
        r2.addParticipante(p1);
        r2.setSala(s03);
        reunionDao.save(r2);

        r3.addParticipante(p2);
        r3.addParticipante(p3);
        r3.setSala(s04);

        reunionDao.save(r3);

        // Recuperar Datos


    }
}
