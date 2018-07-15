package org.upgrad.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.upgrad.model.Notification;

import java.util.List;

@Repository
public interface NotificationRepository extends CrudRepository <Notification, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM   notification q WHERE q.user_id = ?1")
    List <Notification> getAllNotification(Integer user_id);

    ;
}
