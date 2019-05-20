(function () {
    let userService = new AdminUserServiceClient();
    let rowTemplate;
    let tbody;
    let createUserBtn;
    let deleteUserBtn;
    let editUserBtn;
    let findUserBtn;
    let updateUserBtn;
    let usernameFld, passwordFld, firstnameFld, lastNameFld, roleFld;

    $(main);

    function main() {
        usernameFld = $('#usernameFld');
        passwordFld = $('#passwordFld');
        firstnameFld = $('#firstNameFld');
        lastNameFld = $('#lastNameFld');
        roleFld = $('#roleFld');

        rowTemplate = $('.wbdv-template');
        createUserBtn = $('.wbdv-create');
        deleteUserBtn = $('.wbdv-remove');
        editUserBtn = $('.wbdv-edit');
        findUserBtn = $('.wbdv-search');
        updateUserBtn = $('.wbdv-update');
        tbody = $('tbody');

        createUserBtn.click(createUser);
        deleteUserBtn.click(deleteUser);
        editUserBtn.click(selectUser);
        findUserBtn.click(searchUser);
        updateUserBtn.click(updateUser);

        userService
            .findAllUsers()
            .then(renderUsers)
    }

    function createUser() {
        let roleVal="FACULTY";
        if(roleFld.val() !== null){
            roleVal = roleFld.val()
        }

        userService.createUser({
                                   username: usernameFld.val(),
                                   password: passwordFld.val(),
                                   firstName: firstnameFld.val(),
                                   lastName: lastNameFld.val(),
                                   role: roleVal
                               })
            .then(findAllUsers)
    }

    function findAllUsers() {
        userService.findAllUsers().then(renderUsers);
    }

    function findUserById() {

    }

    function deleteUser(event) {
        const id = $(event.currentTarget).attr("id");
        userService.deleteUser(id).then(findAllUsers);

    }

    function updateUser(event) {
        const id = $(event.currentTarget).val();
        userService.updateUser(id, {
            username: usernameFld.val(),
            password: passwordFld.val(),
            firstName: firstnameFld.val(),
            lastName: lastNameFld.val(),
            role: roleFld.val()
        }).then(findAllUsers);
    }

    function renderUser(user) {
        usernameFld.val(user.username);
        firstnameFld.val(user.firstName);
        passwordFld.val(user.password);
        lastNameFld.val(user.lastName);
        roleFld.val(user.role);
        updateUserBtn.val(user.id);
    }

    function selectUser(event) {
        const id = $(event.currentTarget).attr('id');
        updateUserBtn.click(updateUser);
        userService.findUserById(id).then(renderUser);

    }

    function renderUsers(users) {

        usernameFld.val("");
        firstnameFld.val("");
        lastNameFld.val("");
        roleFld.val("");

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

    function searchUser() {
        let roleVal="";
        if(roleFld.val() !== null){
            roleVal = roleFld.val()
        }
        userService.searchUser({
                                   username: usernameFld.val(),
                                   password: passwordFld.val(),
                                   firstName: firstnameFld.val(),
                                   lastName: lastNameFld.val(),
                                   role: roleVal
                               }).then(renderUsers);
    }

})();
