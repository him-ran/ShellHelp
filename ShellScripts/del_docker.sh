#!/bin/bash
# This shell script is used to delete the exited or created docker containers, ALL AT ONCE.

# Loading the docker container id's in the array.
docker_images=($(docker ps -a | grep -i "Exited\|Created" | awk '{print $1}'))

array_length=${#docker_images[@]}

# Removing the docker container's which are exited and in created state.
for ((i=0;i<$array_length;i++))
do
        container_id=${docker_images[$i]}
        docker rm -f $container_id
done
