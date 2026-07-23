import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../services/course';

@Component({
  selector: 'app-course-summary-widget',
  imports: [],
  templateUrl: './course-summary-widget.html',
  styleUrl: './course-summary-widget.css',
})
export class CourseSummaryWidget implements OnInit {

  courseCount = 0;

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    this.loadCourseCount();
  }

  loadCourseCount(): void {
    this.courseService.getCourses().subscribe({
      next: (courses) => {
        this.courseCount = courses.length;
      },
      error: (err) => {
        console.error('Error loading courses:', err);
      }
    });
  }

  addCourse(): void {
    const newCourse = {
      name: 'DevOps',
      code: 'DEV101',
      credits: 3,
      gradeStatus: 'pending' as const
    };

    this.courseService.createCourse(newCourse).subscribe({
      next: () => {
        this.loadCourseCount();
      },
      error: (err) => {
        console.error('Error adding course:', err);
      }
    });
  }
}