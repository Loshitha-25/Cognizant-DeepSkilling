import {
  ApplicationConfig,
  provideBrowserGlobalErrorListeners,
  provideZoneChangeDetection
} from '@angular/core';
import { enrollmentReducer } from './store/enrollment/enrollment.reducer';
import { errorHandlerInterceptor } from './interceptors/error-handler-interceptor';
import { provideRouter } from '@angular/router';
import {
  provideHttpClient,
  withInterceptors
} from '@angular/common/http';
import { loadingInterceptor } from './interceptors/loading-interceptor';
import { routes } from './app.routes';
import { authInterceptor } from './interceptors/auth-interceptor';
import { provideStore } from '@ngrx/store';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import { provideState } from '@ngrx/store';
import { courseReducer } from './store/course/course.reducer';
import { provideEffects } from '@ngrx/effects';
import { CourseEffects } from './store/course/course.effects';
export const appConfig: ApplicationConfig = {
  providers: [
    provideState('course', courseReducer),
    provideState('enrollment', enrollmentReducer),
    provideEffects(CourseEffects),
    provideStore(),
provideStoreDevtools({
  maxAge: 25
}),
provideState('course', courseReducer),
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(
      withInterceptors([
  authInterceptor,
  errorHandlerInterceptor,
  loadingInterceptor
])
    )
  ]
};