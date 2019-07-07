import {action, observable} from 'mobx';

export default class DatabaseQueryResult {
    @observable result;

    @action setResult = (value) => {
        this.result = value.data.data;
    }
}