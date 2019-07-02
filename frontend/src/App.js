import React, { Component } from 'react';
import './App.css';
import DatabaseManagerApp from './component/DatabaseManagerApp';

class App extends Component {
    render() {
        return (
            <div className="container">
                <DatabaseManagerApp />
            </div>
        );
    }
}

export default App;
