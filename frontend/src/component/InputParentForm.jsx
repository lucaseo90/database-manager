import React, {Component} from 'react';
import {inject, observer} from 'mobx-react';
import {makeStyles} from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';

import InputDataSourceForm from "./InputDataSourceForm";
import InputQueryForm from "./InputQueryForm";
import DatabaseService from "../service/DatabaseService";
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
class InputParentForm extends Component {

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
                <InputDataSourceForm/>
                <InputQueryForm/>
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

export default InputParentForm;