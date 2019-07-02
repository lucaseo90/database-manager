import React, { Component } from 'react';

class InputDataSourceForm extends Component {
    state = {
        vendor: '',
        url: '',
        id: '',
        password: ''
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
                    placeholder="vendor"
                    value={this.state.vendor}
                    onChange={this.handleChange}
                    name="vendor"
                />
                <input
                    placeholder="url"
                    value={this.state.url}
                    onChange={this.handleChange}
                    name="url"
                />
                <input
                    placeholder="id"
                    value={this.state.id}
                    onChange={this.handleChange}
                    name="id"
                />
                <input
                    type="password"
                    placeholder="password"
                    value={this.state.password}
                    onChange={this.handleChange}
                    name="password"
                />
                <div>{this.state.vendor} {this.state.url} {this.state.id} {this.state.password}</div>
            </form>
        );
    }
}

export default InputDataSourceForm;