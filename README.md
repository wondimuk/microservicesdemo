# Customer microservice

## Setup Prometheus for microservice to collect different metrics for monitoring
 - Add dependency :
   implementation 'io.micrometer:micrometer-registry-prometheus' 
- add configuration that help to expose metrics on predefined endpoint
  - management.endpoints.web.exposure.include=*
  - management.metrics.export.prometheus.enabled=true
- Add prometheus.yml with basic configuration
## Prometheus Metrics docker based

 - pull prometheus image: docker pull prom/prometheus:latest
 - create docker volume to store prometheus metrics data: docker volume create prometheus-volume
   - To check created volume: docker volume inspect prometheus-volume
 - run prometheus container and expose local port:  docker run --rm --detach --name myprometheus --publish 9090:9090 --volume prometheus-volume:/var/lib/docker/volumes/prometheus-volume/_data a9d16b313b86
   - docker run --rm --detach --name CONTAINER_NAME --publish HOST_PORT:CONTAINER_PORT --volume VOLUME_NAME:/path/in/container IMAGE_NAME
     - 'CONTAINER_NAME: This is the name you want to give to the running container.
     - HOST_PORT: The port on your host machine that you want to map to the container.
     - CONTAINER_PORT: The port inside the container that you want to expose.
     - VOLUME_NAME: The name you want to give to the Docker volume.
     - /path/in/container: The path within the container where the volume will be mounted.
     - IMAGE_NAME: The name of the Docker image you're using.
 - go to http://localhost:9090/
   - ![Screenshot 2023-08-05 at 1.28.26 PM.png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fph%2Fqjftkbxx02s35d0_5gvsgb140000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_PGNG9m%2FScreenshot%202023-08-05%20at%201.28.26%20PM.png)