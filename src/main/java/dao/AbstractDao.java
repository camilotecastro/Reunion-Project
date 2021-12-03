package dao;

import utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public abstract class AbstractDao<T> implements Dao<T> {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();
    private Class<T> clas;

    @Override
    public List<T> getAll() {
        String sqlString = "FROM " + clas.getName();
        Query query = entityManager.createQuery(sqlString);
        return query.getResultList();
    }

    @Override
    public Optional<T> get(long id) {
        return Optional.ofNullable(entityManager.find(clas,id));
    }

    @Override
    public void save(T t) {
        executableInsideTransaction(entityManager -> entityManager.persist(t));
    }

    @Override
    public void delete(T t) {
        executableInsideTransaction(entityManager -> entityManager.remove(t));
    }

    @Override
    public void update(T t) {
        executableInsideTransaction(entityManager -> entityManager.merge(t));
    }

    public void setClas(Class<T> clas) {
        this.clas = clas;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private void executableInsideTransaction(Consumer<EntityManager> action){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            action.accept(entityManager);
            entityTransaction.commit();
        } catch (RuntimeException e){
            entityTransaction.rollback();
            throw e;
        }
    }
}
