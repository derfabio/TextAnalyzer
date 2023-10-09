import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VowelAnalysisComponent } from './offline/vowel-analysis/vowel-analysis.component';
import { ConsonantAnalysisComponent } from './offline/consonant-analysis/consonant-analysis.component';
import { OfflineMainPageComponent } from './offline/offline-main-page/offline-main-page.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  { path: '', component: AppComponent},
  { path: 'offline', component: OfflineMainPageComponent },
  { path: 'vowel-analysis', component: VowelAnalysisComponent },
  { path: 'consonant-analysis', component: ConsonantAnalysisComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
