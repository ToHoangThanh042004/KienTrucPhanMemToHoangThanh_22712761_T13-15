require('dotenv').config();
const express = require('express');
const cors = require('cors');
const paymentRoutes = require('./routes/paymentRoutes');

const app = express();

// Middleware
app.use(cors()); // Cho phép Frontend gọi vào
app.use(express.json()); // Đọc dữ liệu JSON từ request body

// Routes
app.use('/payments', paymentRoutes);

// Kiểm tra sức khỏe service (Health check)
app.get('/health', (req, res) => res.send('Payment Service is UP'));

const PORT = process.env.PORT || 9904;
app.listen(PORT, () => {
    console.log(`🚀 Payment Service chạy tại: http://localhost:${PORT}`);
    console.log(`🔗 Liên kết Order Service: ${process.env.ORDER_SERVICE_URL}`);
});