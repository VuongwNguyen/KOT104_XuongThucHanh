const category  = require('../models/category.models');
const { errorResponse } = require('../core/reponseHandle');

class CategoryService {
    async getCategories() {
        return await category.findAll();
    }

    async getCategoryById(id) {
        return await category.findByPk(id,{
            attributes: ['name']
        });
    }
}

module.exports = new CategoryService();