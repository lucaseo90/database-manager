import { observable, action } from 'mobx';

export default class DatabaseInformationStore {
    @observable vendor = '';
    @observable url = '';
    @observable id = '';
    @observable password = '';
    @observable query = '';

    @action setVendor = (value) => {
        this.vendor = value;
    }

    @action setUrl = (value) => {
        this.url = value;
    }

    @action setId = (value) => {
        this.id = value;
    }

    @action setPassword = (value) => {
        this.password = value;
    }

    @action setQuery = (value) => {
        this.query = value;
    }

}