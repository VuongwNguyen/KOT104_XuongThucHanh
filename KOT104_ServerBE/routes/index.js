const account = require('../models/account.models');
const category = require('../models/category.models');
const product = require('../models/product.models');

const router = require('express').Router();

router.post('/', async (req, res) => {
    res.json({
        message: 'Hello World'
    });
});



module.exports = router;

