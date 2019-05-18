(function () {
    var userService = new AdminUserServiceClient();
    var rowTemplate;
    var tbody;
    var input;
    var createUserBtn;
    var deleteUserBtn;
    var editUserBtn;
    var findUserBtn;
    var updateUserBtn;

    jQuery(main);

    function main() {
        rowTemplate = jQuery('.wbdv-template');
        createUserBtn = jQuery('.wbdv-create');
        deleteUserBtn = jQuery('.wbdv-remove');
        editUserBtn = jQuery('.wbdv-edit');
        findUserBtn = jQuery('.wbdv-search');
        updateUserBtn = jQuery('.wbdv-update');
        input=jQuery('input');
        tbody = jQuery('tbody');

        createUserBtn.click(createUser);
        deleteUserBtn.click(deleteUser);
        editUserBtn.click(selectUser);
        findUserBtn.click(findUserById);
        updateUserBtn.click(updateUser);


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
        currentTarget = $(event.currentTarget);
        const id = currentTarget.id
        return userService.findUserById(event).then(response => response);

    }

    function deleteUser(event) {
        deleteBtn = $(event.currentTarget);
        const id = deleteBtn.attr("id");
        userService.deleteUser(id).then(findAllUsers);

    }

    function updateUser(event) {
        updateBtn = $(event.currentTarget);
        const id = updateBtn.val();

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
            id:id,
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        }
        userService.updateUser(id, user).then(findAllUsers);
    }

    function renderUser(user) {
        /*
         tbody.empty();
         const rowClone = rowTemplate.clone();
         rowClone.removeClass('wbdv-hidden');
         rowClone.find('.wbdv-username').html(user.username);
         rowClone.find('.wbdv-first-name').html(user.firstName);
         rowClone.find('.wbdv-last-name').html(user.lastName);
         rowClone.find('.wbdv-role').html(user.role);
         rowClone.find('.wbdv-remove').click(deleteUser);
         //rowClone.find('.wbdv-edit').click(updateUser);

         tbody.append(rowClone);

 */


        $('#usernameFld').val(user.username)
        $('#firstNameFld').val(user.firstName)
        $('#passwordFld').val(user.password)
        $('#lastNameFld').val(user.lastName)
        $('#roleFld').val(user.role)
        updateUserBtn.val(user.id)
    }

    function selectUser(event) {

        selectBtn = $(event.currentTarget);
        const id = selectBtn.attr('id');
        updateUserBtn.click(updateUser)
        user = userService.findUserById(id).then(renderUser)


    }

    function renderUsers(users) {

        $('#usernameFld').val("")
        $('#firstNameFld').val("")
        $('#passwordFld').val("")
        $('#lastNameFld').val("")
        $('#roleFld').val("")

        tbody.empty();
        for (var u in users) {
            const user = users[u];
            const rowClone = rowTemplate.clone();
            rowClone.removeClass('webdv-hidden');
            rowClone.find('.wbdv-username').html(user.username);
            rowClone.find('.wbdv-password').html("*****");
            rowClone.find('.wbdv-first-name').html(user.firstName);
            rowClone.find('.wbdv-last-name').html(user.lastName);
            rowClone.find('.wbdv-role').html(user.role);
            const deleteUserBtn = rowClone.find('.wbdv-remove');
            deleteUserBtn.click(deleteUser);
            deleteUserBtn.attr("id", user.id);
            const editUserBtn = rowClone.find('.wbdv-edit');
            editUserBtn.click(selectUser);
            editUserBtn.attr("id", user.id);
            tbody.append(rowClone);
        }
    }
})();
