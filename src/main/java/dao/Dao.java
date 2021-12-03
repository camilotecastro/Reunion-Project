package dao;

import java.util.List;
import java.util.Optional;

// parametrization interface
// generic T
public interface Dao<T>{
    List<T> getAll();
    Optional<T> get(long id);
    void save(T t);
    void delete(T t);
    void update(T t);
}

