package utn.docker.facu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import utn.docker.facu.entity.Date;

@Repository
public interface DateRepository extends CrudRepository<Date, Integer> {
}
