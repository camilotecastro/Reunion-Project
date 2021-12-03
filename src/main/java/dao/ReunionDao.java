package dao;

import model.Reunion;

import javax.persistence.Query;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ReunionDao extends AbstractDao<Reunion>{

    public ReunionDao(){
        setClas(Reunion.class);
    }

    public Reunion nextReunion(){
        //funcion now() sirve para saber la fecha actual
        String sqlString = "FROM " + Reunion.class.getName() + " WHERE fecha > now() order by fecha ";
        Query query = getEntityManager().createQuery(sqlString).setMaxResults(1);
        return (Reunion) query.getSingleResult(); // solo quiero un resultado
    }

    public List<Reunion> tomorrowMeetings(){
        String sqlString  = "FROM " + Reunion.class.getName() + " WHERE fecha between ?1 and ?2";
        Query query = getEntityManager().createQuery(sqlString);
        LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);
        query.setParameter(1,tomorrow.atStartOfDay());
        query.setParameter(2,tomorrow.plus(1,ChronoUnit.DAYS).atStartOfDay());
        return query.getResultList();
    }
}
