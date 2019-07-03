import React, { Component } from 'react';
import { observer, inject } from 'mobx-react';

import InputDataSourceForm from "./InputDataSourceForm";
import InputQueryForm from "./InputQueryForm";
import DatabaseService from "../service/DatabaseService";

@inject('databaseInformation')
@observer
class InputParentForm extends Component {
    executeQueryClicked(vendor, url, id, password, query) {
        DatabaseService.executeQuery(vendor, url, id, password, query)
            .then(
                response => {

                }
            )
    }

    render() {
        const { databaseInformation } = this.props;
        return (
            <form>
                <InputDataSourceForm />
                <InputQueryForm />
                <div className="row">
                    <button className="btn btn-success"
                            onClick={() => this.executeQueryClicked(
                                databaseInformation.vendor,
                                databaseInformation.url,
                                databaseInformation.id,
                                databaseInformation.password,
                                databaseInformation.query)}>Execute</button>
                </div>
            </form>
        );
    }
}

export default InputParentForm;