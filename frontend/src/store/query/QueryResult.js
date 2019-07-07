import {action, observable} from 'mobx';

export default class QueryResult {
    @observable result;

    @action setResult = (value) => {
        this.result = value.data.data;
    }
}