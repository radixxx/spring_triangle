#! /bin/bash

docker pull mysql/mysql-server:latest
docker run -d -p 3306:3306 --name mysql-docker-container \
      -e MYSQL_ROOT_PASSWORD=springcourse \
      -e MYSQL_DATABASE=my_db \
      -e MYSQL_USER=bestuser \
      -e MYSQL_PASSWORD=bestuser mysql/mysql-server:latest
      sudo docker exec -it mysql-docker-container bash
      mysql -u root -p
