# STAGE 1: Môi trường Build (Chỉ cần lúc tạo image)
FROM node:20-alpine AS builder
WORKDIR /app
COPY package*.json ./
# Cài đặt tất cả (bao gồm cả công cụ build nếu có)
RUN npm install
COPY . .

# STAGE 2: Môi trường Chạy (Tinh gọn nhất)
FROM node:20-alpine
WORKDIR /app
# Chỉ copy những thứ cực kỳ cần thiết để chạy container
COPY --from=builder /app/package*.json ./
RUN npm install --only=production
COPY --from=builder /app/src ./src

# Bảo mật: Không chạy quyền root
USER node
CMD ["node", "src/index.js"]