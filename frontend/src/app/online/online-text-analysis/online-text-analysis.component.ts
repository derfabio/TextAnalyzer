import { Component, OnInit } from '@angular/core';
import { TextService } from '../text.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http'; // Import HttpErrorResponse

interface ApiResponse {
  data: Text[];
  message: string;
}

@Component({
  selector: 'app-online-text-analysis',
  templateUrl: './online-text-analysis.component.html',
  styleUrls: ['./online-text-analysis.component.css']
})
export class OnlineTextAnalysisComponent implements OnInit {
  analysisForm: FormGroup;
  analysisResults: ApiResponse = { data: [], message: '' };

  constructor(private textService: TextService, private formBuilder: FormBuilder) {
    this.analysisForm = this.formBuilder.group({
      text: [''],
      analysisType: ['vowel'],    
    });
    this.analysisResults = { data: [], message: '' }; // Initialize with default values
  }

  ngOnInit(): void {
    this.analysisForm = this.formBuilder.group({
      text: [''],
      analysisType: ['vowel'],
    });
  }

  onSubmit(): void {
    const text = this.analysisForm?.get('text')?.value;
    const analysisType = this.analysisForm?.get('analysisType')?.value;

    if (text !== undefined) {
      // Create a Text object with the entered text
      const textObject = { content: text, analysisType };
  
      this.textService.postText(textObject).subscribe(
        (response: ApiResponse) => {
          this.analysisResults = response;
        },
        (error: HttpErrorResponse) => {
          console.error('An error occurred:', error);
        }
      );
    } else {
      console.error("'text' is undefined");
    }
  }
}
