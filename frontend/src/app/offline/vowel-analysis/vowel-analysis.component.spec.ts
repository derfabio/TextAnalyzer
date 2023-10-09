import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VowelAnalysisComponent } from './vowel-analysis.component';

describe('VowelAnalysisComponent', () => {
  let component: VowelAnalysisComponent;
  let fixture: ComponentFixture<VowelAnalysisComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VowelAnalysisComponent]
    });
    fixture = TestBed.createComponent(VowelAnalysisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
