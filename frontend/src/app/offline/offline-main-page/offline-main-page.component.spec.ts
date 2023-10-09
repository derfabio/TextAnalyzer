import { ComponentFixture, TestBed } from '@angular/core/testing';
import {  OfflineMainPageComponent } from './offline-main-page.component';

describe('OfflineMainPageComponent', () => {
  let component: OfflineMainPageComponent;
  let fixture: ComponentFixture<OfflineMainPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OfflineMainPageComponent]
    });
    fixture = TestBed.createComponent(OfflineMainPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
