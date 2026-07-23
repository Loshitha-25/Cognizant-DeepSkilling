import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
  AbstractControl,
  ValidationErrors,
  FormArray,
FormControl
} from '@angular/forms';
function noCourseCode(control: AbstractControl): ValidationErrors | null {
  const value = control.value;

  if (value && value.toString().startsWith('XX')) {
    return { noCourseCode: true };
  }

  return null;
}
function simulateEmailCheck(
  control: AbstractControl
): Promise<ValidationErrors | null> {
  return new Promise((resolve) => {
    setTimeout(() => {
      if (control.value?.includes('test@')) {
        resolve({ emailTaken: true });
      } else {
        resolve(null);
      }
    }, 800);
  });
}
@Component({
  selector: 'app-reactive-enrollment-form',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css',
})
export class ReactiveEnrollmentForm implements OnInit {

  enrollForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: this.fb.control(
  '',
  [Validators.required, Validators.email],
  [simulateEmailCheck]
),
      courseId: [null, [Validators.required, noCourseCode]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      additionalCourses: this.fb.array([])
    });
  }

  // ADD IT HERE 👇
  onSubmit(): void {
    console.log(this.enrollForm.value);
    console.log(this.enrollForm.getRawValue());

    // enrollForm.value excludes disabled controls.
    // enrollForm.getRawValue() includes all controls, including disabled controls.
  
  }
 get additionalCourses(): FormArray<FormControl> {
  return this.enrollForm.get('additionalCourses') as FormArray<FormControl>;
}
  addCourse(): void {
  this.additionalCourses.push(
    new FormControl('', Validators.required)
  );
}

removeCourse(index: number): void {
  this.additionalCourses.removeAt(index);
}

}