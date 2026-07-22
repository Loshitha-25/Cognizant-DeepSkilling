import { Notification } from '../../components/notification/notification';
import { CommonModule } from '@angular/common';
import { EnrollmentService } from '../../services/enrollment';
import { Course } from '../../models/course.model';
import { Component } from '@angular/core';

@Component({
  selector: 'app-student-profile',
  imports: [CommonModule, Notification],
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css',
})
export class StudentProfile {
constructor(private enrollmentService: EnrollmentService) {}

get enrolledCourses(): Course[] {
  return this.enrollmentService.getEnrolledCourses();
}
}
