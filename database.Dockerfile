# Use a MySQL base image for the database
FROM mysql:latest AS mysql-server
# The MySQL image checks this folder for the init script
COPY /init.sql /docker-entrypoint-initdb.d/