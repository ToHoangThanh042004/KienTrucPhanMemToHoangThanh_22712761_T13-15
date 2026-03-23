# ==========================================
# STAGE 1: Giai đoạn Build (Chỉ dùng lúc tạo image)
# ==========================================
# Ta dùng image Node.js Alpine, một bản Linux siêu nhẹ (~5MB).
FROM node:20-alpine AS builder

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# BƯỚC QUAN TRỌNG TỐI ƯU HÓA CACHE: 
# Copy trước file package*.json để Docker cached được bước 'npm install'.
# Nếu package.json không đổi, Docker không cần tải lại thư viện.
COPY package*.json ./

# Cài đặt TẤT CẢ thư viện (Dependencies & DevDependencies)
# Lúc này, thư mục 'node_modules' sẽ rất nặng.
RUN npm install

# Copy toàn bộ code nguồn vào container.
COPY . .

# Nếu có bước biên dịch (TS -> JS, or Frontend build), bạn chạy ở đây:
# RUN npm run build 
# Sau bước này, ta có source code + node_modules nặng nề.

# ==========================================
# STAGE 2: Giai đoạn Production (Chỉ lấy thứ cần thiết)
# ==========================================
# Ta bắt đầu một stage mới hoàn toàn "sạch".
# Môi trường này chỉ cần Runtime Node.js để chạy app.
FROM node:20-alpine

# Thiết lập thư mục làm việc mới.
WORKDIR /app

# CHỈ CÀI ĐẶT PRODUCTION DEPENDENCIES:
# Copy package*.json sang một stage mới sạch sẽ.
COPY package*.json ./
# Chỉ cài đặt những thư viện cần để chạy (loại bỏ thư viện build, test...)
RUN npm install --only=production

# BƯỚC TỐI ƯU HÓA DUNG LƯỢNG CHÍNH:
# Ta CHỈ copy 'node_modules' (bản rút gọn) và file chạy ('src')
# từ stage 'builder' sang stage này.
# Toàn bộ source code gốc, npm cache, công cụ build thừa bị vứt bỏ ở Stage 1.
COPY --from=builder /app/src ./src

# TỐI ƯU HÓA BẢO MẬT:
# Không chạy app bằng quyền root, chuyển sang user 'node' có quyền thấp.
USER node

# Mở port cho container.
EXPOSE 3000

# Lệnh chạy ứng dụng.
CMD ["node", "src/index.js"]