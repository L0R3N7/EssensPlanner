import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MealKalenderComponent } from './meal-kalender.component';

describe('MealKalenderComponent', () => {
  let component: MealKalenderComponent;
  let fixture: ComponentFixture<MealKalenderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MealKalenderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MealKalenderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
