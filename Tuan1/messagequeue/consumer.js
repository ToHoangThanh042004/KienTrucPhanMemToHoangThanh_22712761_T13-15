const amqp = require('amqplib');

async function receive() {
  const conn = await amqp.connect('amqp://localhost');
  const channel = await conn.createChannel();

  const queue = 'chat_queue';
  await channel.assertQueue(queue);

  console.log('Waiting for messages...');
  channel.consume(queue, msg => {
    console.log('Received:', msg.content.toString());
    channel.ack(msg);
  });
}

receive();
