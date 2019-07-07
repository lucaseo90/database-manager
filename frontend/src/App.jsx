import React, {Component} from 'react';
import './App.css';
import DatabaseManagerApp from './component/DatabaseManagerApp';
import InputParentForm from "./component/InputParentForm";

class App extends Component {
    render() {
        return (
            <div className="container">
                <DatabaseManagerApp/>
                <InputParentForm store={this.props.store}/>
            </div>
        );
    }
}

export default App;
