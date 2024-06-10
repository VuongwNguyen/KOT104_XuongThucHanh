const { errorResponse } = require('../core/reponseHandle')
const product = require('../models/product.models')
const category = require('../models/category.models')

class ProductService {
    async getAllProducts() {
        return await product.findAll();
    }

    async getAllProductsWithCategory() {
        const categoriesWithProducts = await category.findAll({
            include: [{
                model: product,
                as: 'products'
            }]
        });

        // Định dạng kết quả theo yêu cầu
        const result = categoriesWithProducts.map(category => ({
            category: {
                id: category.id,
                name: category.name,
                description: category.description,
                createdAt: category.createdAt,
                updatedAt: category.updatedAt
            },
            products: category.products.map(product => ({
                id: product.id,
                name: product.name,
                description: product.description,
                price: product.price,
                image_url: product.image_url,
                categoryId: product.categoryId,
                createdAt: product.createdAt,
                updatedAt: product.updatedAt
            }))
        }));
        if (!result) throw new errorResponse({message: 'No product found', code: 400});

        return result;
    }

    async getAllProductsByCategory(categoryId) {
        return await product.findAll({
            where: {
                categoryId: categoryId
            }
        });
    }

    async getProductById(id) {
        return await product.findByPk(id);
    }
}
module.exports = new ProductService();