
const ProductService = require('../services/product.service');
const CategoryService = require('../services/category.service');
const { successfullyResponse } = require('../core/reponseHandle');


class ProductController {
    async getAllProducts(req, res) {
        const products = await ProductService.getAllProducts();
        return new successfullyResponse({
            message: 'Successfully',
            data: products
        }).json(res);
    }

    async getAllProductsWithCategory(req, res) {
        const products = await ProductService.getAllProductsWithCategory();
        return new successfullyResponse({
            message: 'Successfully',
            data: products
        }).json(res);
    }

    async getAllProductsByCategory(req, res) {
        const categoryId = req.params.categoryId;
        const products = await ProductService.getAllProductsByCategory(categoryId);
        const nameCategory = await CategoryService.getCategoryById(categoryId);
        new successfullyResponse({
            message: 'Successfully',
            data: {
                nameCategory,
                products
            }
        }).json(res);
    }

    async getProductById(req, res) {
        const id = req.params.id;
        const product = await ProductService.getProductById(id);
       

        new successfullyResponse({
            message: 'Successfully',
            data: {
                products: product
            }
        }).json(res);
    }
}

module.exports = new ProductController();