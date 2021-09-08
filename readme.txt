demarrage kafka:
first start zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties
puis start kafka :
bin/kafka-server-start.sh config/server.properties

create topic : bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

s'abonner au topic test pour consommmer les messages:
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test -from-beginning


produire des messages vers topic:
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test


demarage Cluster :
cp config/server.properties config/server-1.proprrties
dedans :
broker.id=1
listeners=PLAINTEXT://:9093
log.dirs=/tmp/kafka-logs-1
start: bin/kafka-server-satart.sh config/serveur-1.properties


