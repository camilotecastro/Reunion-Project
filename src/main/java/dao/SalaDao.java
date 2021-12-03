package dao;

import model.Sala;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class SalaDao extends AbstractDao<Sala>{

    public SalaDao(){
        setClas(Sala.class);
    }

    //Encontrar sala por capacidad
    public List<Sala> findSalaByCapacity(int num){
        String sqlQuery = "FROM " + Sala.class.getName() + " WHERE capacidad >= ?1";
        Query query = getEntityManager().createQuery(sqlQuery);
        query.setParameter(1,num);
        return query.getResultList();
    }

    // Criterios 1
    public List<Sala> findSalaByCapacity2(int num){
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Sala> criteriaQuery = criteriaBuilder.createQuery(Sala.class);
        Root<Sala> root = criteriaQuery.from(Sala.class);
        criteriaQuery.select(root).where(criteriaBuilder.ge(root.get("capacidad"),num));
        Query query = getEntityManager().createQuery(criteriaQuery);
        return query.getResultList();
    }
}
