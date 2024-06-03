const router = require('express').Router();
const AccountController = require('../controllers/account.controller');
const asyncHandler = require('../core/asyncHandler');


router.post('/create', asyncHandler(AccountController.createAccount));
router.post('/login', asyncHandler(AccountController.loginAccount));


module.exports = router;