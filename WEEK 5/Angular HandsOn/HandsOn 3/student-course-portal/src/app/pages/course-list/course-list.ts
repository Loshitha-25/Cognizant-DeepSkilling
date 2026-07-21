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

  courses = [
    { id: 1, name: 'Angular', code: 'ANG101', credits: 1, gradeStatus: 'passed', enrolled: true },
    { id: 2, name: 'Java', code: 'JAVA101', credits: 3, gradeStatus: 'pending', enrolled: false },
    { id: 3, name: 'Cloud Computing', code: 'CC101', credits: null, gradeStatus: 'passed', enrolled: true },
    { id: 4, name: 'Database Management', code: 'DB101', credits: 3, gradeStatus: 'failed', enrolled: false },
    { id: 5, name: 'Software Engineering', code: 'SE101', credits: 4, gradeStatus: 'pending', enrolled: false }
  ];

  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  // trackBy prevents Angular from unnecessarily recreating unchanged course elements.
  trackByCourseId(index: number, course: any): number {
    return course.id;
  }
}