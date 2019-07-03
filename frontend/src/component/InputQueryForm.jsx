import React, { Component } from 'react';
import { inject } from 'mobx-react';

@inject('databaseInformation')
class InputQueryForm extends Component {
    state = {
        query: ''
    }

    handleChange = (e) => {
        console.log("Value from event:", e.target.value);
        const { databaseInformation } = this.props;
        this.setState({
            query: e.target.value
        }, () => {
            console.log("New state in Async callback:", this.state.query);
        });

        console.log("New state directly after callback:", this.state.query);
        databaseInformation.setQuery(e.target.value);
    }

    render() {
        return (
            <form>
                <input
                    placeholder="query"
                    value={this.state.query}
                    onChange={this.handleChange}
                    name="query"
                />
                <div>{this.state.query}</div>
            </form>
        );
    }
}

export default InputQueryForm;