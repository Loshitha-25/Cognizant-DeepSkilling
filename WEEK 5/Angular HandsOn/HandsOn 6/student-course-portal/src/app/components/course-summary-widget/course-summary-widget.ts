import { Component } from '@angular/core';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-summary-widget',
  imports: [],
  templateUrl: './course-summary-widget.html',
  styleUrl: './course-summary-widget.css',
})
export class CourseSummaryWidget {

  constructor(private courseService: CourseService) {}

  get courseCount(): number {
    return this.courseService.getCourses().length;
  }

  addCourse(): void {
    const newCourse: Course = {
      id: 6,
      name: 'DevOps',
      code: 'DEV101',
      credits: 3,
      gradeStatus: 'pending'
    };

    this.courseService.addCourse(newCourse);
  }
}