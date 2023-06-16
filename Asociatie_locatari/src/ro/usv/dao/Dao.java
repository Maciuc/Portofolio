package ro.usv.dao;

import java.util.List;
/**
 * @author Maciuc Simon-Gabriel
 * @grupa 3131A
 * @nr 2
 */
public interface Dao<T , K> {

    T get( K id );
    void delete(K id);
    void save(T t);
    void update(T t);
    List<T> getAll();
    void saveAll(List<T> lst);
    void deleteAll();

}
