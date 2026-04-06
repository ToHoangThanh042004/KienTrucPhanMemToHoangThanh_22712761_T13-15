const express = require('express');
const router = express.Router();
const paymentController = require('../controllers/paymentController');

// Định nghĩa route POST /payments
router.post('/', paymentController.processPayment);

module.exports = router;