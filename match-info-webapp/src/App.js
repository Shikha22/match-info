import {JSONToHTMLTable} from '@kevincobain2000/json-to-html-table'
import React, { Component } from 'react'
import './App.css';

class App extends Component {

    constructor(props) {
      console.log("constructor called");
        super(props);
        this.state = {
          matchData: [],
        };
      }

     
      
       componentDidMount() {
        console.log("componentDidMount called");
        this.setState({
          matchData: []
        });
        let country = (new URLSearchParams(window.location.search)).get("country")
        console.log("country=="+country);
          fetch("http://localhost:9292/match/"+country)
            .then(response => response.json())
            .then(data =>{
              this.setState({ matchData: data});              
            }
               );
        }

        
        componentWillUnmount(){
          console.log("Unmount");
        }
  render () {    
    console.log("render is called");
    return (
      <JSONToHTMLTable data={this.state.matchData} tableClassName="table table-sm"/>
    )
  }
}

export default App;
