import React, { Component } from 'react';

class InputQueryForm extends Component {
    state = {
        query: ''
    }
    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        });
    }
    render() {
        return (
            <form>
                <input
                    placeholder="query"
                    value={this.state.vendor}
                    onChange={this.handleChange}
                    name="query"
                />
                <div>{this.state.query}</div>
            </form>
        );
    }
}

export default InputQueryForm;