package ir.maktabsharif.service.Base;



import ir.maktabsharif.model.baseMode.BaseMode;

import java.util.List;

public interface BaseService <T extends BaseMode<ID>, ID extends Number>{
    T save(T t);

    ID delete(ID id);

    T update(T t);

    T findById(ID id);

    List<T> findAll();
}
