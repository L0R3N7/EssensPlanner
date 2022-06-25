import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LognSigninPageComponent } from './logn-signin-page.component';

describe('LognSigninPageComponent', () => {
  let component: LognSigninPageComponent;
  let fixture: ComponentFixture<LognSigninPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LognSigninPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LognSigninPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
