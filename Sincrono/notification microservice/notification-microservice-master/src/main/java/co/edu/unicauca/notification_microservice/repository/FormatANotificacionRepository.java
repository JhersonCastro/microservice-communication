package co.edu.unicauca.notification_microservice.repository;

import co.edu.unicauca.notification_microservice.entity.FormatANotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatANotificacionRepository extends JpaRepository<FormatANotification, Long> {
}
