import { Router, ActivatedRoute } from '@angular/router';
import { Course } from '../../models/course.model';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card';
import { Highlight } from '../../directives/highlight';
import { FormsModule } from '@angular/forms';
import { Subject, switchMap, Observable } from 'rxjs';
import { EnrollmentService } from '../../services/enrollment';

import { Store } from '@ngrx/store';
import { loadCourses } from '../../store/course/course.actions';
import { selectAllCourses } from '../../store/course/course.selectors';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard, Highlight, FormsModule],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList implements OnInit {

  private selectedCourseId = new Subject<number>();

  selectedStudents: any[] = [];
  searchTerm = '';

  courses$: Observable<Course[]>;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private enrollmentService: EnrollmentService,
    private store: Store
  ) {
    this.courses$ = this.store.select(selectAllCourses);
  }

  ngOnInit(): void {

    this.searchTerm =
      this.route.snapshot.queryParamMap.get('search') || '';

    // Dispatch the action to load courses through NgRx.
    this.store.dispatch(loadCourses());

    // switchMap cancels the previous student request when
    // a new course is selected.
    this.selectedCourseId.pipe(
      switchMap(courseId =>
        this.enrollmentService.getStudentsByCourse(courseId)
      )
    ).subscribe({
      next: (students) => {
        this.selectedStudents = students;
        console.log('Enrolled students:', students);
      }
    });
  }

  viewCourse(courseId: number): void {
    this.selectedCourseId.next(courseId);
    this.router.navigate(['/courses', courseId]);
  }

  searchCourses(): void {
    this.router.navigate(['/courses'], {
      queryParams: {
        search: this.searchTerm
      }
    });
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }
}