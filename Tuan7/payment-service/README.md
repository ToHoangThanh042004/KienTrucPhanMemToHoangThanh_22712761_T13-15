# 💳 Payment Service - Mini Food Ordering System

> Service xử lý thanh toán & gửi thông báo trong hệ thống đặt đồ ăn nội bộ

## 📋 Chức năng

✅ Xử lý thanh toán (COD / Banking)  
✅ Cập nhật trạng thái đơn hàng (gọi Order Service)  
✅ Gửi thông báo khi thanh toán thành công  
✅ Lưu lịch sử thanh toán

---

## 🚀 Setup & Chạy

### 1️⃣ Cấu hình IP LAN

Trước tiên, tìm IP của máy bạn:

```bash
# Windows
ipconfig

# Linux/Mac
ifconfig
```

Sau đó, cập nhật file `.env`:

```env
PORT=8084
ORDER_SERVICE_URL=http://192.168.1.100:8083  # ← Thay IP đúng của Order Service
```

### 2️⃣ Cài đặt dependencies

```bash
npm install
```

### 3️⃣ Chạy Payment Service

**Chế độ development (auto-reload):**

```bash
npm run dev
```

**Hoặc chế độ production:**

```bash
npm start
```

Output khi khởi động thành công:

```
==================================================
🚀 Payment Service Started
==================================================
📍 URL: http://192.168.x.x:8084
🔗 Order Service: http://192.168.1.100:8083
📋 Health Check: http://192.168.x.x:8084/health
==================================================
```

---

## 📡 API Endpoints

### 1. Health Check

```
GET /health
```

**Response:**

```json
{
  "status": "UP",
  "service": "Payment Service",
  "ip": "192.168.1.50",
  "port": 8084
}
```

---

### 2. Xử lý Thanh toán

```
POST /payments
```

**Request Body:**

```json
{
  "orderId": "ORD-001",
  "userId": "user123",
  "amount": 150000,
  "method": "Banking"
}
```

**Parameters:**

- `orderId` (string, required): ID đơn hàng
- `userId` (string, required): ID người dùng
- `amount` (number, required): Số tiền (VND)
- `method` (string, required): COD hoặc Banking

**Response:**

```json
{
  "status": "success",
  "message": "Thanh toán hoàn tất",
  "data": {
    "paymentId": "PAY-1712424563890",
    "orderId": "ORD-001",
    "userId": "user123",
    "amount": 150000,
    "method": "Banking",
    "status": "SUCCESS",
    "timestamp": "2024-04-06T15:22:43.890Z"
  }
}
```

---

### 3. Lịch sử Thanh toán

```
GET /payments
```

**Response:**

```json
{
  "status": "success",
  "total": 3,
  "data": [
    {
      "paymentId": "PAY-1712424563890",
      "orderId": "ORD-001",
      "userId": "user123",
      "amount": 150000,
      "method": "Banking",
      "status": "SUCCESS",
      "timestamp": "2024-04-06T15:22:43.890Z"
    }
  ]
}
```

---

## 🧪 Test Service

### Cách 1: Dùng test script

```bash
node test-payment.js
```

### Cách 2: Dùng curl

```bash
# Health check
curl http://192.168.x.x:8084/health

# Process payment
curl -X POST http://192.168.x.x:8084/payments \
  -H "Content-Type: application/json" \
  -d '{
    "orderId": "ORD-001",
    "userId": "user123",
    "amount": 150000,
    "method": "Banking"
  }'

# Get history
curl http://192.168.x.x:8084/payments
```

### Cách 3: Dùng Postman

1. Import hoặc tạo request POST
2. URL: `http://192.168.x.x:8084/payments`
3. Body (JSON):

```json
{
  "orderId": "ORD-001",
  "userId": "user123",
  "amount": 150000,
  "method": "Banking"
}
```

---

## 📊 Quy trình xử lý

```
Frontend
   ↓
Payment Service (POST /payments)
   ├→ 1. Xác thực dữ liệu
   ├→ 2. Xử lý thanh toán
   ├→ 3. Gọi Order Service (PUT /orders/{orderId})
   ├→ 4. Gửi thông báo
   └→ Return response
```

---

## 🔧 Cấu trúc Project

```
src/
  ├── index.js              # Entry point, khởi tạo Express
  ├── controllers/
  │   └── paymentController.js  # Xử lý logic thanh toán
  ├── routes/
  │   └── paymentRoutes.js      # Định tuyến API
  └── services/
      ├── apiService.js         # Gọi Order Service
      └── notificationService.js # Gửi thông báo
.env                        # Cấu hình môi trường
package.json               # Dependencies
test-payment.js           # Script test API
```

---

## ⚠️ Common Issues

### ❌ Lỗi: "ECONNREFUSED - Connection refused"

**Giải pháp:** Kiểm tra IP và port của Order Service trong `.env`

### ❌ Lỗi: "CORS error"

**Giải pháp:** Service đã config CORS cho tất cả origin. Nếu vẫn lỗi, kiểm tra headers

### ❌ Lỗi: "Port already in use"

**Giải pháp:** Thay PORT trong `.env` hoặc kill process cũ

---

## 📝 Notes

- Thanh toán luôn giả lập thành công (không có logic real payment)
- Notification được log ra console (có thể mở rộng để gửi email/SMS)
- Lịch sử thanh toán lưu in-memory (reset khi restart server)
- CORS được config cho LAN (cho phép all origins)

---

## 🎯 Demo Kịch bản

Khi tất cả services chạy:

1. Frontend gọi `/payments` với đơn hàng
2. Payment Service nhận request
3. Thanh toán được xử lý
4. Order Service được cập nhật
5. Thông báo được gửi (log console)

```
[Payment] Xử lý thanh toán PAY-1712424563890...
   Order: #ORD-001 | User: user123 | Amount: 150000 VND | Method: Banking
[Payment] Gửi Order Service để update trạng thái...
   📤 Gửi: PUT http://192.168.1.100:8083/orders/ORD-001
[Payment] ✅ Order Service cập nhật thành công

==============================================================
🔔 NOTIFICATION SYSTEM
==============================================================
✅ User [user123] đã đặt đơn hàng [#ORD-001] thành công!
💰 Số tiền: 150000 VND
🏪 Phương thức: Banking
⏰ Thời gian: 6/4/2024, 22:22:43
==============================================================
```

---

## 📞 Support

Nếu có vấn đề, kiểm tra:

- ✅ Order Service có đang chạy? (`GET /health`)
- ✅ IP trong `.env` có đúng không?
- ✅ Port 8084 không bị occupied?
- ✅ Firewall có blocking port?

---

**Last Updated:** April 6, 2024  
**Author:** Payment Service Team  
**Version:** 1.0.0
