const router = require('express').Router();
const CategoryController = require('../controllers/category.controller');
const asyncHandler = require('../core/asyncHandler');

router.get('/getAllCategory', asyncHandler(CategoryController.getCategories));

module.exports = router;