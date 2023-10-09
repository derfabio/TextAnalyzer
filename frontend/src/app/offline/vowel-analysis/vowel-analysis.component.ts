import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-vowel-analysis',
  templateUrl: './vowel-analysis.component.html',
  styleUrls: ['./vowel-analysis.component.css'],
})
export class VowelAnalysisComponent {
  input: string = '';
  vowelCounts: Record<string, number> = {
    A: 0,
    E: 0,
    I: 0,
    O: 0,
    U: 0,
  };

  previousAnalysis: string = '';
  latestAnalysis: string = '';

  analyze() {
    this.previousAnalysis = this.latestAnalysis; // Store the latest analysis as previous
    this.resetCounts(); // Reset the counts for the latest analysis
    this.countVowels(); // Count vowels for the latest analysis
    this.latestAnalysis = this.generateOutput(); // Generate the latest analysis
  }
  
  private countVowels() {
    const inputText = this.input.trim().toUpperCase();
    for (const char of inputText) {
      if (this.vowelCounts.hasOwnProperty(char)) {
        this.vowelCounts[char]++;
      }
    }
  }

  private resetCounts() {
    for (const key in this.vowelCounts) {
      if (this.vowelCounts.hasOwnProperty(key)) {
        this.vowelCounts[key] = 0;
      }
    }
  }

  getVowelKeys(input: any): string[] {
    return Object.keys(this.vowelCounts);
  }

  private generateOutput() {
    const inputText = this.input.trim().toUpperCase();
    const vowelsInSentence: string[] = [];
  
    for (const char of inputText) {
      if (this.vowelCounts.hasOwnProperty(char) && !vowelsInSentence.includes(char)) {
        vowelsInSentence.push(char);
      }
    }
    vowelsInSentence.sort();
  
    const outputLines: string[] = [];
    outputLines.push(`Analysis for: ${this.input}`);
    for (const vowel of vowelsInSentence) {
      outputLines.push(`Letter '${vowel}' appears ${this.vowelCounts[vowel]} times`);
    }
    return outputLines.join('\n');
  }
}
