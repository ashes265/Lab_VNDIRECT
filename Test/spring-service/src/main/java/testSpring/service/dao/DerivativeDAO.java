package testSpring.service.dao;

import testSpring.service.model.Derivative;

import java.util.List;

public interface DerivativeDAO {
    public List<Derivative> list(Integer page,Integer size,String sort,String filter);
}
