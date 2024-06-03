const AccountService = require('../services/account.service');
const { successfullyResponse } = require('../core/reponseHandle');


class AccountController {
    async createAccount(req, res) {
        const { fullname, password, email } = req.body;
        return new successfullyResponse({
            message: 'Account created successfully',
            data: await AccountService.createAccount({ fullname, password, email })
        }).json(res);
    }

    async loginAccount(req, res) {
        const { email, password } = req.body;
        return new successfullyResponse({
            message: 'Login successfully',
            data: await AccountService.login({ email, password })
        }).json(res);
    }


}

module.exports = new AccountController();
