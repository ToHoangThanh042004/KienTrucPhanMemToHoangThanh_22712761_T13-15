const sendSuccessNotification = (userId, orderId) => {
    console.log("\n" + "=".repeat(40));
    console.log(`🔔 NOTIFICATION SYSTEM`);
    console.log(`User [${userId}] đã đặt đơn hàng [#${orderId}] thành công!`);
    console.log("=".repeat(40) + "\n");
};

module.exports = { sendSuccessNotification };