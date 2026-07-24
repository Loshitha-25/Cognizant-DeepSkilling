import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideMockStore } from '@ngrx/store/testing';
import { By } from '@angular/platform-browser';
import { SimpleChange } from '@angular/core';

import { CourseCard } from './course-card';

const mockCourse = {
  id: 1,
  name: 'Data Structures',
  code: 'CS101',
  credits: 4,
  gradeStatus: 'passed'
};

describe('CourseCard', () => {

  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;

  beforeEach(async () => {

    await TestBed.configureTestingModule({
      imports: [CourseCard],
      providers: [
        provideMockStore({
          initialState: {
            enrollment: {
              enrolledCourseIds: []
            }
          }
        })
      ]
    }).compileComponents();

  fixture = TestBed.createComponent(CourseCard);
component = fixture.componentInstance;

component.course = mockCourse;

fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render course name', () => {

  component.course = mockCourse;

  fixture.detectChanges();

  const heading = fixture.debugElement.query(By.css('h2')).nativeElement;

  expect(heading.textContent).toContain('Data Structures');

});
it('should emit enrollRequested when button is clicked', () => {

  component.course = mockCourse;
  fixture.detectChanges();

  spyOn(component.enrollRequested, 'emit');

  const button = fixture.debugElement.query(By.css('button')).nativeElement;

  button.click();

  expect(component.enrollRequested.emit).toHaveBeenCalledWith(1);

});

it('should call ngOnChanges', () => {

  spyOn(console, 'log');

  component.ngOnChanges({
    course: new SimpleChange(null, mockCourse, true)
  });

  expect(console.log).toHaveBeenCalled();

});

});