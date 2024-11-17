package org.devajayantha.springform.repositories;

import org.devajayantha.springform.models.entities.AllowedDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllowedDomainRepository extends JpaRepository<AllowedDomain, Long> {
    AllowedDomain saveAndFlush(AllowedDomain allowedDomain);
}
