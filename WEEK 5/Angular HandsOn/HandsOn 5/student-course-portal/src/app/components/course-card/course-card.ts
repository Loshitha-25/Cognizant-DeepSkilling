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

  // ADD TASK 2 CODE FROM HERE 👇

  isExpanded = false;
  isEnrolled = false;

  get cardClasses() {
    return {
      'card--enrolled': this.isEnrolled,
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
  this.isEnrolled = true;
  this.enrollRequested.emit(this.course.id);
}

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  // YOUR EXISTING CODE 👇

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