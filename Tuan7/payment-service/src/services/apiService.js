const axios = require('axios');

const updateOrderStatus = async (orderId, status) => {
    try {
        const url = `${process.env.ORDER_SERVICE_URL}/orders/${orderId}`;
        // Gọi PUT sang Spring Boot của bạn số 4
        const response = await axios.put(url, { status: status });
        return response.data;
    } catch (error) {
        console.error(`[Error] Không thể gọi Order Service tại ${orderId}:`, error.message);
        throw error;
    }
};

module.exports = { updateOrderStatus };