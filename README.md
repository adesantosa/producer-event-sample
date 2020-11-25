# Spring Cloud Stream Function
Example using spring-cloud-stream with Kafka and using JSON as a serializer and deserializer.

### Frameworks
- Spring / Netty / Kafka

### Programming Language
- Java

### Hexagonal Architecture
In this application hexagonal architecture was used:

![hexa arch](https://viewer.diagrams.net/?highlight=0000ff&layers=1&nav=1&title=project.drawio#RxVfbbqMwEP2aPC4i5pLksUma7kqtlFWl7fYpcsCANwYjY3Lp1%2B8Y7AAh2zZVs6V9YI7HnnjmzLEZOLN0fydwnjzwkLABssP9wJkPEBq6CA3Uvx0eamQ0cmsgFjTUTg3wSF%2BIBm2NljQkRcdRcs4kzbtgwLOMBLKDYSH4rusWcdaNmuOY9IDHALM%2B%2BkRDmdTo2LMb%2FDuhcWIiD209kmLjrIEiwSHftSDnduDMBOeyfkv3M8JU8kxets%2F25kX4JX54Qovy5acrxK9v9WKLS6YctyBIJj93aV3cQh5MvkgI6dMmFzLhMc8wu23QqeBlFhK1qg1W43PPeQ7gEMA%2FRMqD5gIuJQcokSnTo7ALcfit51fGszIsz5jzfXtwftDWO9Og01XwUgTkFT%2Bn9lMbblFFJ%2B%2BO8JRAcHAQhGFJt10%2BYU3L%2BOh3nLrkFH4fsnULjXzNH91ARz6ZJSQWMZF6VlPAGyHwoeWWK4fi33H8ideN45%2Fw4S1%2F1PGHl%2FoXGKuVkwaqOHYB33TOt5iVOp89AkKb5eo1IXsMvIK650RQCExEgy4NBNmY7hIqyWOOq2rvQMa6dIvonhhhqm3GZpxxUcVzQo%2BMQxfwQgq%2BIa2RMVo7vn8x8bZESLJ%2FlVJ6FDkn1DDas2uUyploLGmpFHJPONSmYauClxfI%2FVpBsOyh1xUFhCZvyEJlLVscuYJW6FapW%2FXrNQXZE8uetJ4ujTzPAio1j%2FcuwfmsHvfe7nFeSkYz6DVz5quShbhIjixSTUThFL%2FHa8KWvKCSKi2Yr7mUPG053DAaqwGpuDbF2gqg7IoLbZYZYUn3sbrqWHhXOFYiZb7KBZc84KwvDh6auDPIzxSmhBQWNWMZz8gVleFEGIbjvjD4Tl8XQK2uIwv%2BB2sa8SZlkE74W6iovXTC2MT15gvUGptTAQvVZc%2BUqpwpz41jT71z2h1Vz39gldqhOVyQsXVWVEhc5HU6qmPoPA1dS5Bagn4E1YkHZv3W9UpxBtfVcAW7JTilWbyKuFhtcLTBV%2BTi6QXmHBlH4z4ZDfbpZBz1yHiT5wzKVlXzy%2B8TmIyj4Bwn%2FWBM1tE17xPm28wcBM6wf5%2BwkeX1izX8QLXAbL5%2B6tOj%2BYZ0bv8C)


### Prerequisites
- [docker](https://docker)
- [docker-compose](https://docker-compose)
- [postman](https://postman) or [curl](https://curl)
- [java >= 11](https://java)

### Running Application
- Go to the project directory
```
$ cd <project directory>
```
- Boot the Kafka infrastructure
```
$ docker-compose up
```
- Create a new topic
```
$ docker-compose exec broker kafka-topics --create --topic user-topic --partitions 1 --replication-factor 1 --if-not-exists --zookeeper zookeeper:2181
```
- Put a listener consumer
```
docker-compose exec broker kafka-console-consumer --topic user-topic --from-beginning --bootstrap-server localhost:9092
```
- Run the application
```
$ ./gradlew run
```
- Create a user (POST request)
```
$ curl --location --request POST 'http://localhost:8080/user' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "id": 001,
      "name": "André dos Santos"
  }'
```
- Look at the application log to view the message being produced according to this example.
