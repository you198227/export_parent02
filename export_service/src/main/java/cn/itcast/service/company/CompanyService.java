package cn.itcast.service.company;

import cn.itcast.domain.company.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    void save(Company company);

    Company findById(String id);

    void update(Company company);

    void deleteById(String id);
}
