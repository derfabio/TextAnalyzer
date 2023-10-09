import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsonantAnalysisComponent } from './consonant-analysis.component';

describe('ConsonantAnalysisComponent', () => {
  let component: ConsonantAnalysisComponent;
  let fixture: ComponentFixture<ConsonantAnalysisComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConsonantAnalysisComponent]
    });
    fixture = TestBed.createComponent(ConsonantAnalysisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
