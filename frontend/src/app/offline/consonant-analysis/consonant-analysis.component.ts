import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-consonant-analysis',
  templateUrl: './consonant-analysis.component.html',
  styleUrls: ['./consonant-analysis.component.css'],
})
export class ConsonantAnalysisComponent {
  input: string = '';
  consonantCounts: Record<string, number> = {
    B: 0,
    C: 0,
    D: 0,
    F: 0,
    G: 0,
    H: 0,
    J: 0,
    K: 0,
    L: 0,
    M: 0,
    N: 0,
    P: 0,
    Q: 0,
    R: 0,
    S: 0,
    T: 0,
    V: 0,
    W: 0,
    X: 0,
    Y: 0,
    Z: 0,
  };

  previousAnalysis: string = '';
  latestAnalysis: string = '';

  analyze() {
    this.previousAnalysis = this.latestAnalysis; // Store the latest analysis as previous
    this.resetCounts(); // Reset the counts for the latest analysis
    this.countConsonants(); // Count vowels for the latest analysis
    this.latestAnalysis = this.generateOutput(); // Generate the latest analysis
  }

  private countConsonants() {
    const inputText = this.input.trim().toUpperCase();
    for (const char of inputText) {
      if (this.consonantCounts.hasOwnProperty(char)) {
        this.consonantCounts[char]++;
      }
    }
  }

  private resetCounts() {
    for (const key in this.consonantCounts) {
      if (this.consonantCounts.hasOwnProperty(key)) {
        this.consonantCounts[key] = 0;
      }
    }
  }

  getConsonantKeys(input: any): string[] {
    return Object.keys(this.consonantCounts);
  }

  private generateOutput() {
    const inputText = this.input.trim().toUpperCase();
    const consonantsInSentence: string[] = [];
    
    for (const char of inputText) {
      if (this.consonantCounts.hasOwnProperty(char) && !consonantsInSentence.includes(char)) {
        consonantsInSentence.push(char);
      }
    }
    consonantsInSentence.sort();

    const outputLines: string[] = [];
    outputLines.push(`Analysis for: ${this.input}`);
    for (const consonant of consonantsInSentence) {
      outputLines.push(`Letter '${consonant}' appears ${this.consonantCounts[consonant]} times`);
    }
    return outputLines.join('\n');
  }
}
