import React, { Component } from 'react';
import { inject } from 'mobx-react';

@inject('databaseInformation')
class InputDataSourceForm extends Component {
    state = {
        vendor: '',
        url: '',
        id: '',
        password: ''
    }

    handleChange = (e) => {
        const { databaseInformation } = this.props;
        this.setState({
           [e.target.name]: e.target.value
        });
        console.log("name:", e.target.name);
        switch(e.target.name) {
            case 'vendor':
                databaseInformation.setVendor(e.target.value);
                break;
            case 'url':
                databaseInformation.setUrl(e.target.value);
                break;
            case 'id':
                databaseInformation.setId(e.target.value);
                break;
            case 'password':
                databaseInformation.setPassword(e.target.value);    
                break;
            default:
                break;
        }
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