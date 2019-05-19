function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.searchUser=searchUser;
    this.url = 'http://localhost:8080/api/users';
    var self = this;

    function createUser(user, callback) {
        return fetch('http://localhost:8080/api/users', {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function (response) {
            return response.json()
        })
    }

    function findAllUsers(callback) {
        return fetch('http://localhost:8080/api/users')
            .then(function (response) {
                return response.json()
            })
    }

    function findUserById(userId, callback) {
        return fetch('http://localhost:8080/api/users/'+userId, {
            method: 'GET',
           // body: JSON.stringify(userId),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function (response) {
            return response.json()
        })
    }

    function updateUser(userId, user, callback) {

        return fetch('http://localhost:8080/api/users/'+userId, {
            method: 'PUT',
           body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function (response) {
            return response.json()
        })

    }

    function deleteUser(userId, callback) {
        return fetch('http://localhost:8080/api/users/'+userId, {
            method: 'DELETE',
            body: JSON.stringify(userId),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function (response) {
            return response.json()
        })
    }
    function searchUser(user,callback) {
        return fetch('http://localhost:8080/api/users/select',{
            method:'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function (response) {
            return response.json()

        })

    }

}

