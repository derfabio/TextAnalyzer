import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VowelAnalysisComponent } from './vowel-analysis/vowel-analysis.component';


const routes: Routes = [{ path: 'vowel-analysis', component: VowelAnalysisComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
