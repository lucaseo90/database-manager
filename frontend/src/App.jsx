import React, { Component } from 'react';
import './App.css';
import DatabaseManagerApp from './component/DatabaseManagerApp';
import InputDataSourceForm from "./component/InputDataSourceForm";
import InputQueryForm from "./component/InputQueryForm";
import ListQueryResultsComponent from "./component/ListQueryResultsComponent";

class App extends Component {
    render() {
        return (
            <div className="container">
                <DatabaseManagerApp />
                <InputDataSourceForm />
                <InputQueryForm />
                <ListQueryResultsComponent />
            </div>
        );
    }
}

export default App;
