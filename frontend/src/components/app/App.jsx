import React, {Component} from 'react';

import Input from "../query/Input";

class App extends Component {
    render() {
        return (
            <div className="container">
                <Input store={this.props.store}/>
            </div>
        );
    }
}

export default App;
