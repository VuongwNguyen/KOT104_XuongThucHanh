const category  = require('../models/category.models');
const { errorResponse } = require('../core/reponseHandle');

class CategoryService {
    async getCategories() {
        return await category.findAll();
    }
}

module.exports = new CategoryService();