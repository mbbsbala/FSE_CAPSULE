
import { NgModule } from '@angular/core';
import {
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatInputModule,
    MAT_DATE_LOCALE,
    MatSliderModule
} from '@angular/material';

@NgModule({
    imports: [
        MatDatepickerModule,
        MatNativeDateModule,
        MatFormFieldModule,
        MatInputModule,
        MatSliderModule
    ],
    exports: [
        MatDatepickerModule,
        MatNativeDateModule,
        MatFormFieldModule,
        MatInputModule,
        MatSliderModule
    ],
    providers:[{provide:MAT_DATE_LOCALE,useValue:'en-GB'}]
})

export class AngularMaterialModule { }