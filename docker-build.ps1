docker build -f .\frontend.Dockerfile -t frontend-image .
docker build -f .\backend.Dockerfile -t backend-image .
docker build -f .\database.Dockerfile -t database-image .

