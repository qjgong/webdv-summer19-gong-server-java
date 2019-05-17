(function () {
    var userService = new AdminUserServiceClient();
    var rowTemplate;
    var tbody;
    var createUserBtn;

    jQuery(main);

    function main() {
        rowTemplate = jQuery('.wbdv-template');
        createUserBtn = jQuery('.wbdv-create');
        tbody = jQuery('tbody');

        createUserBtn.click(createUser);

        userService
            .findAllUsers()
            .then(renderUsers)
    }

    function createUser() {
        var usernameFld = $('#usernameFld');
        var passwordFld = $('#passwordFld');
        var firstNameFld = $('#firstNameFld');
        var lastNameFld = $('#lastNameFld');
        var roleFld = $('#roleFld');


        var username = usernameFld.val();
        var password = passwordFld.val();
        var firstName = firstNameFld.val();
        var lastName = lastNameFld.val();
        var role = roleFld.val();

        var user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role,
        }

        userService
            .createUser(user)
            .then(renderUsers)
    }

    function findAllUsers() {
        return fetch("http://localhost:8080/users")
            .then(function (response) {
                return response.json()
            })
    }

    function findUserById() {
    }

    function deleteUser() {
    }

    function selectUser() {
    }

    function updateUser() {
    }

    function renderUser(user) {
    }

    function renderUsers(users) {
        tbody.empty();
        for (var u in users) {
            const user = users[u];
            const rowClone = rowTemplate.clone();
            rowClone.removeClass('wbdv-hidden');
            rowClone.find('.wbdv-username').html(user.username);
            rowClone.find('.wbdv-first-name').html(user.firstName);
            rowClone.find('.wbdv-last-name').html(user.lastName);
            rowClone.find('.wbdv-role').html(user.role);


            tbody.append(rowClone);
        }

    }
})();
