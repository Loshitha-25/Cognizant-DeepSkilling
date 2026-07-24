import { TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import {
  provideHttpClientTesting,
  HttpTestingController
} from '@angular/common/http/testing';

import { CourseService } from './course';
describe('CourseService', () => {

  let service: CourseService;
let httpMock: HttpTestingController;

const mockCourses = [
  {
    id: 1,
    name: 'Data Structures',
    code: 'CS101',
    credits: 4,
    gradeStatus: 'passed'
  },
  {
    id: 2,
    name: 'Angular',
    code: 'CS102',
    credits: 3,
    gradeStatus: 'ongoing'
  }
];
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        CourseService,
        provideHttpClient(),
        provideHttpClientTesting()
      ]
    });

    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  it('should get courses', () => {

  service.getCourses().subscribe(courses => {
    expect(courses.length).toBe(2);
  });

  const req = httpMock.expectOne('http://localhost:3000/courses');

  expect(req.request.method).toBe('GET');

  req.flush(mockCourses);

  httpMock.verify();

});

it('should handle server error', () => {

  service.getCourses().subscribe({

    next: () => fail('Expected an error'),

    error: (err) => {
      expect(err.message)
        .toBe('Failed to load courses. Please try again.');
    }

  });

  const req = httpMock.expectOne('http://localhost:3000/courses');

  req.flush(
    'Server Error',
    {
      status: 500,
      statusText: 'Internal Server Error'
    }
  );

});

});