package ir.maktabsharif.service.user;

import ir.maktabsharif.exception.ValidationException;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.user.UserRepository;
import ir.maktabsharif.service.Base.BaseServiceImpl;

public class UserServiceImpl extends BaseServiceImpl<User, Integer, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    protected void validation(User user) throws ValidationException {
        if (user.getFullName().isBlank()) throw new ValidationException("your name is empty");
        if (user.getDescription().isBlank()) throw new ValidationException("your description is empty");
        if (user.getRols() == null) throw new ValidationException("your rols is empty");

    }
}
