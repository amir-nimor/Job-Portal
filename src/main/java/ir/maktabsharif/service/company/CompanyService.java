package ir.maktabsharif.service.company;

import ir.maktabsharif.model.Company;
import ir.maktabsharif.service.Base.BaseService;

public interface CompanyService extends BaseService<Company,Integer> {
    Company getUsernameAndPassword(String username, String password);
}
