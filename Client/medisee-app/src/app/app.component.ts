import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { ArrayType } from '@angular/compiler/src/output/output_ast';
import {ingredients} from './entities'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']


  
  
})


export class AppComponent {
  constructor(private http: HttpClient){
    
    
  }

  model: any = {};
  url = 'https://localhost:5001/api/ingredients/reaction?';
  
  submitted = false;

  title = 'medisee-app';

  data : ingredients[];
  result =  '';
  reaction='';

  onSubmit() {
    this.submitted = true;

    this.http.get<ingredients[]>(this.url+'name='+this.reaction).subscribe(res => {
   
      this.data =res;
      
     });
}

}

