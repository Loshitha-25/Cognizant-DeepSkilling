import { CreditLabelPipe } from '../../pipes/credit-label-pipe';
import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnChanges,
  SimpleChanges
} from '@angular/core';
import { CommonModule } from '@angular/common';
import { take } from 'rxjs';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';

import {
  enrollInCourse,
  unenrollFromCourse
} from '../../store/enrollment/enrollment.actions';

import {
  selectEnrolledIds
} from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-course-card',
  imports: [CommonModule, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css',
})
export class CourseCard implements OnChanges {

  @Input() course!: {
    id: number;
    name: string;
    code: string;
    credits: number | null;
    gradeStatus: string;
  };

  @Output() enrollRequested = new EventEmitter<number>();

  enrolledIds$: Observable<number[]>;

  isExpanded = false;

  constructor(private store: Store) {
    this.enrolledIds$ = this.store.select(selectEnrolledIds);
  }

 get cardClasses() {
  return {
    'card--full': (this.course.credits ?? 0) >= 4,
    'expanded': this.isExpanded
  };
}

  get borderColor(): string {
    switch (this.course.gradeStatus) {
      case 'passed':
        return 'green';
      case 'failed':
        return 'red';
      default:
        return 'grey';
    }
  }

  onEnroll(): void {
  this.enrolledIds$.pipe(take(1)).subscribe(ids => {
    if (ids.includes(this.course.id)) {
      this.store.dispatch(
        unenrollFromCourse({ courseId: this.course.id })
      );
    } else {
      this.store.dispatch(
        enrollInCourse({ courseId: this.course.id })
      );
    }
  });

  this.enrollRequested.emit(this.course.id);
}

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log(
        'Course changed - Previous:',
        changes['course'].previousValue,
        'Current:',
        changes['course'].currentValue
      );
    }
  }
}