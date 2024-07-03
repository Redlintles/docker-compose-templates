FROM php:8.0-apache

COPY . /var/www/html

# Wait for DB configuration
RUN apt-get update && apt-get install -y netcat-traditional git unzip
COPY wait-for-it.sh /usr/local/bin
RUN chmod +x /usr/local/bin/wait-for-it.sh


# Composer installation
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

# PHP extensions

RUN docker-php-ext-install mysqli

CMD ["/usr/local/bin/wait-for-it.sh", "db", "3306", "--", "apache2-foreground"]
