# Lightsaber System

This system is an example of lighsaber orders using the following technologies:

- Maven/JDK11
- Lombok
- Spring JMS IBM MQ

## Running Services

1. Run IBM MQ Service:

```bash
docker run -e LICENSE=accept -e MQ_QMGR_NAME=QMKINOBI -p 1414:1414 -p 9443:9443 -d ibmcom/mq
```

2. Access Console using https://localhost:9443/

|*User*      | admin   |
|------------|---------|
|*Password*  |passw0rd |

3.Create Local Queue

*Manage* > *Local Queue Manager* > *Create* >  *Local* > *Quick Create* 

Fill fields:

| *Queue Name*        | LIGHTSABER.ORDER.QUEUE |
|---------------------|------------------------|
| *Queue Description* | Lightsaber Order Queue |

4. Send Some Message:

*Manage* > *Local Queue Manager* > Choose *LIGHTSABER.ORDER.QUEUE* > *Create*

### IBM MQ Documentation:

If you want to read the full documentation use the following links:

[IBM MQ Usage](https://github.com/ibm-messaging/mq-container/blob/master/docs/usage.md)

[IBM MQ Developer Configuration](https://github.com/ibm-messaging/mq-container/blob/master/docs/developer-config.md)