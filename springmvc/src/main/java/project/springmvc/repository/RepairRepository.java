package project.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.springmvc.model.Repair;

import java.util.List;
import java.util.UUID;

public interface RepairRepository extends JpaRepository<Repair, UUID> {
    List<Repair> findAll();
}
