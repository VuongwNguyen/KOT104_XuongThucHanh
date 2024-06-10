const router = require('express').Router();

const ProductController = require('../controllers/product.controller');

router.get('/getAllProducts', ProductController.getAllProducts);
router.get('/getAllProductsWithCategory', ProductController.getAllProductsWithCategory);
router.get('/getAllProductsByCategory/:categoryId', ProductController.getAllProductsByCategory);
router.get('/getProductById/:id', ProductController.getProductById);

module.exports = router;