const router = require('express').Router();

router.get('/', async (req, res) => {
    res.json({
        message: 'Hello World'
    });
});

router.use('/api/account', require('./account.routes'));
router.use('/api/category', require('./category.routes'));
router.use('/api/product', require('./product.routes'));



module.exports = router;

