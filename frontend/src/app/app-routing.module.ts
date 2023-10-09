import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VowelAnalysisComponent } from './offline/vowel-analysis/vowel-analysis.component';
import { ConsonantAnalysisComponent } from './offline/consonant-analysis/consonant-analysis.component';
import { MainPageComponent } from './main-page/main-page.component';

const routes: Routes = [
  { path: '', component: MainPageComponent },
  { path: 'vowel-analysis', component: VowelAnalysisComponent },
  { path: 'consonant-analysis', component: ConsonantAnalysisComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
