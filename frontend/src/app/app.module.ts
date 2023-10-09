import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { VowelAnalysisComponent } from './offline/vowel-analysis/vowel-analysis.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConsonantAnalysisComponent } from './offline/consonant-analysis/consonant-analysis.component';
import { MainPageComponent } from './main-page/main-page.component';

const routes: Routes = [
  { path: 'vowels', redirectTo: '/vowel-analysis', pathMatch: 'full' },
  { path: 'vowel-analysis', component: VowelAnalysisComponent },
  { path: 'consonants', redirectTo: '/consonant-analysis', pathMatch: 'full'},
  { path: 'consonant-analysis', component: ConsonantAnalysisComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    VowelAnalysisComponent,
    ConsonantAnalysisComponent,
    MainPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
