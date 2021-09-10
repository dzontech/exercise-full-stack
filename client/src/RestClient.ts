export default class RestClient {

    static baseURL = "http://localhost:8080"

    static async getVesti() : Promise<any>{

        const url = `${RestClient.baseURL}/vesti`
        const response = await fetch(url)
        return response.json()
    }

    static async getVest(id: number) : Promise<any> {

        const url = `${RestClient.baseURL}/vesti/${id}`
        const response = await fetch(url)
        return response.json()
    }

    static addComment(id: number, comment: any) : Promise<any> {

        const url =  `${RestClient.baseURL}/vesti/addComment/${id}`

        return fetch(
            url,
            {
                method: 'PUT',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(comment)
            }
        )
    }

    static deleteComment(id: number) : Promise<any> {
        const url = `${RestClient.baseURL}/vesti/deleteComment/${id}`

        return fetch(
            url,
            {
                method: 'DELETE'
            }
        )
    }
}