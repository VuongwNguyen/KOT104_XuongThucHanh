const account = require('../models/account.models');
const bcrypt = require('bcryptjs');
const { errorResponse } = require('../core/reponseHandle');

class AccountService {
    async createAccount({
        fullname,
        password,
        email
    }) {
        const accountExist = await account.findOne({
            where: {
                email
            }
        });
        if (accountExist) throw new errorResponse({ message: 'Email already exists', code: 400 });
        const hashPassword = bcrypt.hashSync(password, 10);
        return await account.create({
            fullname,
            email,
            password: hashPassword
        });
    }

    async login({
        email,
        password
    }) {
        const accountExist = await account.findOne({
            where: {
                email
            }
        });
        if (!bcrypt.compareSync(password, accountExist.password)) throw new errorResponse({ message: 'Username or password is incorrect', code: 400 });
        return accountExist;
    }

}

module.exports = new AccountService();