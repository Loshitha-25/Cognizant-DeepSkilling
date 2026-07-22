import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card';
import { Highlight } from '../../directives/highlight';
@Component({
  selector: 'app-course-list',
 imports: [CommonModule, CourseCard, Highlight],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList implements OnInit {

  isLoading = true;
constructor(private courseService: CourseService) {}
  courses: Course[] = [];

  ngOnInit(): void {
     this.courses = this.courseService.getCourses();
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  // trackBy prevents Angular from unnecessarily recreating unchanged course elements.
  trackByCourseId(index: number, course: any): number {
    return course.id;
  }
}