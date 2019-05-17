function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'http://localhost:8080/api/users';
    var self = this;

    function createUser(user, callback) {
        return fetch('http://localhost:8080/users', {
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
        return fetch('http://localhost:8080/users')
            .then(function (response) {
                return response.json()
            })
    }

    function findUserById(userId, callback) {
    }

    function updateUser(userId, user, callback) {
    }

    function deleteUser(userId, callback) {
    }
}

