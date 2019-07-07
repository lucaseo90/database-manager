import React, {Component} from 'react';
import {inject} from 'mobx-react';
import clsx from 'clsx';
import {makeStyles} from '@material-ui/core/styles';
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
class InputQueryForm extends Component {
    state = {
        query: ''
    }

    handleChange = (e) => {
        console.log("Value from event:", e.target.value);
        const {databaseInformation} = this.props;
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
                <TextField
                    required
                    label="Query"
                    className={clsx(useStyles.textField, useStyles.dense)}
                    margin="dense"
                    placeholder="query"
                    value={this.state.query}
                    onChange={this.handleChange}
                    name="query"
                />
            </form>
        );
    }
}

export default InputQueryForm;