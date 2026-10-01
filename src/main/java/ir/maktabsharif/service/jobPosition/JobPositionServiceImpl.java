package ir.maktabsharif.service.jobPosition;

import ir.maktabsharif.exception.ValidationException;
import ir.maktabsharif.model.JobPosition;
import ir.maktabsharif.repository.jobPosition.JobPositionRepository;
import ir.maktabsharif.service.Base.BaseServiceImpl;

public class JobPositionServiceImpl extends BaseServiceImpl<JobPosition,Long, JobPositionRepository> implements JobPositionService{

    public JobPositionServiceImpl(JobPositionRepository repository) {
        super(repository);
    }

    @Override
    protected void validation(JobPosition jobPosition) throws ValidationException {
        if (jobPosition.getTitle().isBlank()) throw new ValidationException("your title is empty");

        if (jobPosition.getCompany()==null) throw new ValidationException("your company is empty");
        if (jobPosition.getMaximumSalary() == null || jobPosition.getMinimumSalary() == null) throw new ValidationException("your salary is empty");
    }
}
