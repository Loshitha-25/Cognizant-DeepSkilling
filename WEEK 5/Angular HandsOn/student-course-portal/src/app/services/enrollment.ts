import { Injectable } from '@angular/core';
import { CourseService } from './course';
import { Course } from '../models/course.model';
import { Observable, forkJoin, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {
getStudentsByCourse(courseId: number): Observable<any[]> {
  return this.http.get<any[]>(
    `http://localhost:3000/students?courseId=${courseId}`
  );
}
  private enrolledCourseIds: number[] = [];

  constructor(
  private courseService: CourseService,
  private http: HttpClient
) {}

  enroll(courseId: number): void {
    if (!this.enrolledCourseIds.includes(courseId)) {
      this.enrolledCourseIds.push(courseId);
    }
  }

  unenroll(courseId: number): void {
    this.enrolledCourseIds =
      this.enrolledCourseIds.filter(id => id !== courseId);
  }

  isEnrolled(courseId: number): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  getEnrolledCourses(): Observable<Course[]> {
    if (this.enrolledCourseIds.length === 0) {
      return of([]);
    }

    return forkJoin(
      this.enrolledCourseIds.map(id =>
        this.courseService.getCourseById(id)
      )
    );
  }
}