const amqp = require("amqplib");

const QUEUE = "chat_queue";
let channel;

async function connectRabbitMQ() {
  const connection = await amqp.connect("amqp://localhost");
  channel = await connection.createChannel();
  await channel.assertQueue(QUEUE);
  console.log("✅ RabbitMQ connected");
}

function sendMessage(message) {
  channel.sendToQueue(QUEUE, Buffer.from(message));
}

function receiveMessage() {
  channel.consume(QUEUE, (msg) => {
    if (msg !== null) {
      console.log("📩 Received:", msg.content.toString());
      channel.ack(msg);
    }
  });
}

module.exports = {
  connectRabbitMQ,
  sendMessage,
  receiveMessage
};
