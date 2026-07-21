import { NgForm } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-enrollment-form',
  imports: [FormsModule, CommonModule],
  templateUrl: './enrollment-form.html',
  styleUrl: './enrollment-form.css',
})
export class EnrollmentForm {
  studentName = '';
studentEmail = '';
courseId: number | null = null;
preferredSemester = '';
agreeToTerms = false;
submitted = false;

onSubmit(form: NgForm): void {
  console.log(form.value);
  console.log(form.valid);

  if (form.valid) {
    this.submitted = true;
  }
}

}
