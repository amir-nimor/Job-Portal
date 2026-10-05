package ir.maktabsharif.repository.company;

import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.model.Company;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;
import ir.maktabsharif.util.HibernateUtil;

import java.util.Base64;

public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company, Integer> implements CompanyRepository {

    public CompanyRepositoryImpl() {
        super(Company.class);
    }


    @Override
    public Company getUsernameAndPassword(String username, String password) {
        try {
            return HibernateUtil.read(em -> {
                return em.createQuery("select c FROM Company c where c.username = ?1 and c.password = ?2", Company.class)
                        .setParameter(1,username)
                        .setParameter(2,password)
                        .getSingleResult();
            });
        }catch (RuntimeException e){
            throw new RepositoryException("find By username and password is failed");
        }
    }
}
