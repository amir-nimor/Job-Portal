package ir.maktabsharif.service.user;

import ir.maktabsharif.model.User;
import ir.maktabsharif.service.Base.BaseService;

public interface UserService extends BaseService<User,Integer> {
    User getUsernameAndPassword(String username,String password);


}
