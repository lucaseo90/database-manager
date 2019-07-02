import React, { Component } from 'react';
import InputDataSourceForm from "./InputDataSourceForm";
import InputQueryForm from "./InputQueryForm";
import DatabaseService from "../service/DatabaseService";

class InputParentForm extends Component {
    constructor(props) {
        super(props);
        this.status = {
            vendor: '',
            url: '',
            id: '',
            password: '',
            query: ''
        }
    }

    executeQueryClicked(vendor, url, id, password, query) {
        DatabaseService.executeQuery(vendor, url, id, password, query)
            .then(
                response => {

                }
            )
    }

    render() {
        return (
            <form>
                <InputDataSourceForm />
                <InputQueryForm />
                <div className="row">
                    <button className="btn btn-success"
                            onClick={() => this.executeQueryClicked(
                                this.vendor,
                                this.url,
                                this.id,
                                this.password,
                                this.query)}>Execute</button>
                </div>
            </form>
        );
    }
}

export default InputParentForm;