import React, { Component } from 'react';

class ListQueryResultsComponent extends Component {
    render() {
        return (
            <div className="container">
                <h3>Query Results</h3>
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>columns 1</th>
                                <th>columns 2</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>row a</td>
                                <td>row a</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default ListQueryResultsComponent