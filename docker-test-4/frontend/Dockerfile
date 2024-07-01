FROM node:latest


WORKDIR /src/app

RUN apt-get update && apt-get install -y netcat-traditional curl

COPY package*.json .


RUN npm install

COPY . .


COPY ./wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

EXPOSE 3000

CMD ["/wait-for-it.sh","backend","npm", "run", "dev"]