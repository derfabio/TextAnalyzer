import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { VowelAnalysisComponent } from './offline/vowel-analysis/vowel-analysis.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConsonantAnalysisComponent } from './offline/consonant-analysis/consonant-analysis.component';
import { OfflineMainPageComponent } from './offline/offline-main-page/offline-main-page.component';
import { OnlineMainPageComponent } from './online/online-main-page/online-main-page.component';


@NgModule({
  declarations: [
    AppComponent,
    VowelAnalysisComponent,
    ConsonantAnalysisComponent,
    OfflineMainPageComponent,
    OnlineMainPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
