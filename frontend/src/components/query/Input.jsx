import React, {Component} from 'react';
import {inject, observer} from 'mobx-react';
import {makeStyles} from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';

import DataSource from "./DataSource";
import Query from "./Query";
import DatabaseService from "../../containers/query/Query";
import CustomTable from "./Table";

const useStyles = makeStyles(theme => ({
    button: {
        margin: theme.spacing(1),
    },
    input: {
        display: 'none',
    },
}));

@inject('databaseInformation')
@inject('databaseQueryResult')
@observer
class Input extends Component {

    executeQueryClicked(vendor, url, id, password, query) {
        DatabaseService.executeQuery(vendor, url, id, password, query)
            .then(
                response => {
                    const {databaseQueryResult} = this.props;
                    console.log(response);
                    databaseQueryResult.setResult(response);
                }
            )
    }

    render() {
        const {databaseInformation} = this.props;
        const {databaseQueryResult} = this.props;
        return (
            <form>
                <DataSource/>
                <Query/>
                <div className="row">
                    <Button variant="contained" color="primary" className={useStyles.button}
                            onClick={() => this.executeQueryClicked(
                                databaseInformation.vendor,
                                databaseInformation.url,
                                databaseInformation.id,
                                databaseInformation.password,
                                databaseInformation.query)}>Execute</Button>
                </div>
                <div>
                    <br/> Table 1 data test
                    <CustomTable data={databaseQueryResult.result}/>
                </div>
            </form>
        );
    }
}

export default Input;