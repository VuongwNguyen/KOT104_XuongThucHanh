const {successfullyResponse} = require('../core/reponseHandle');
const CategoryService = require('../services/category.service');


class CategoryController {
    async getCategories(req, res) {
        return new successfullyResponse({
            message: 'Get categories successfully',
            data: await CategoryService.getCategories()
        }).json(res);
    }
}

module.exports = new CategoryController();