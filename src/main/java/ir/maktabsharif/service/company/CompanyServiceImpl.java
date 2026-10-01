package ir.maktabsharif.service.company;

import ir.maktabsharif.exception.ValidationException;
import ir.maktabsharif.model.Company;
import ir.maktabsharif.repository.company.CompanyRepository;
import ir.maktabsharif.service.Base.BaseServiceImpl;

public class CompanyServiceImpl extends BaseServiceImpl<Company,Integer, CompanyRepository> implements CompanyService {



    public CompanyServiceImpl(CompanyRepository repository) {
        super(repository);
    }

    @Override
    protected void validation(Company company) throws ValidationException {
        if (company.getName().isBlank()) throw new ValidationException("your name is empty");
        if (company.getPhoneNumber().isBlank()) throw new ValidationException("your phone is empty");
        if (company.getSite().isBlank()) throw new ValidationException("your siter is empty");
    }
}
