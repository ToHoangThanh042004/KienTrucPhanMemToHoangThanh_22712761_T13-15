const express = require("express");
const bodyParser = require("body-parser");

const {
  connectRabbitMQ,
  sendMessage,
  receiveMessage
} = require("./rabbitmq");

const app = express();
app.use(bodyParser.json());

// Chat API
app.post("/chat/send", (req, res) => {
  const { message } = req.body;
  sendMessage(message);
  res.send("Message sent");
});

// Start server
app.listen(3000, async () => {
  await connectRabbitMQ();
  receiveMessage();
  console.log("🚀 Server running at http://localhost:3000");
});
