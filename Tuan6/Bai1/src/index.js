const { Client } = require('pg');

async function startApp() {
  const client = new Client({ connectionString: process.env.DATABASE_URL });
  
  // Logic Retry: Đợi Postgres khởi động xong
  let connected = false;
  while (!connected) {
    try {
      await client.connect();
      connected = true;
      console.log("✅ Đã kết nối Postgres thành công!");
    } catch (err) {
      console.log("❌ Đang đợi Postgres... thử lại sau 3s");
      await new Promise(resolve => setTimeout(resolve, 3000));
    }
  }

  try {
    // Tạo bảng và Insert dữ liệu
    await client.query("CREATE TABLE IF NOT EXISTS users (id SERIAL, name TEXT)");
    await client.query("INSERT INTO users (name) VALUES ('Bình Be')");
    
    // Đọc dữ liệu ra (Data Ready)
    const res = await client.query("SELECT * FROM users");
    console.log("📊 Dữ liệu hiện có:", res.rows);
  } finally {
    await client.end();
  }
}

startApp();