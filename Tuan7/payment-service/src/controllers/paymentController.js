const apiService = require('../services/apiService');
const notificationService = require('../services/notificationService');

const processPayment = async (req, res) => {
    const { orderId, userId, amount, method } = req.body;

    // Kiểm tra dữ liệu đầu vào cơ bản
    if (!orderId || !userId) {
        return res.status(400).json({ error: "Thiếu orderId hoặc userId" });
    }

    try {
        console.log(`[Payment] Đang xử lý ${amount} VND qua ${method}...`);

        // 1. Giả lập xử lý thanh toán (luôn thành công)
        const isSuccess = true; 

        if (isSuccess) {
            // 2. Gọi service để cập nhật trạng thái đơn hàng bên máy bạn số 4
            await apiService.updateOrderStatus(orderId, 'PAID');

            // 3. Gửi thông báo thành công
            notificationService.sendSuccessNotification(userId, orderId);

            return res.status(200).json({
                status: "success",
                message: "Thanh toán hoàn tất và đã cập nhật đơn hàng",
                data: { orderId, userId }
            });
        }
    } catch (error) {
        res.status(500).json({ 
            status: "error", 
            message: "Thanh toán thất bại do lỗi kết nối liên dịch vụ",
            detail: error.message 
        });
    }
};

module.exports = { processPayment };