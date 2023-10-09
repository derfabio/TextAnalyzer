import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent{
  title = 'Text Analyzer';
  isOnlineMode: boolean = true;

  constructor(private router: Router) {}

  
  toggleOnlineMode() {
    this.isOnlineMode = !this.isOnlineMode;
  }

  goToOnlineAnalyzer() {
    this.router.navigate(['/']);
  }

  goToOfflineAnalyzer() {
    this.router.navigate(['/offline']);
  }
}
