package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyFacadeDao extends CrudRepository<Company, Integer> {

    @Query(nativeQuery = true)
    List<Company> findByFragment(@Param("ARG") String companyNameFragment);

    List<Company> findByName(String name);
    void deleteByName(String companyName);

}
