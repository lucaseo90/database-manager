import axios from 'axios'

const DATABASE_API_URL = 'http://localhost:9000'
const QUERY_API_URL = `${DATABASE_API_URL}/database`

class Query {

    executeQuery(vendor, url, id, password, query) {
        return axios.get(`${QUERY_API_URL}?vendor=${vendor}&url=${url}&id=${id}&password=${password}&query=${query}`);
    }

}

export default new Query()

