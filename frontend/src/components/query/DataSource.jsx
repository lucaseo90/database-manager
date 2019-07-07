import React, { Component } from 'react';
import { inject } from 'mobx-react';
import clsx from 'clsx';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const useStyles = makeStyles(theme => ({
    container: {
        display: 'flex',
        flexWrap: 'wrap',
    },
    textField: {
        marginLeft: theme.spacing(1),
        marginRight: theme.spacing(1),
        width: 200,
    },
    dense: {
        marginTop: 19,
    },
    menu: {
        width: 200,
    },
}));

@inject('databaseInformation')
class DataSource extends Component {
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
                <TextField
                    required
                    label="Vendor"
                    className={clsx(useStyles.textField, useStyles.dense)}
                    margin="dense"
                    value={this.state.vendor}
                    onChange={this.handleChange}
                    name="vendor"
                />
                <TextField
                    required
                    label="Id"
                    className={clsx(useStyles.textField, useStyles.dense)}
                    margin="dense"
                    value={this.state.id}
                    onChange={this.handleChange}
                    name="id"
                />
                <TextField
                    required
                    label="Password"
                    className={clsx(useStyles.textField, useStyles.dense)}
                    margin="dense"
                    type="password"
                    value={this.state.password}
                    onChange={this.handleChange}
                    name="password"
                />
                <TextField
                    required
                    label="Url"
                    className={clsx(useStyles.textField, useStyles.dense)}
                    margin="dense"
                    value={this.state.url}
                    onChange={this.handleChange}
                    name="url"
                />
            </form>
        );
    }
}

export default DataSource;