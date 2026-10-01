package ir.maktabsharif.repository.company;

import ir.maktabsharif.model.Company;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

import java.util.Base64;

public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company, Integer> implements CompanyRepository {

    public CompanyRepositoryImpl() {
        super(Company.class);
    }
}
