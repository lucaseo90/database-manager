import { observable, action } from 'mobx';

export default class DatabaseQueryResult {
    @observable result = '';

    @action setResult = (value) => {
        this.result = value;
    }
}