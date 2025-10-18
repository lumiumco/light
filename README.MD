# Light service

## How to build

1. `mvn clean package`
2. `docker build --tag=lumiumco/light:latest .`
3. `docker push lumiumco/light:latest`

or 

`mvn spring-boot:build-image -Dspring-boot.build-image.imageName=lumiumco/light:latest`

## How to install
`helm install light lumiumco/service -n -f ./values.yaml`