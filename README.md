Cloud Formation 

This projects consists on 4 json files which each one enables the infrastructure correspondly:

1. A VPC for configuring the network
2. A IAM for setting the permissions roles
3. A CLUSTER where our container will run with his task definition
4. A API for mapping the endpoints.

Before we create each stack for each json we have to create our docker image and push it in to the ECR repository

1. run `mvn clean install` . This will generate our java-docker.jar
2. login into AWS `aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 531720492547.dkr.ecr.us-east-1.amazonaws.com`
3. run `docker build -f Dockerfile -t dockerjava .`
4. run `docker tag dockerjava:latest 531720492547.dkr.ecr.us-east-1.amazonaws.com/dockerjava:latest`
5. run `docker push 531720492547.dkr.ecr.us-east-1.amazonaws.com/dockerjava:latest`

Code for creating a VPC stack:

`aws cloudformation create-stack --stack-name vpchector --template-body "file://$PWD/Documents/11 Semestre/Computo en la nube/Examen2/vpc.json"`

Code for creating a IAM stack:

`aws cloudformation create-stack --stack-name iamhector --template-body "file://$PWD/Documents/11 Semestre/Computo en la nube/Examen2/iam.json" --capabilities CAPABILITY_IAM`

Code for creating a Cluster stack:

`aws cloudformation create-stack --stack-name clusterhector --template-body "file://$PWD/Documents/11 Semestre/Computo en la nube/Examen2/cluster.json"`

Code for creating a API stack:

`aws cloudformation create-stack --stack-name apihector --template-body "file://$PWD//Documents/11 Semestre/Computo en la nube/demo/CloudFormation/api.json"`