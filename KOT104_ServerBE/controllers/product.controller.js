
const ProductService = require('../services/product.service');
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
        new successfullyResponse({
            message: 'Successfully',
            data: products
        }).json(res);
    }
}

module.exports = new ProductController();