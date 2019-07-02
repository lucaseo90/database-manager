import React, { Component } from 'react';
import ListQueryResultsComponent from './ListQueryResultsComponent';

class DatabaseManagerApp extends Component {
    render() {
        return (<>
                  <h1>Database Manager Application</h1>
                  <ListQueryResultsComponent/>
              </>
        )
    }
}

export default DatabaseManagerApp