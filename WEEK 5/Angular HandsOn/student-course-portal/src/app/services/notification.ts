import { Injectable } from '@angular/core';

@Injectable()
export class NotificationService {

  showMessage(message: string): void {
    console.log('Notification:', message);
  }
}