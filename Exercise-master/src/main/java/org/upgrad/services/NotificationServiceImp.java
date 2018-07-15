package org.upgrad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.model.Notification;
import org.upgrad.repository.NotificationRepository;

import java.util.List;

@Service
public class NotificationServiceImp implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List <Notification> getAllNotifications(Integer user_id) {
        System.out.println ( "notification : " + user_id );
        List <Notification> notifications = notificationRepository.getAllNotification ( user_id );
        return notifications;
    }
}
