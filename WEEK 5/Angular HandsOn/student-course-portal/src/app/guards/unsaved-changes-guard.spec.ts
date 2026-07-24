import { TestBed } from '@angular/core/testing';
import { CanDeactivateFn } from '@angular/router';

import { ReactiveEnrollmentForm } from '../pages/reactive-enrollment-form/reactive-enrollment-form';
import { unsavedChangesGuard } from './unsaved-changes-guard';

describe('unsavedChangesGuard', () => {

  const executeGuard = (
  component: ReactiveEnrollmentForm,
  currentRoute: any,
  currentState: any,
  nextState: any
) =>
  TestBed.runInInjectionContext(() =>
    unsavedChangesGuard(
      component,
      currentRoute,
      currentState,
      nextState
    )
  );

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });

});