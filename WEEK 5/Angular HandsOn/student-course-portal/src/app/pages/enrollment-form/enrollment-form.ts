import { NgForm, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { CourseService } from '../../services/course';

@Component({
  selector: 'app-enrollment-form',
  imports: [FormsModule, CommonModule],
  templateUrl: './enrollment-form.html',
  styleUrl: './enrollment-form.css',
})
export class EnrollmentForm {

  studentName = '';
  studentEmail = '';
  courseId: number | null = null;
  preferredSemester = '';
  agreeToTerms = false;
  submitted = false;

  constructor(private courseService: CourseService) {}

  onSubmit(form: NgForm): void {
    console.log(form.value);
    console.log(form.valid);

    if (form.valid) {
      const newCourse = {
        name: 'New Course',
        code: String(this.courseId),
        credits: 1,
        gradeStatus: 'pending' as const
      };

      this.courseService.createCourse(newCourse).subscribe({
        next: (course) => {
          console.log('Course created:', course);
          this.submitted = true;
        },
        error: (err) => {
          console.error('Error creating course:', err);
        }
      });
    }
  }
}