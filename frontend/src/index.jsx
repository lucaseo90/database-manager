import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from 'mobx-react';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import DatabaseInformationStore from './store/DatabaseInformation'
import DatabaseQueryResultStore from './store/DatabaseQueryResult'

const databaseInformation = new DatabaseInformationStore();
const databaseQueryResult = new DatabaseQueryResultStore();

ReactDOM.render(
    <Provider
        databaseInformation={databaseInformation}
        databaseQueryResult={databaseQueryResult}
    >
        <App/>
    </Provider>,
    document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.register();
