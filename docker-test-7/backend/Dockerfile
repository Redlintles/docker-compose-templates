FROM node:latest

WORKDIR /usr/src/app

COPY package*.json .

RUN npm install

RUN apt-get update && apt-get install netcat-traditional

COPY ./wait-for-it.sh /usr/local/bin/wait-for-it.sh

RUN chmod +x /usr/local/bin/wait-for-it.sh

COPY . .

CMD ["bash", "./wait-for-it.sh", "db", "27017", "--", "npm", "start"]

