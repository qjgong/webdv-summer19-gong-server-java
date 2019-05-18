(function () {
    var userService = new AdminUserServiceClient();
    var rowTemplate;
    var tbody;
    var createUserBtn;
    var deleteUserBtn;

    jQuery(main);

    function main() {
        rowTemplate = jQuery('.wbdv-template');
        createUserBtn = jQuery('.wbdv-create');
        deleteUserBtn = jQuery('.wbdv-remove');

        tbody = jQuery('tbody');

        createUserBtn.click(createUser);
        deleteUserBtn.click(deleteUser);

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
        var id = getRandomInt(0, 999);

        var user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role,
            id: id,
        }

        userService
            .createUser(user)
            .then(renderUsers)
    }

    function getRandomInt(min, max) {
        min = Math.ceil(min);
        max = Math.floor(max);
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

    function findAllUsers() {
        userService.findAllUsers().then(renderUsers)
    }

    function findUserById() {

    }

    function deleteUser(event) {
        currentTarget = $(event.currentTarget)
        var tr = currentTarget.parent().parent().parent();
        tr.remove();
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
            rowClone.find('.wbdv-remove').click(deleteUser);

            tbody.append(rowClone);
        }

    }
})();
