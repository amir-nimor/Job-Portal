package ir.maktabsharif.repository.company;

import ir.maktabsharif.model.Company;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.BaseRepository.BaseRepository;

public interface CompanyRepository extends BaseRepository<Company ,Integer> {
    Company getUsernameAndPassword(String username, String password);
}
