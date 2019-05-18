(function () {
    var userService = new AdminUserServiceClient();
    var rowTemplate;
    var tbody;
    var createUserBtn;
    var deleteUserBtn;
    var editUserBtn;
    var findUserBtn;

    jQuery(main);

    function main() {
        rowTemplate = jQuery('.wbdv-template');
        createUserBtn = jQuery('.wbdv-create');
        deleteUserBtn = jQuery('.wbdv-remove');
        editUserBtn =jQuery('.wbdv-edit');
        findUserBtn=jQuery('.wbdv-search');

        tbody = jQuery('tbody');


        createUserBtn.click(createUser);
        deleteUserBtn.click(deleteUser);
        editUserBtn.click(renderUser);
        findUserBtn.click(findUserById);

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
        currentTarget = $(event.currentTarget)
        const id = currentTarget.attr('id')

      userService.findUserById(id).then(renderUser);


    }

    function deleteUser(event) {
        deleteBtn = $(event.currentTarget)
        const id = deleteBtn.attr("id");
       userService.deleteUser(id).then(findAllUsers);



    }


    function updateUser() {

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
        currentTarget = $(user.currentTarget);
        const tr = currentTarget.parent().parent().parent().clone();


        $('#usernameFld').val( tr.find('.wbdv-username').html());
        $('#firstNameFld').val(tr.find('.wbdv-first-name').html());
        $('#lastNameFld').val(tr.find('.wbdv-last-name').html());
        $('#roleFld').val(tr.find('.wbdv-role').html());
    }

    function renderUsers(users) {

        tbody.empty();
        for (var u in users) {
            const user = users[u];
            const rowClone = rowTemplate.clone();
            rowClone.removeClass('webdv-hidden');
            rowClone.find('.wbdv-username').html(user.username);
            rowClone.find('.wbdv-password').html(user.password);
            rowClone.find('.wbdv-first-name').html(user.firstName);
            rowClone.find('.wbdv-last-name').html(user.lastName);
            rowClone.find('.wbdv-role').html(user.role);
            const deleteUserBtn = rowClone.find('.wbdv-remove');
            deleteUserBtn.click(deleteUser);
            deleteUserBtn.attr("id",user.id);
            rowClone.find('.wbdv-edit').click(renderUser);
            tbody.append(rowClone);
        }

    }
})();
