import { Component } from '@angular/core';
import { NotificationService } from '../../services/notification';

@Component({
  selector: 'app-notification',
  imports: [],
  templateUrl: './notification.html',
  styleUrl: './notification.css',

  // Providing NotificationService here creates a new separate service
  // instance scoped to this component and its child components.
  providers: [NotificationService]
})
export class Notification {

  constructor(private notificationService: NotificationService) {}

  showNotification(): void {
    this.notificationService.showMessage(
      'Notification service is working!'
    );
  }
}