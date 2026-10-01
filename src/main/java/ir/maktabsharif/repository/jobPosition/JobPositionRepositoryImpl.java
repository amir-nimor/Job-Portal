package ir.maktabsharif.repository.jobPosition;

import ir.maktabsharif.model.JobPosition;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class JobPositionRepositoryImpl extends BaseRepositoryImpl<JobPosition,Long> implements JobPositionRepository {
    public JobPositionRepositoryImpl( ) {
        super(JobPosition.class);
    }
}
