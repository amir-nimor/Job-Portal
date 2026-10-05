package ir.maktabsharif.repository.user;

import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;
import ir.maktabsharif.util.HibernateUtil;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Integer> implements UserRepository {
    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public User getUsernameAndPassword(String username, String password) {
        try {
            return HibernateUtil.read(em -> {
                return em.createQuery("select u FROM User u where u.username = ?1 and u.password = ?2", User.class)
                        .setParameter(1,username)
                        .setParameter(2,password)
                        .getSingleResult();
            });
        }catch (RuntimeException e){
            throw new RepositoryException("find By username and password is failed");
        }
    }
}
