package com.amarerichard.utils

import com.amarerichard.config.config
import com.amarerichard.model.callModel.cProject
import com.rabbitmq.client.CancelCallback
import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.DeliverCallback
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.text.String
import kotlin.text.toByteArray

class RabbitMQFactory {
    private val connectionFactory : ConnectionFactory
    init {
        connectionFactory = ConnectionFactory()
        connectionFactory.setUri("amqp://zUcznfHORlXNSBVQ:U5qsUOYuXDc7yAHWe6hu4ZatVH~akfsL@viaduct.proxy.rlwy.net:21661")

    }

    fun getConnectionFactory() : ConnectionFactory
    {
        return connectionFactory
    }

    fun defaultChannelAndQueue(): RabbitMQFactory {

        getConnectionFactory().newConnection().run {
            this.createChannel().apply{
                this.exchangeDeclare(config.EXCHANGE_NAME, "direct", true);
                this.queueDeclare(config.QUEUE_NAME, true, false, false, null);
                this.queueBind(config.QUEUE_NAME, config.EXCHANGE_NAME, config.ROUTING_KEY);
                this.close()
            }
            this.close()
        }

        return this
    }

    fun sendMessage(message : ByteArray)
    {
        getConnectionFactory().newConnection().run {
            this.createChannel().apply {
                this.basicPublish(config.EXCHANGE_NAME, config.ROUTING_KEY,null, message)
                this.close()
            }
            this.close()
        }
    }




    fun listeningMessage()
    {
        val conn =  getConnectionFactory().newConnection()

        val chann = conn.createChannel()
        val deliverCallback = DeliverCallback { consumerTag, delivery ->
        val  message = String(delivery.body)

            println(message)

            //val reu = Json.decodeFromString<cProject>(message)

            sendMessage("est venu ${ Json.encodeToString(message)}".toByteArray())

        }
        val cancelCallback = CancelCallback{consumerTag ->
            println(" canceld ....  $consumerTag")
        }

        chann.basicConsume(config.QUEUE_NAME,true, deliverCallback,cancelCallback)


    }




}