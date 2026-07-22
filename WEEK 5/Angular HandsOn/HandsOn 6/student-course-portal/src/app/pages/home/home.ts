import { CourseSummaryWidget } from '../../components/course-summary-widget/course-summary-widget';
import { CourseService } from '../../services/course';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  imports: [FormsModule, CourseSummaryWidget],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit, OnDestroy {

  portalName = 'Student Course Portal';
  isPortalActive = true;
  message = '';
  searchTerm = '';

  coursesAvailable = 0;

  // Inject the shared CourseService
  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    // Get the live course count from CourseService
    this.coursesAvailable = this.courseService.getCourses().length;

    console.log('HomeComponent initialised — courses loaded');
  }

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }

  ngOnDestroy(): void {
    console.log('HomeComponent destroyed');
  }
}