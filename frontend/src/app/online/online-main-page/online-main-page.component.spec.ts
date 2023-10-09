import { ComponentFixture, TestBed } from '@angular/core/testing';
import { OnlineMainPageComponent } from './online-main-page.component';

describe('OnlineMainPageComponent', () => {
  let component: OnlineMainPageComponent;
  let fixture: ComponentFixture<OnlineMainPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OnlineMainPageComponent]
    });
    fixture = TestBed.createComponent(OnlineMainPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
