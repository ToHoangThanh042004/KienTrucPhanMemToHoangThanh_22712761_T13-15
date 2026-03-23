const { Client } = require('pg');

const client = new Client({
  connectionString: process.env.DATABASE_URL,
});

async function run() {
  try {
    await client.connect();
    console.log("Đã kết nối Postgres thành công!");

    // 1. Tạo bảng nếu chưa có
    await client.query(`
      CREATE TABLE IF NOT EXISTS users (
        id SERIAL PRIMARY KEY,
        name TEXT,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
      );
    `);

    // 2. Insert dữ liệu mẫu
    await client.query("INSERT INTO users (name) VALUES ('Gemini User')");
    
    // 3. Đọc dữ liệu ra để kiểm tra
    const res = await client.query("SELECT * FROM users");
    console.log("Dữ liệu hiện có trong DB:", res.rows);

  } catch (err) {
    console.error("Lỗi:", err);
  } finally {
    await client.end();
  }
}

run();