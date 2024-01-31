FROM httpd:latest AS frontend-server
COPY /app/frontend /usr/local/apache2/htdocs/
EXPOSE 80