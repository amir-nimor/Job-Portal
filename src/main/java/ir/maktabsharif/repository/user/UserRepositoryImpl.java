package ir.maktabsharif.repository.user;

import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Integer> implements UserRepository {
    public UserRepositoryImpl() {
        super(User.class);
    }
}
