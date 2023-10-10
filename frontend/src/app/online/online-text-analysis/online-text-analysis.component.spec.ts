import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OnlineTextAnalysisComponent } from './online-text-analysis.component';

describe('OnlineTextAnalysisComponent', () => {
  let component: OnlineTextAnalysisComponent;
  let fixture: ComponentFixture<OnlineTextAnalysisComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OnlineTextAnalysisComponent]
    });
    fixture = TestBed.createComponent(OnlineTextAnalysisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
