import React, { Component } from 'react';
import './App.css';
import DatabaseManagerApp from './component/DatabaseManagerApp';
import ListQueryResultsComponent from "./component/ListQueryResultsComponent";
import InputParentForm from "./component/InputParentForm";
import Table from "./component/Table";

class App extends Component {

    constructor(props){
        super(props);
        this.state={
            tableData:[
                {'fruit': 'Apple', 'cost': 100},
                {'fruit': 'Orange', 'cost': 50},
                {'fruit': 'Banana', 'cost': 35},
                {'fruit': 'Mango', 'cost': 70},
                {'fruit': 'Pineapple', 'cost': 45},
                {'fruit': 'Papaya', 'cost': 40},
                {'fruit': 'Watermelon', 'cost': 35}
          ],
          tableData2:[
                {'Name': 'Abc', 'Age': 15, 'Location': 'Bangalore'},
                {'Name': 'Def', 'Age': 43, 'Location': 'Mumbai'},
                {'Name': 'Uff', 'Age': 30, 'Location': 'Chennai'},
                {'Name': 'Ammse', 'Age': 87, 'Location': 'Delhi'},
                {'Name': 'Yysse', 'Age': 28, 'Location': 'Hyderabad'}
            ]
        }
    }

    render() {
        return (
            <div className="container">
                <DatabaseManagerApp />
                <InputParentForm store={this.props.store}/>
                <br/> Table 1 data
                <Table data={this.state.tableData}/>
                <ListQueryResultsComponent />
            </div>
        );
    }
}

export default App;
