const amqp = require('amqplib');

async function send() {
  try {
    console.log('Connecting to RabbitMQ...');

    const conn = await amqp.connect('amqp://localhost');
    const channel = await conn.createChannel();

    const queue = 'chat_queue';
    const msg = 'Chao ban toi la soai ca go vap';

    await channel.assertQueue(queue);
    channel.sendToQueue(queue, Buffer.from(msg));

    console.log('Sent:', msg);

    setTimeout(() => {
      conn.close();
      process.exit(0);
    }, 500);

  } catch (err) {
    console.error('ERROR:', err);
  }
}

send();
